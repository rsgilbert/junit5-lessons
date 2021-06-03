import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Run a unit test written with junit5 api but using junit4 framework.
 * We use the JUnitPlatform runner which runs the test using junit4 framework/runner
 */
@RunWith(JUnitPlatform.class)
public class Junit5OnAJunit4IdeTest {

    @Test
    public void testOnePlusOneEqualsTwoUsingJunit5ApiTest() {
        String message = "This JUnit5 test should succeed when running with a JUnit4 runner";
        System.out.println(message);
        assertEquals(2, 2, message);
    }
}
