import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {

    StringCalculator stringCalculator;

    @Before
    public void init(){
        this.stringCalculator=new StringCalculator();
    }

    @Test
    public void shouldReturnZeroOnAnEmptyString(){
        assert stringCalculator.add("")==0;
    }

    @Test
    public void shouldReturnNumberOnNumber(){
        assert stringCalculator.add("1")==1;
    }

    @Test
    public void shouldReturnSumOnTwoNumbers(){
        assert stringCalculator.add("1,2")==1+2;
    }

    @Test
    public void shouldReturnSumForMultipleNumbers(){
        assert stringCalculator.add("1,2,2,2,3")==1+2+2+2+3;
    }

    @Test
    public void shouldHandleNewLines(){
        assert stringCalculator.add("1\n2,3")==1+2+3;
    }

    @Test
    public void shouldSupportMultipleDelimiters(){
        assert stringCalculator.add("//;\n1;2")==1+2;
    }

}
