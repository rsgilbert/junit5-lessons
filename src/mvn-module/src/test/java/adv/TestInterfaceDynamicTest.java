package adv;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TestFactory on a default method in a java interface
 */
public interface TestInterfaceDynamicTest {

    @TestFactory
    default Stream<DynamicTest> dynamicTestInputsAreLessThan10() {

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 9, 12);
        return intStream.map(
                input -> DynamicTest.dynamicTest(
                        "Input " + input,
                        () -> {
                            System.out.println("Tested on input " + input);
                            assertThat(input < 10, is(true));
                        }
            ));
    }

    /**
     * Dynamic tests to check that all input strings have letter e
     * To run this test factory you will need to run the entire test class that implements this factory
     * @return
     */
    @TestFactory
    default Collection<DynamicTest> dynamicTestInputStringsHaveLetterE() {
        List<String> inputStrings = Arrays.asList("Good", "boy", "Geoffrey");
        List<DynamicTest> dynamicTests = new ArrayList<>();
        for(String inputString: inputStrings) {
            String displayName = "InputString " + inputString;
            Executable executable = () ->
                    assertThat(inputString, containsString("e"));
            DynamicTest dynamicTest = DynamicTest.dynamicTest(displayName, executable);
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }
}
