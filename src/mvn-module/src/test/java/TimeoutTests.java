import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests involving timeouts")
public class TimeoutTests {

    @Test
    @DisplayName("Adequate time test")
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(5), () -> {
            // Perform tasks that last less than 5 minutes
            assert true;
        });
    }

    @Test
    @DisplayName("Not enough time test")
    void timoutExceeded() {
        // Note that the test will not stop until the long running operation has completed
        // The operation will complete even though exceeding the timeout and only after that will
        // we get an error
        assertTimeout(ofMillis(1), () -> {
            long THREAD_SLEEP_MILLIS = 3000L;
            Thread.sleep(THREAD_SLEEP_MILLIS);
        });
    }

    @Test
    @DisplayName("assertTimeout with result from lambda function test")
    void timeoutNotExceededWithResult() {
        String expectedResult = "Hi There";
        String actualResult = assertTimeout(ofMinutes(1), () -> expectedResult);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    @DisplayName("Timeout test with result from method reference test")
    void timoutNotExceedWithMethod() {
        String actualGreeting = assertTimeout(ofMinutes(1L),
                TimeoutTests::greeting);
        assertEquals(greeting(), actualGreeting);
    }

    private static String greeting() {
        return "Hello World";
    }

    @Test
    @DisplayName("Timeout with preemptive termination test")
    void timeoutExceededWithPreemptiveTerminationTest() {
        // When the timeout is exceeded, instantly the test is declared as failure;
        assertTimeoutPreemptively(ofMillis(5), () -> {
            Thread.sleep(300L);
        });
    }

    @Test
    @DisplayName("Fail test before preemtpive timeout is exceeded test")
    void failBeforePreemptiveTimeout() {
        assertTimeoutPreemptively(ofMillis(5L), () -> {
            fail("Manually fail test before preemptive timeout");
            Thread.sleep(10);
        });
    }

    @Test
    @DisplayName("Fail test before timeout is exceeded test")
    void failBeforeTimeout() {
        assertTimeout(ofMillis(5000L), () -> {
            fail("Manually fail test before preemptive timeout");
            Thread.sleep(3000);
        });
    }
}
