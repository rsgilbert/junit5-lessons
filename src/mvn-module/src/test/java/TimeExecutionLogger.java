import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Interface that uses the TimingExtension
 */
@Tag("timed")
@ExtendWith(TimingExtension.class)
public interface TimeExecutionLogger {
}
