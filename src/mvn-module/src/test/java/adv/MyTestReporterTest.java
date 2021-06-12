package adv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;

/**
 * TestReporter is used to publish additional data about test execution
 */
public class MyTestReporterTest {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("myKey", "myValue");
    }

    // Reports values manually added/published when
    // the test is run
    @Test
    void reportSeveralValues(TestReporter testReporter) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","Johnny");
        map.put("last", "Cage");
        testReporter.publishEntry(map);
    }

    // Control test
    // Shows nothing when run
    @Test
    void controlTest(){}
}
