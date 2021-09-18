import org.junit.Assert;
import org.junit.Test;

public class TestStringCalculator {

    private StringCalculator stringCalculator = new StringCalculator();


    @Test
    public void shouldReturnZeroOnAnEmptyString() {
        assert stringCalculator.add("") == 0;
    }

    @Test
    public void shouldReturnZeroOnAnNull() {
        assert stringCalculator.add(null) == 0;
    }

    @Test
    public void shouldReturnZeroOnAnBlankString() {
        assert stringCalculator.add("    ") == 0;
    }

    @Test
    public void shouldReturnNumberOnNumber() {
        assert stringCalculator.add("1") == 1;
    }

    @Test
    public void shouldReturnSumOnTwoNumbers() {
        assert stringCalculator.add("1,2") == 1 + 2;
    }

    @Test
    public void shouldReturnSumForMultipleNumbers() {
        assert stringCalculator.add("1,2,2,2,3") == 1 + 2 + 2 + 2 + 3;
    }

    @Test
    public void shouldHandleNewLines() {
        assert stringCalculator.add("1\n2,3") == 1 + 2 + 3;
    }

    @Test
    public void shouldSupportMultipleDelimiters() {
        assert stringCalculator.add("//;\n1;2") == 1 + 2;
    }

    @Test
    public void shouldThrowExceptionOnNegativeNumbers() {
        try {
            stringCalculator.add("1,-2,3,-4");
            Assert.fail("Exception expected");
        } catch (RuntimeException runtimeException) {
            Assert.assertEquals("Negatives are not allowed: [-2, -4]", runtimeException.getMessage());
        }
    }

    @Test
    public void shouldIgnoreNumberBiggerThanOneThousand() {
        assert stringCalculator.add("1,1000,1001,2") == 1 + 1000 + 2;
    }

    @Test
    public void shouldHandleMultipleLengthOfDelimiters() {
        assert stringCalculator.add("//[+++]\n1+++2+++3") == 1 + 2 + 3;
    }

    @Test
    public void shouldHandleMultipleTypeOfDelimiters() {
        assert stringCalculator.add("//[*][%]\n1*2%3") == 1 + 2 + 3;
    }

    @Test
    public void shouldHandleMultipleTypeOfMultipleLengthOfDelimiters() {
        assert stringCalculator.add("//[**][%%]\n1**2%%3") == 1 + 2 + 3;
    }

}
