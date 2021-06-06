package stdtests;

import stdtests.meta.Load;
import stdtests.meta.Security;
import stdtests.meta.Stress;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("non-functional")
public class NonFunctionalTest {

    @Test
    // Tag with stdtests.meta-annotation @Load
    @Load
    void testOne() {
        System.out.println("Non-functional test 1 (Performance / Load)");
    }

    @Test
    // Tag with stdtests.meta-annotation @Stress
    @Stress
    void testTwo() {
        System.out.println("Non-functional test 2 (Performance / Stress)");
    }

    @Test
    // Tag with stdtests.meta-annotation @Security
    @Security
    void testThree() {
        System.out.println("Non-functional Test 3 (Security)");
    }

    @Test
    @Tag("usability")
    void testFour(){
        System.out.println("Non-functional test 4 (Usability)");
    }
}
