import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class DependencyInjectionTest {

    @ExtendWith(MyParameterResolver.class)
    @Test
    public void myParameterTest(Object parameter) {
        System.out.println("My parameter is: " + parameter);
    }
}
