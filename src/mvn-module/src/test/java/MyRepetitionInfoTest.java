import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;


/**
 * Tests the use of RepetitionInfo as a parameter to test method
 * The repetitionInfo is supplied by RepetitionInfoParameterResolve using DI
 */
public class MyRepetitionInfoTest {

    @RepeatedTest(4)
    void simpleRepetitionTest(RepetitionInfo repetitionInfo)    {
        System.out.println(" Test " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
    }
}
