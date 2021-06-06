import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * These tests do not generate dynamic tests but show case correct return type for dynamic tests, That is DynamicTest
 */
public class CollectionsTest {

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("1st dynamic test",
                        () -> assertTrue(true)
                ),
                DynamicTest.dynamicTest("2nd dynamic test",
                        () -> {
                            assertFalse(false);
                          //  assertTrue(false);
                        }
                )
        );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {
        return Arrays.asList(
                DynamicTest.dynamicTest("3rd d test", () -> assertTrue(true)),
                DynamicTest.dynamicTest("4th d test", () -> assertFalse(false))
        );
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestFromIterator() {
        return Arrays.asList(
                DynamicTest.dynamicTest("5th d test", () -> fail("5th failed")),
                DynamicTest.dynamicTest("last test", () -> assertTrue(true))
        ).iterator();
    }

}
