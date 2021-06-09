import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

public class MyParameterizedTest {

    Logger log = LoggerFactory.getLogger(getClass());

    // -- value source --
    @ParameterizedTest
    @ValueSource(strings={"Hello", "Young", "Lady"})
    @DisplayName("Value Source of Strings test")
    void testWithStrings(String argument) {
        System.out.println("Value parameterized test with argument " + argument);
        assertNotNull(argument);
        assertSame(argument.getClass(), String.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 16})
    @DisplayName("Value source of integers test")
    void isEvenTest(int argument) {
        log.info("Argument is {}", argument);
        assertEquals(argument % 2, 0, "Must be even");
    }

    // -- Enum source --
    private enum Vehicle { CAR, LORRY, BUS, TAXI }

    @ParameterizedTest
    @EnumSource(Vehicle.class)
    void allVehiclesTest(Vehicle argument) {
        log.info("Vehicle is {}", argument);
        assertSame(argument.getClass(), Vehicle.class);
    }

    @ParameterizedTest
    @EnumSource(value=Vehicle.class, names = {"BUS", "LORRY"}, mode= EnumSource.Mode.EXCLUDE)
    void someVehiclesTest(Vehicle argument) {
        log.info("Vehicle is {}", argument);
        assertSame(argument.getClass(), Vehicle.class);
    }

    // -- Method source --
    static Stream<String> stringProvider() {
        return Stream.of("Hello", "my", "hypothetical", "girlfriend");
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithStringProvider(String argument) {
        System.out.println("Argument is " + argument);
        assertNotNull(argument);
    }

    static Stream<Color> colorProvider() {
        return Stream.of(new Color("green"), new Color("Blue"), new Color("Red"));
    }

    // object parameters
    @ParameterizedTest
    @MethodSource("colorProvider")
    void testColors(Color color) {
        System.out.println("Color is " + color.getName());
        assertNotNull(color);
    }

    static class Color {
        String name;

        public Color(String name) {
            this.name = name;
        }
        public String getName() { return name; }
    }

    // use primitive types as arguments
    static IntStream intProvider() { return IntStream.of(1, 2, 5, 11); }

    @ParameterizedTest
    @MethodSource("intProvider")
    void testWithInts(int arg) {
        System.out.println("Argument is " + arg);
        assertNotEquals(0, arg);
    }

    static DoubleStream doubleProvider() { return DoubleStream.of(1.5, 2.25, 3.125); }

    @ParameterizedTest
    @MethodSource("doubleProvider")
    void testWithDoubles(double d) { System.out.println("arg is " + d); }

    // Note: argument provider must be static
    static LongStream longProvider() { return LongStream.of(0, 5, 10, 50); }

    @ParameterizedTest
    @MethodSource("longProvider")
    void testWithLongs(long l) {
        System.out.println("Long arg is " + l);
    }

    // mixed type arguments
    static Stream<Arguments> stringColorIntProvider() {
        return Stream.of(
                Arguments.of("Very nice",new Color("red"), 5),
                Arguments.of("Fair", new Color("gray"), 2),
                Arguments.of("Lousy", new Color("Yellow"), 1),
                Arguments.of("Excellent", new Color("black"), 5));
    }

    @ParameterizedTest
    @MethodSource("stringColorIntProvider")
    void testMultipleArguments(String comment, Color color, int marks) {
        assertNotEquals(comment, "", "Comment can not be empty");
        assertNotNull(color, "Color can not be null");
        assertNotEquals(marks, 0, "Marks can not be zero");
        log.info("Your color {} is {}, you score marks", color.getName(), comment);

    }

    // -- with csv --
    // Read content formatted in CSV format
    @ParameterizedTest
    @CsvSource({ "hello, 1, there", "world, 2, 'wide web'", "'great having you here', 3, 'my dear'" })
    void testWithCsvSource(String first, int second, String third) {
        System.out.println(second + " " + first + " " + third);
    }

    // Read content stored in a CSV file
    @ParameterizedTest
    @CsvFileSource(resources = "/numbers.csv")
    void numbersInCSVFileAreLessThanLastTest(int num1, int num2, int greaterNum) {
        log.info("num1 is {}, num2 is {}, greaterNum is {}", new Object[]{ num1, num2, greaterNum });
        assertTrue(num1 + num2 <= greaterNum);
    }


    // -- argument source --
    @ParameterizedTest
    @ArgumentsSource(MyCustomArgumentsProvider.class)
    void myArgumentsSourceTest(String message1, String message2) {
        log.info("Message 1 is {} and message 2 is {}", new Object[] { message1, message2 });
    }

    // multiple argument sources
    // We can provide many annotations of this type
    // because ArgumentSource is a repeatable annotation
    @ParameterizedTest
    // Commented out below to illustrate the alternative @ArgumentSources but works as well
//    @ArgumentsSource(MyCustomArgumentsProvider.class)
//    @ArgumentsSource(MySecondCustomArgumentsProvider.class)
//    @ArgumentsSource(MyCustomArgumentsProvider.class) // will not be repeated since it is a duplicate
    // Using argument sources to contain the multiple ArgumentsSource's
    @ArgumentsSources({
            @ArgumentsSource(MySecondCustomArgumentsProvider.class),
            @ArgumentsSource(MyCustomArgumentsProvider.class)
    })
    void myManyArgumentsSourceTest(String message1, String message2) {
        log.info("Message 1 is {} and message 2 is {}", new Object[] { message1, message2 });
    }
    /**
     * Returns a stream of arguments used as source of arguments
     * Reusable in different tests
     * We are using a nested class here so we have to make it static else we will get a JUnitException
     */
     static class MyCustomArgumentsProvider implements ArgumentsProvider {
        private Logger log = LoggerFactory.getLogger(getClass());

        @Override
        public Stream<? extends Arguments> provideArguments(
                ExtensionContext context
        ) {
            log.info("Called argument provider to test " + context.getTestMethod().get().getName());
            // returns a stream of Arguments
            return Stream.of(
                    Arguments.of("hi", "you"),
                    Arguments.of("I am okay", "and you?")
            );
        }

    }

    /**
     * Second custom argument provider
     */
    static class MySecondCustomArgumentsProvider implements ArgumentsProvider {
        private Logger log = LoggerFactory.getLogger(getClass());

        @Override
        public Stream<? extends Arguments> provideArguments(
                ExtensionContext context
        ) {
            log.info("Called the second argument provider to test  " + context.getTestMethod().get().getName());
            // returns a stream of Arguments
            return Stream.of(
                    Arguments.of("When ", "will you ever say"),
                    Arguments.of("I just walked away", "but I will always love you.")
            );
        }

    }

    // -- Custom Names for parameterized tests --

    @DisplayName("My test with custom names shown")
    @ParameterizedTest(name="{index} 1st arg:\"{0}\", 2nd arg:{1}. All args are {arguments}")
    @CsvSource({"Gil, 1", "Rob, 2","Milcah, 3"})
    void testCustomNameForParameterizedTest(String arg1, int arg2) {
        log.info("Testing with parameters: arg 1: {}, arg2: {}", new Object[] {arg1, arg2});
    }

    @DisplayName("Test2, Custom names for parameterized test")
    @ParameterizedTest(name="Test {index}, Args: {arguments}")
    @CsvSource({"1, Hi, TRUE", "2, There, FALSE", "3, 'How are you', true"})
    void testNamingParameterizedTest2(int arg1, String arg2, boolean arg3) {
        log.info("Parameters are: {}, {}, {}", new Object[]{ arg1, arg2, arg3});
    }





}
