package osherove;


import org.junit.Ignore;
import org.junit.Test;

import static com.osherove.Calculator.add;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    @Ignore
    public void addZeroNumbers() throws Exception {
        assertEquals(0, add(""));
    }

    @Test
    @Ignore
    public void addOneNumber() throws Exception {
        String a = "3";
        assertEquals(3, add(a));
    }

    @Test
    public void addTwoNumbers() throws Exception {
        String a = "5,8";
        assertEquals(13, add(a));
    }

    @Test
    public void addAButloadOfNumbers() throws Exception {
        String a = "1,2,3,4,5,6,7,8,9";
        assertEquals(45 ,add(a));
    }

    @Test
    @Ignore
    public void addNumbersWithNewLinesInbetween() throws Exception {
        String a = "1\n2,3";
        assertEquals(6,add(a));
    }


}
