import meta.Functional;
import meta.Load;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Use meta-annotation @Functional to tag the test class as "functional"
 */
@Functional
public class FunctionalTest {

    @Test
    void testOne() {
        System.out.println("Functional test 1");
    }

    @Test
    void testTwo() {
        System.out.println("Functional test 2");
    }
}
