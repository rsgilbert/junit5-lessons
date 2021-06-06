import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Tests implementation of a stack.
 */
@DisplayName("Stack test")
public class StackTest {

    @Test
    @DisplayName("is instantiated")
    void isInstantiated() {}

    @Nested
    @DisplayName("when newly created")
    class whenNew {
        @Test
        @DisplayName("is empty")
        void isEmpty() {}

        @Test
        @DisplayName("throws exception when popped")
        void throwsExceptionWhenPopped() {}

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {
            @Test
            @DisplayName("no longer empty")
            void isNotEmpty() {}

            @Test
            @DisplayName("Returns an element when popped")
            void returnsElementWhenPopped() {}

            @Test
            @DisplayName("Returns element when peeked")
            void returnsElementWhenPeeked() {}


        }

    }
}
