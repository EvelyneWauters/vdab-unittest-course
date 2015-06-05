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
    public void testgetTellerAndgetNoemer() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals(3, f.getTeller());
        assertEquals(5, f.getNoemer());
    }

    @Test
    public void testSetTeller() throws Exception {
        Fraction f = new Fraction(3,5);
        f.setTeller(20);
        assertEquals(20,f.getTeller());
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
    public void testSimplifyFunction() throws Exception {
        Fraction f = new Fraction(8,10);
        assertEquals(4, f.simplify().getTeller());
        assertEquals(5, f.simplify().getNoemer());
    }

    @Test
    public void testToStringFunction() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals("3/5", f.toString());
    }

    @Test
    public void testEqualsFunction() throws Exception {
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
    public void testAsDoubleFunction() throws Exception {
        Fraction f = new Fraction(3,5);
        assertEquals(0.6, f.asDouble(),1);
    }

    @Test
    public void testSumOfFractions() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        assertEquals(7,f.sumFraction(g).simplify().getTeller());
        assertEquals(5,f.sumFraction(g).simplify().getNoemer());
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
        assertEquals(12,f.multiplyFraction(g).simplify().getTeller());
        assertEquals(25,f.multiplyFraction(g).simplify().getNoemer());
    }

    @Test
    public void testDivideFractions() throws Exception {
        Fraction f = new Fraction(3,5);
        Fraction g = new Fraction (8,10);
        assertEquals(3,f.divideFraction(g).simplify().getTeller());
        assertEquals(4, f.divideFraction(g).simplify().getNoemer());
    }



}
