import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedClassTest {

    @BeforeEach
    void setup() {
        System.out.println("Before each outer Setup");
    }



    @Nested
    class InnerClass1 {

        @Test
        void innerTest102() {
            System.out.println("Inner test lever 1 method 2");
        }
        @Nested
        class InnerClass2 {
            @BeforeEach
            void setup3() {
                System.out.println("Before each inner 3");
            }
            @Test
            void innerTest201() {
                System.out.println("Inner test level 2 method 1");
            }
            @Test
            void innerTest202() {
                System.out.println("Inner test lever 2 method 2");
            }

        }
        @BeforeEach
        void setup2() {
            System.out.println("Before each inner 1");
        }
        @Test
        void innerTest101() {
            System.out.println("Inner test level 1 method 1");
        }
    }

    @Test
    void topTest() {
        System.out.println("top test");
    }
}
