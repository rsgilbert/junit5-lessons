import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;



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
}
