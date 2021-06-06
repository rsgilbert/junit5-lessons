import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Execute dynamic tests
 * The tests were created at runtime
 */
public class DynamicExampleTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        Stream<String> inputStream = Stream.of("aah", "ba", "cha", "dah");
        return inputStream.map(
                input -> DynamicTest.dynamicTest("Input " + input,
                        () -> System.out.println("Testing " + input)
                )
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestInputsAreLessThan10() {

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
}
