import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyJunit4SimpleTest {

    @Test
    public void onePlusOneIsTwo() {
        String message = "1 + 1 should be equal to 2";
        System.out.println(message);
        assertEquals(message, 2, 1+1);
    }
}
