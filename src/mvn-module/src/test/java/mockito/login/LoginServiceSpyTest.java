package mockito.login;


import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test using a spy object. A spy uses the real implementation in non-stubbed methods
 * We assess the real system in the test since we are not programming expectations
 */
@ExtendWith(MockitoExtension.class)
public class LoginServiceSpyTest {

    @InjectMocks
    LoginService loginService;

    @Spy
    LoginRepository loginRepository;

    UserForm userOk = new UserForm("user1", "p1");
    UserForm userKo = new UserForm("Failed", "user");

    @Test
    void testLoginOk() throws LoginService.LoginException {
        assertTrue(loginService.login(userOk));
    }

    @Test
    void testLoginKo() throws LoginService.LoginException {
        assertTrue(loginService.login(userKo));
    }
}
