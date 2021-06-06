package stdtests;

/*
Commented out because I want to comment out junit4 migration support in pom so
org.junit.Test et cetera is not shown by autocompletion
 */

//import org.junit.Rule;
//import org.junit.jupiter.api.Assumptions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
//import org.junit.rules.ErrorCollector;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Use the ErrorCollector JUnit4 rule in JUnit5 jupiter test
// */
//@EnableRuleMigrationSupport
//public class ErrorCollectorRuleTest {
//
//    @Rule
//    public ErrorCollector collector = new ErrorCollector();
//
//    @Test
//    @DisplayName("collect errors and report all of them at once test")
//    void collectErrorsTest() {
//        collector.checkThat("a", equalTo("c"));
//        collector.checkThat(1, equalTo(1));
//        collector.checkThat("green", containsString("rep"));
//    }
//
//    @Test
//    @DisplayName("normal tests fail right away without checkout other assertions test")
//    void failRightAway(){
//        fail("Right away failure");
//        fail("Second failure not checked");
//    }
//}
//
