import org.junit.jupiter.api.*;


public class MyLifeCycleJUnit5Test {
    @BeforeAll
    static void setupAll() {
        System.out.println("Setup all tests in the class");

    }

    @BeforeEach
    void setup() {
        System.out.println("Setup Each test in the class");
    }

    @Test
    void testOne() {
        System.out.println("Tested method one");
    }

    @Disabled
    @Test
    void testTwo() {
        System.out.println("Tested method two");
    }

    @Disabled("test three is disabled")
    @Test
    void testThree() {
        System.out.println("Tested method three");
    }

    @AfterEach
    void teardownEach() {
        System.out.println("Teared down for each method");
    }

    @AfterAll
    static void teardownAll() {
        System.out.println("Tear down for all tests");
    }
}
