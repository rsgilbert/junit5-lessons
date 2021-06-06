package stdtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

public class MyExceptionTest {

    @ExtendWith(IgnoreIOExceptionExtension.class)
    @Test
    public void shouldNotShowIOException() throws IOException{
        throw new IOException("This is a test IO Exception. It should be captured by the extension");
    }

    @Test
    public void shouldThrowIOException() throws IOException{
     //   throw new IOException("We should get an IO Exception");
    }
}
