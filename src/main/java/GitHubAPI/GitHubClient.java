package GitHubAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GitHubClient{

    private Retrofit buildRetrofit(OkHttpClient okHttpClient) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private OkHttpClient buildOkHttpClient() {

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(new BasicAuthInterceptor("RapG0d", "rgt654654"))
                .build();
    }

    public void start() {

        GitHubAp gitHubAp = buildRetrofit(buildOkHttpClient()).create(GitHubAp.class);




        Response<List<GithubRepoModel>> call = null;
        try {
            call = gitHubAp
                    .getUserName("RapG0d")
                    .execute();
            if (call.isSuccessful()){
                System.out.println(call.body());
                call.body().forEach(githubRepoModel -> System.out.println(githubRepoModel.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Response<GitAuthRepo> calll = null;
        try{
            calll = gitHubAp
                    .getUserDetails()
                    .execute();
            if (calll.isSuccessful()){
                System.out.println(call.body());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
