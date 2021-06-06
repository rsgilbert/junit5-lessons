package stdtests;

import stdtests.meta.MyDisabledOnOs;
import org.junit.jupiter.api.Test;
import stdtests.util.Os;

public class UseMyDisabledOnOsTest {

    @MyDisabledOnOs({Os.LINUX, Os.WINDOWS })
    @Test
    void conditionalBasedOnOsTest() {
        System.out.println("This test is running so it is not disabled for current OS");

    }

}
