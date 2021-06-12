package mockito.login;


import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @InjectMocks
    LoginService loginService;

    @Mock
    LoginRepository loginRepository;

    final UserForm userForm = new UserForm("my", "form");

    @Test
    void testLoginSuccess() throws LoginService.LoginException {
        when(loginRepository.login(userForm)).thenReturn(true);
        assertTrue(loginService.login(userForm));
        verify(loginRepository, atLeast(1)).login(userForm);
    }

    @Test
    void testLoginFailed() throws LoginService.LoginException {
        when(loginRepository.login(userForm)).thenReturn(false);
        assertFalse(loginService.login(userForm));
        verify(loginRepository, atMostOnce()).login(userForm);
        verify(loginRepository, atLeastOnce()).login(userForm);
    }

    /**
     * Verify that a second login throws an error
     * @throws LoginService.LoginException
     */
    @Test
    void testLoginTwice() throws LoginService.LoginException {
        when(loginRepository.login(userForm)).thenReturn(true);
        assertTrue(loginService.login(userForm));
        assertThrows(LoginService.LoginException.class, () -> loginService.login(userForm));
    }
}
