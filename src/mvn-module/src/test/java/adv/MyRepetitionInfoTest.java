package adv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;


/**
 * Tests the use of RepetitionInfo as a parameter to test method
 * The repetitionInfo is supplied by RepetitionInfoParameterResolve using DI
 */
public class MyRepetitionInfoTest {

    @RepeatedTest(4)
    void simpleRepetitionTest(RepetitionInfo repetitionInfo)    {
        System.out.println(" Test " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getTestMethod());
    }
}
