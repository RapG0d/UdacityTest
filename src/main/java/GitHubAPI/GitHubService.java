package GitHubAPI;

import org.testng.annotations.Test;

public class GitHubService {

    @Test
    public void main(){
        GitHubClient gitHubClient = new GitHubClient();
        gitHubClient.start();
    }
}
