package GitHubAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class GitHubClient implements Callback<List<GithubRepoModel>> {


    private static final String BASE_URL = "https://api.github.com/";

    public void start() {


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setLenient()
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

         GitHubAp gitHubAp = retrofit.create(GitHubAp.class);

        Call<List<GithubRepoModel>> call = gitHubAp.getUserName("RapG0d");
        call.enqueue(this);

    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void onResponse(Call<List<GithubRepoModel>> call, Response<List<GithubRepoModel>> response) {
        if(response.isSuccessful()){
            List<GithubRepoModel> list = response.body();
            assert list != null;
            list.forEach(githubRepoModel -> System.out.println(githubRepoModel.getName()));
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void onFailure(Call<List<GithubRepoModel>> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
