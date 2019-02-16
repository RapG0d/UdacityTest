package GitHubAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GitHubAp {
    @GET("/users/{user}")
    Call<List<GithubRepoModel>> getUserName(@Path("user") String user);

}
