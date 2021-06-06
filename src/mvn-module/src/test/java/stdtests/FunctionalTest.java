package stdtests;

import stdtests.meta.Functional;
import org.junit.jupiter.api.Test;

/**
 * Use stdtests.meta-annotation @Functional to tag the test class as "functional"
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
