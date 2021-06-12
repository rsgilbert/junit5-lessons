package adv;

import org.junit.jupiter.api.*;


/**
 * Use the TestInfo API to get information about tests at runtime.
 * Uses Dependency Injection
 * The builtin resolver TestInfoParameterResolver supplies an instance of TestInfo at runtime
 */
public class MyTestInfoTest {


    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        System.out.printf("@BeforeEach : %s %n", displayName);
    }

    @Test
    @DisplayName("My nice test")
    @Tag("my-cool-tag")
    void coolTest(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestClass());
        System.out.println(testInfo.getTestMethod());
    }

    @Test
    @DisplayName("Control test")
    void controlTest() {}
}
