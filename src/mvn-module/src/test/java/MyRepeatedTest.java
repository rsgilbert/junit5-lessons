import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class MyRepeatedTest {
    final int REPEAT_TIMES = 3;


    @BeforeEach
    void setup() {
        System.out.println("Setup");
    }

    @RepeatedTest(2)
    void test() {
        System.out.println("Repeated test");
    }

    @RepeatedTest(value=REPEAT_TIMES, name="My {currentRepetition} out of {totalRepetitions} {displayName}")
    @DisplayName("Custom name test")
    void customNameTest() {
        System.out.println("Custom name");
    }

    @RepeatedTest(value=2, name=RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Long display name test")
    void longDisplayNameTest() {
        System.out.println("Long name");
    }

    @RepeatedTest(value=4, name=RepeatedTest.SHORT_DISPLAY_NAME)
    @DisplayName("Short name test")
    void shortDisplayNameTest() {
        System.out.println("Short name");
    }

}
