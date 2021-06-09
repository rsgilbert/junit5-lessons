import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestType {

    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    void checkObj() {
        // Output: INFO: Obj true is of type class java.lang.Boolean
        Object obj = true;
        log.info("Obj {} is of type {}", new Object[] {obj, obj.getClass()});
    }

}
