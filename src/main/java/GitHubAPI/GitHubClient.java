package GitHubAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class GitHubClient implements Callback<List<GithubRepoModel>> {


    private static final String BASE_URL = "https://github.com/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

         GitHubAp gitHubAp = retrofit.create(GitHubAp.class);

        Call<List<GithubRepoModel>> call = gitHubAp.getUserName("user:RapG0d");
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
