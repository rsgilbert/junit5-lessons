package adv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * JUnit4 support for parameterized tests.
 * Uses the parameterized runner.
 * Does not create tests at runtime but repeats the same test
 * several times depending on the parameters
 */
@RunWith(Parameterized.class)
public class JUnit4ParameterizedTest {

    @Parameterized.Parameter(0)
    public Integer input1;

    @Parameterized.Parameter(1)
    public String input2;

    @Parameterized.Parameters(name="My test #{index} -- input data: {0} and {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, "hello"}, {2, "goodbye"}, {3, "au revoir"}
        });
    }

    @Test
    public void myParaTest() {
        System.out.println(input1 + " *** " + input2);
    }



}
