package stdtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class HamcrestTest {

    @Test
    @DisplayName("Hamcrest assertThat test")
    void assertWithHamcrestMatcherTest() {
        assertThat(2 + 1, equalTo(3));
        assertThat("Three", containsString("ee"));
        assertThat("Hi you", notNullValue());
    }
}
