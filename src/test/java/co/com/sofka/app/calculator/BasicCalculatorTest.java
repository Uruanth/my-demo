package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing susb: 1-1=0")
    public void susb() {
        //Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 0L;

        // Act
        Long result = basicCalculator.subtract(number1, number2);

        // Assert
        assertEquals(expectedValue, result);

    }


    @DisplayName("Testing several subtract")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "1,    2,   -1",
            "49,  51, -2",
            "1,  100, -99"
    })
    public void severalSub(Long first, Long second, Long expectedResult){
        assertEquals(expectedResult, basicCalculator.subtract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    @Test
    @DisplayName("Testing divide by 0")
    public void divideByZero() {
        //Arrange
        Long number1 = 1L;
        Long number2 = 0L;

        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> basicCalculator.divide(number1, number2));
    }


    @DisplayName("Testing divide")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   0.5",
            "49,  50, 0.98",
            "1,  100, 0.01"
    })
    void divide(double first, double second, double expectedResult){
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                ()->first + " / " + second + " should equal " + expectedResult);
    }


    @DisplayName("Testing several multiplication")
    @ParameterizedTest(name = "{0} * {1} = {2}}")
    @CsvSource({
            "0,    1,   0",
            "1,    2,   2",
            "49,  51, 2499",
            "1,  100, 100"
    })
    void multiplication(Long first, Long second, Long expectedResult){
        assertEquals(expectedResult, basicCalculator.mult(first, second),
                ()-> first + " * " + second + " should equal " + expectedResult);
    }


}
