package adv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestLifecycleImpl implements TestLifecycleLogger, TestInterfaceDynamicTest, TimeExecutionLogger {

    @Test
    void simpleTest() {
        dynamicTestInputsAreLessThan10();
        log.info("HI, I am a simple test");
    }

    @Test
    void anotherSimpleTest() {
        log.info("Don't mind me. Just another simple test");
    }
}
