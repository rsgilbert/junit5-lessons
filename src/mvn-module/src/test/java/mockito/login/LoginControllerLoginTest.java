package mockito.login;

import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginControllerLoginTest {

    // Mocking objects
    // SUT
    @InjectMocks
    LoginController loginController;

    // DOC
    @Mock
    LoginService loginService;

    // Test data
    final UserForm userForm = new UserForm("Potato", "Chips");

    @Test
    void testLoginOK() throws LoginService.LoginException {
        // Setting expectation
        when(loginService.login(userForm)).thenReturn(true);

        // Exercise SUT
        String responseLogin = loginController.login(userForm);

        // Verification
        assertEquals("OK", responseLogin);
        verify(loginService).login(userForm);
        verifyZeroInteractions(loginService);
    }

    @Test
    void testLoginKO() throws LoginService.LoginException {
        when(loginService.login(userForm)).thenReturn(false);

        String responseLogin = loginController.login(userForm);

        assertEquals("KO", responseLogin);
        verify(loginService).login(userForm);
        verifyNoInteractions(loginService);
    }

}
