package adv;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test interfaces
 */
public interface TestLifecycleLogger {

    Logger log = LoggerFactory.getLogger(TestLifecycleLogger.class.getName());

    @BeforeAll
    static void beforeAllTests() {
        log.info("Before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        log.info("after all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        log.info("Before executing {}", testInfo.getDisplayName());
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        log.info("After executing {}", testInfo.getDisplayName());
    }
}
