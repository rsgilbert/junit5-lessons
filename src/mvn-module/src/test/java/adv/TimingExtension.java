package adv;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    static final Logger log = LoggerFactory.getLogger(TimingExtension.class.getName());

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(context.getRequiredTestClass(), System.currentTimeMillis());
        log.info("Current millis for {} is {}", context.getRequiredTestMethod(), System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        long startMillis =  getStore(context).remove(context.getRequiredTestClass(), long.class);
        long durationMillis = System.currentTimeMillis() - startMillis;
        log.info("Current millis for {} is {}", context.getRequiredTestMethod(), System.currentTimeMillis());
        log.info("Test method {} took {} ms", context.getDisplayName(), durationMillis);
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context));
    }
}
