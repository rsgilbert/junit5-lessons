import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardAssertionsTest {


    @Test
    @DisplayName("Test assertions")
    void standardAssertions() {
        assertEquals(2, 2);
        assertTrue(true, "This is assertion is true");
        assertFalse(false, () -> "Lambda for long messages");

    }

    @Test
    @DisplayName("Grouped test with assertAll")
    void groupedAssertions() {
        String name = "John Lugalu";
        // All assertions are executed
        // Any failures will be reported together
        assertAll("Multiple assertions on name",
                () -> assertEquals("John Lugalu", name, "Name not matching"),
                () -> assertEquals(name.length(), 11),
                () -> assertFalse(name.isEmpty(), "Name can not be empty")
        );
    }

    @Test
    @DisplayName("Test throwing exceptions with assertThrow")
    void assertThrowTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("You provided an illegal argument");
                });
        assertEquals("You provided an illegal argument", exception.getMessage());
    }
}
