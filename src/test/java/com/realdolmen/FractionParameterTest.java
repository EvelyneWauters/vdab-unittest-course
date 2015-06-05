//package com.realdolmen;
//
//
//import com.realdolmen.fractionExercise.Fraction;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(Parameterized.class)
//public class FractionParameterTest {
//    @Parameterized.Parameters
//    public static Collection<Object[]> parameters() {
//        return Arrays.asList(new Object[][]) {[
//            (3, 7, "3/7"),
//            (1156, 8468, "1156/8468"),
//            (3, 7, "3/7")]
//        }
//    }
//
//    private int teller;
//    private int noemer;
//    private String value;
//
//    public FractionParameterTest(int teller, int noemer, String value) {
//        this.teller = teller;
//        this.noemer = noemer;
//        this.value = value;
//    }
//
//    public FractionParameterTest() {
//    }
//
//    @Test
//    public void testToString() throws Exception {
//        assertEquals(value, new Fraction(teller, noemer));
//
//    }
//}
