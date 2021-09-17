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

}