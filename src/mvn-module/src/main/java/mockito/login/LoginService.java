package mockito.login;

import java.util.ArrayList;
import java.util.List;

public class LoginService {

    private LoginRepository loginRepository = new LoginRepository();
    private List<String> usersLogged = new ArrayList<>();

    /**
     * Login a user
     * @param userForm
     * @return
     */
    public boolean login(UserForm userForm) throws LoginException //throws LoginException
    {
        System.out.println("LoginService.login " + userForm);
        // Preconditions
        checkForm(userForm);

        // Same user can not be logged twice
        String userName = userForm.getUserName();

        if(usersLogged.contains(userName))
            throw new LoginException(userName + " already logged");

        // Call to repository
        boolean login = loginRepository.login(userForm);

        if(login) {
            usersLogged.add(userName);
        }
        return login;
    }

    /**
     * Logout a user
     * @param userForm
     */
    public void logout(UserForm userForm) throws LoginException {
        System.out.println("LoginService.logout " + userForm);

        // Preconditions
        checkForm(userForm);

        // User should be logged beforehand
        String userName = userForm.getUserName();
        if(!usersLogged.contains(userName))
            throw new LoginException("username not logged");

        usersLogged.remove(userName);
    }

    public int getUserLoggedCount() { return usersLogged.size(); }

    private void checkForm(UserForm userForm) {
        assert userForm != null;
        assert userForm.getUserName() != null;
        assert  userForm.getPassword() != null;
    }

    static  class LoginException extends Exception {
        public LoginException(String message) { super(message); }
    }

}
