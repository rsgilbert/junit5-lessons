import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("non-functional")
public class NonFunctionalTest {

    @Test
    @Tag("performance")
    @Tag("load")
    void testOne() {
        System.out.println("Non-functional test 1 (Performance / Load)");
    }

    @Test
    @Tag("performance")
    @Tag("stress")
    void testTwo() {
        System.out.println("Non-functional test 2 (Performance / Stress)");
    }

    @Test
    @Tag("security")
    void testThree() {
        System.out.println("Non-functional Test 3 (Security)");
    }

    @Test
    @Tag("usability")
    void testFour(){
        System.out.println("Non-functional test 4 (Usability)");
    }
}
