package mockito.login;

public class UserForm {

    private final String userName;
    private String password;

    public UserForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserForm [username: " + userName + ", password: " + password + "]";
    }

    public String getPassword() {
        return password;
    }
}
