package GitHubAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class GitHubClient{


//    private static final String BASE_URL = "https://api.github.com/";

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
//                .authenticator(getBasicAuthenticator())
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(chain -> {
                    Request.Builder builder = chain.request().newBuilder();
                    return chain.proceed(builder.build());
                })
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


    }

}
