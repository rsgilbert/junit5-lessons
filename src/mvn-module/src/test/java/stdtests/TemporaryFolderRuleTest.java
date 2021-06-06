package stdtests;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

/**
 * Uses a JUnit4 TemporaryFolder rule within a Jupiter test
 */
@EnableRuleMigrationSupport
public class TemporaryFolderRuleTest {

    @Rule
    TemporaryFolder temporaryFolder = new TemporaryFolder();

    @BeforeEach
    void setup() throws IOException {
        temporaryFolder.create();
    }


    @Test
    void test() {
        System.out.println("Temporary folder path: " + temporaryFolder.getRoot());
    }

    @AfterEach
    void tearDown() {
        temporaryFolder.delete();
    }
}
