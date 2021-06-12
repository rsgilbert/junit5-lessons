package mockito.login;

import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class LoginControllerErrorTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    UserForm userForm = new UserForm("My", "tide");

    @Test
    void testLoginErrorNullUserForm() {
        // Exercise
        String response = loginController.login(null);

        // Verify
        assertEquals("ERROR", response);
    }

    @Test
    void testLoginException() throws LoginService.LoginException {
        // Expectation
        when(loginService.login(any(UserForm.class)))
                .thenThrow(LoginService.LoginException.class);

        // Exercise
        String response = loginController.login(userForm);

        // Verify
        assertEquals("Exception ERROR", response);

    }
}
