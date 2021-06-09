import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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




}
