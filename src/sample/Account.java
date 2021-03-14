package sample;

public class Account {
    private final String username;
    private final String password;

    //creating generated accounts to simplify problems
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
