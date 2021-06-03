import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyFirstJUnit5Test {
    @Test
    public void myFirstTest() {
        String message = "1+1 should be equal to 2";
        System.out.println(message);
        assertEquals(2, 1+1, message);
    }

}
