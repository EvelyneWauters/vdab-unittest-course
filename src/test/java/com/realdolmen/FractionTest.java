package com.realdolmen;


import com.realdolmen.fractionExercise.ForbiddenDenominatorException;
import com.realdolmen.fractionExercise.Fraction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {

    @Test
    public void testMakeFraction() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals(3, f.getTeller());
        assertEquals(5, f.getNoemer());
    }

    @Test
    public void testMakeFractionWithEmptyConstructor() throws Exception {
        Fraction f = new Fraction();
        assertEquals(0,f.getTeller());
        assertEquals(0,f.getNoemer());
    }

    @Test
    public void testConstructorSimplifyImplementation() throws Exception {
        Fraction f = new Fraction(18,9);
        Fraction g = new Fraction(4,-8);
        Fraction h = new Fraction(-1,8);
        Fraction i = new Fraction(-1,-8);

        assertEquals(2,f.getTeller());
        assertEquals(1,f.getNoemer());
        assertEquals(-1,g.getTeller());
        assertEquals(2,g.getNoemer());
        assertEquals(-1,h.getTeller());
        assertEquals(8,h.getNoemer());
        assertEquals(1,i.getTeller());
        assertEquals(8,i.getNoemer());
    }

    @Test
    public void testgetTellerAndgetNoemer() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals(3, f.getTeller());
        assertEquals(5, f.getNoemer());
    }

    @Test
    public void testSetTeller() throws Exception {
        Fraction f = new Fraction(3,5);
        f.setTeller(20);
        assertEquals(4,f.getTeller());
    }

    @Test
    public void testSetNoemer() throws Exception {
        Fraction f = new Fraction(3,5);
        f.setNoemer(20);
        assertEquals(20,f.getNoemer());
    }

    @Test
    public void testSetNoemerZeroHasToFail() throws Exception {
        try {
            Fraction f = new Fraction(3,5);
            f.setNoemer(0);
            Assert.fail("oh no");
        } catch(ForbiddenDenominatorException e)    {
            assertEquals("Noemer mag niet 0 zijn", e.getDescription());
        }
    }

    //Al eleganter dan methode 1, maar kan niet verder testen op de exception, vb kan niet testen of de message overeenkomt
    @Test(expected = ForbiddenDenominatorException.class)
    public void testSetNoemerZeroHasToFailMethod2() throws Exception {
        new Fraction(1,0);
    }

//    //beste optie om te testen voor een fail, werken met Rules!
//    @Test
//    public void testSetNoemerZerHasToFailMethod3MetRules() throws Exception {
//        e.expect(IllegalArgumentException.class);
//        e.expectedMessage("Noemer mag niet 0 zijn");
//        new Fraction(1,0);  //throws exception
//    }

    @Test
    public void testThrowExceptionWhenInputZeroForNoemer() throws Exception {
        try {
            Fraction a = new Fraction(6, 0);
            Assert.fail("oh no");
        }
        catch (ForbiddenDenominatorException e) {
        }
    }


    @Test
    public void testToStringFunction() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals("3/5", f.toString());
    }

    @Test
    public void testEqualsFractionFunction() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction(6,10);
        assertEquals(true, f.equalsFraction(g));
    }

    @Test
    public void testEqualsFractionsGetFalse() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction h = new Fraction(8,9);
        assertEquals(false, f.equalsFraction(h));
    }

    @Test
    public void testEqualsFunction() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction(6,10);
        assertEquals(true, f.equals(g));
    }

    @Test
    public void testEqualsGetFalse() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction h = new Fraction(8,9);
        assertEquals(false, f.equals(h));
    }

    @Test
    public void testAsDoubleFunction() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals(0.6, f.asDouble(),1);
    }

    @Test
    public void testSumOfFractions() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        assertEquals(7, f.sumFraction(g).getTeller());
        assertEquals(5, f.sumFraction(g).getNoemer());
    }

    @Test
    public void testSubtracktFractions() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        assertEquals(-1, f.subtracktFraction(g).getTeller());
        assertEquals(5, f.subtracktFraction(g).getNoemer());
    }

    @Test
    public void testAssertEqualsWithMysteriousDelta() throws Exception {
        double a = 1.980979879876;
        double b = 1.980979879;
        assertEquals(a,b,1);
    }

    @Test
    public void testMultiplicationOfFractions() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        assertEquals(12, f.multiplyFraction(g).getTeller());
        assertEquals(25, f.multiplyFraction(g).getNoemer());
    }

    @Test
    public void testDivideFractions() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        assertEquals(3, f.divideFraction(g).getTeller());
        assertEquals(4, f.divideFraction(g).getNoemer());
    }

    @Test
    public void testDivideWithZeroOther() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        g.setTeller(0);
        assertEquals(new Fraction(0,1), f.divideFraction(g));
   }

    @Test
     public void testDivideWithZeroThis() throws Exception {
        Fraction f = new Fraction(3, 5);
        Fraction g = new Fraction(8, 10);
        f.setTeller(0);
        assertEquals(new Fraction(0, 1), f.divideFraction(g));
    }

    //test theorystuff
    @Test
    public void testReciprocalMethod() throws Exception {
        Fraction f = new Fraction(5,6);
        assertEquals(6,f.reciprocal().getTeller());
        assertEquals(5,f.reciprocal().getNoemer());
    }
}
