import meta.Load;
import meta.Security;
import meta.Stress;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("non-functional")
public class NonFunctionalTest {

    @Test
    // Tag with meta-annotation @Load
    @Load
    void testOne() {
        System.out.println("Non-functional test 1 (Performance / Load)");
    }

    @Test
    // Tag with meta-annotation @Stress
    @Stress
    void testTwo() {
        System.out.println("Non-functional test 2 (Performance / Stress)");
    }

    @Test
    // Tag with meta-annotation @Security
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
