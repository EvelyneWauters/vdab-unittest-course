package com.realdolmen;

import com.realdolmen.fractionExercise.Fraction;

/**
 * Created by jeansmits on 04/06/15.
 */
public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(3,5);
        Fraction b = new Fraction(8,10);
//        System.out.println(a.sumFraction(b));
//        System.out.println(a.multiplyFraction(b));
        //System.out.println(a.divideFraction(b));

        a.setTeller(33);
        System.out.println(a.getTeller());
    }
}
