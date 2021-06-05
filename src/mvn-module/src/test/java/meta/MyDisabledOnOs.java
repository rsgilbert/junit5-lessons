package meta;


import ext.OsCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import util.Os;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Custom annotation for specifying whether we want our test to be disabled for a given array of Operating Systems
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(OsCondition.class)
public @interface MyDisabledOnOs {
    Os[] value();
}
