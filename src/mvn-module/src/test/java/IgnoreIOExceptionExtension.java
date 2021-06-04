import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.io.IOException;

/**
 * This extension checks whether the exception is an IOException
 * If it is, the exception is discarded
 */
public class IgnoreIOExceptionExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if(throwable instanceof IOException) {
            System.out.println("Extension found an IO Exception: " + throwable.getMessage());
            return;
        }
        throw throwable;
    }
}
