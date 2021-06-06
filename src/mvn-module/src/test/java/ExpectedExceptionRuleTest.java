import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

@EnableRuleMigrationSupport
public class ExpectedExceptionRuleTest {


    @Rule
    // Make sure to mark this rule public because Junit4 expects it to be public
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void throwsNothing() {
        thrown.expect(IllegalArgumentException.class);
        throw new IllegalArgumentException();

    }
    @Test
    void throwsNPE(){
        thrown.expect(NullPointerException.class);
        throw new NullPointerException("testing expected exceptions");
    }

}
