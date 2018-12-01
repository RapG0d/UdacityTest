package Models;

public class User {

    private String login;
    private String password;
    private String name;
    private String lastName;

    public User(String login, String password,String name,String lastName){
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;

    }

    public String getLogin(){return login;}

    public String getPassword(){return password;}

    public String getName(){return name;}

    public String getLastName(){return lastName;}
}
