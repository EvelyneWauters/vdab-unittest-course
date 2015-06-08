package osherove;


import org.junit.Test;

import static com.osherove.Calculator.add;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void addZeroNumbers() throws Exception {
        assertEquals(0, add(""));
    }

    @Test
    public void addOneNumber() throws Exception {
        String a = "3";
        assertEquals(3, add(a));
    }

    @Test
    public void addTwoNumbers() throws Exception {
        String a = "1,2";
        assertEquals(3, add(a));
    }




}
