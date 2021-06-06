import org.junit.jupiter.api.Test;

public class TestLifecycleImpl implements TestLifecycleLogger{

    @Test
    void simpleTest() {
        log.info("HI, I am a simple test");
    }

    @Test
    void anotherSimpleTest() {
        log.info("Don't mind me. Just another simple test");
    }
}
