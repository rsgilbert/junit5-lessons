package mockito.login;

import java.util.HashMap;
import java.util.Map;

public class LoginRepository {

    Map<String, String> users;

    public LoginRepository() {
        users = new HashMap<>();
        users.put("user1", "p1");
        users.put("user2", "p2");
        users.put("user3", "p5");
    }

    public boolean login(UserForm userForm) {
        System.out.println("LoginRepository.login " + userForm);
        String userValue = users.get(userForm.getUserName());
        return userValue.equals(userForm.getPassword());
    }

    public void logout(UserForm userForm) {}
}
