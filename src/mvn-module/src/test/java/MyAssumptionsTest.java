import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class MyAssumptionsTest {

    @Test
    void assumeTrueTest() {
        assumeTrue(false);
        fail("Test 1 failed");
    }

    @Test
    void assumeFalseTest() {
        assumeFalse(this::getTrue);
        System.out.println("Hello");
        fail("Test 2 failed");
    }

    private boolean getTrue() { return true; }

    @Test
    void assumingThatTest() {
        assumingThat(false, () -> fail("Test 3 failed"));
        System.out.println("Assuming that test passed");
    }
}
