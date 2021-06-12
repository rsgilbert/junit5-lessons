package mockito.login;

import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class LoginControllerBDDMockito {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    UserForm userForm = new UserForm("User", "Potat");
    UserForm userForm2 = new UserForm("Jerry", "Can");
    UserForm validUser = new UserForm("user3", "p5");

    @Test
    void testLoginOK() throws LoginService.LoginException {
        given(loginService.login(userForm)).willReturn(true);
        assertEquals("OK", loginController.login(userForm));
//        assertEquals("OK", new LoginController().login(validUser));
    }

    @Test
    void testLoginKO() throws LoginService.LoginException {
        given(loginService.login(userForm)).willReturn(false);
        assertEquals("KO", loginController.login(userForm));
    }

    @Test
    void testLoginThrow() throws LoginService.LoginException {
        given(loginService.login(userForm))
                .willThrow(LoginService.LoginException.class);
        assertEquals("Exception ERROR", loginController.login(userForm));
    }

}
