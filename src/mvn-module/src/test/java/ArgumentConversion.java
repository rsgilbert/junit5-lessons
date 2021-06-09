import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArgumentConversion {

    // -- implicit conversion --

    Logger log = LoggerFactory.getLogger(getClass());

    @ParameterizedTest
    @ValueSource(strings = {"1", "true", "TRUE", "yes", "True", "FaKe", "false"})
    void testWithImplicitConversionToBoolean(Boolean arg) {
        logArgument(arg);
    }


    // Convert strings to integers
    // strings that look use only 0's and 1's and also begin with 0 will be treated as binary numbers written as text
    // strings that begin with 0x will be treated as hexadecimal numbers
    @ParameterizedTest
    @ValueSource(strings = {"0x12", "11", "0x1", "0xF", "FFF", "0", "010", "0011", "101", "0101", "ak47", "10000,000", "1,053", "1", "true", "false"})
    void testWithImplicitConversionToInteger(Integer arg) {
        logArgument(arg);
    }

    enum Creature {human, ALIEN, DEVIL}

    // The enum must be spelt exactly as it appears in the enum class
    @ParameterizedTest
    @ValueSource(strings = {"ALIEN", "HUMAN", "DEVIL", "alieN", "human", "dev", "haman"})
    void testImplicitConversionToEnum(Creature arg) {
        logArgument(arg);
    }

    // Convert from string to local date
    // The date string must be in the format yyyy-mm-dd
    @ParameterizedTest
    @ValueSource(strings = {"2015-12-15", "07-10-11", "2020-13-02"})
    void testImplicitConversionToLocalDate(LocalDate arg) {
        logArgument(arg);
    }


    // -- explicit conversion --

    // Convert given parameters to a desired type
    @ParameterizedTest
    @EnumSource(Creature.class)
    void testWithExplicitConversionFromEnumToString(
            @ConvertWith(CreatureArgConverter.class) String arg
    ) {
        logArgument(arg);
    }

    static class CreatureArgConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) {
            return "CREATURE#" + String.valueOf(source);
        }
    }

    // The enum must be spelt exactly as it appears in the enum class
    @ParameterizedTest
    @ValueSource(strings = {"ALIEN", "HUMAN", "DEVIL", "alieN", "human", "dev", "haman"})
    void testExplicitConversionFromStringToEnum(
            @ConvertWith(StringToCreatureConverter.class) Creature arg) {
        logArgument(arg);
    }

    // We will find the creature where the first letter matches ignoring case.
    // Eg if the source object begins with a, we return ALIEN since ALIEN also begins with A
    static class StringToCreatureConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            char firstLetter = source.toString().toLowerCase().charAt(0);
            for(Creature creature: Creature.values()) {
                if(firstLetter == creature.toString().toLowerCase().charAt(0))
                    return creature;
            }
            throw new ArgumentConversionException("Failed to find creature matching " + source);
        }
    }

    // -- utilities --
    // Log argument to console
    void logArgument(Object arg) {
        log.info("Argument {} is of type {}", new Object[]{arg, arg.getClass()});
    }


}
