package mockito.login;

import mockito.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class LoginServiceCaptureArgumentTest {

    @InjectMocks
    LoginService loginService;

    @Mock
    LoginRepository loginRepository;

    @Captor
    ArgumentCaptor<UserForm> argumentCaptor;

    UserForm userForm = new UserForm("Good", "riddance");

    /**
     *  Verify that we are providing the correct arguments to the mock object ie login repository
     *
     * @throws LoginService.LoginException
     */
    @Test
    void testArgumentCapture() throws LoginService.LoginException {
        loginService.login(userForm);
        verify(loginRepository).login(argumentCaptor.capture());
        assertEquals("Good", argumentCaptor.getValue().getUserName());
        assertEquals(userForm, argumentCaptor.getValue());
    }
}
