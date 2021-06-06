import org.junit.Test;

public class SimpleMultipleInputTest {
    // Loop through all the inputs exercising the same test logic
    @Test
    public void simpleTest() {
        String[] input = { "A", "B", "C"};
        for(String s: input)
            exercise(s);
    }

    private void exercise(String s) {
        System.out.println(s);
    }
}
