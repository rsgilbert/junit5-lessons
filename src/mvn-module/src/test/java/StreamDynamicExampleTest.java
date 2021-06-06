import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Creating dynamic tests using static method stream of class DynamicTest
 */
public class StreamDynamicExampleTest {

    @TestFactory
    Stream<DynamicTest> streamInputIsEvenTest() {
        // Input data
        Integer[] array = {1, 2, 3};
        Iterator<Integer> inputGenerator = Arrays.asList(array).iterator();

        // Display names
        Function<Integer, String> displayNameGenerator = (input) -> "Data input: " + input;

        // Test executor
        // Input must be even
        ThrowingConsumer<Integer> testExecutor = (input) -> {
            System.out.println(input);
            assertEquals(0, input % 2);
        };

        // Returns a stream of dynamic tests
        return stream(inputGenerator, displayNameGenerator, testExecutor);
    }
}
