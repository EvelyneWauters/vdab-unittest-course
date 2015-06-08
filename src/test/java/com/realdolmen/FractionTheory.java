

package com.realdolmen;


import com.realdolmen.fractionExercise.Fraction;
import com.realdolmen.fractionExercise.Utilities;
import org.junit.Ignore;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class FractionTheory {
    @Theory
    @Ignore
    public void thisIsAMethod(Integer a, Integer b) {
        assumeTrue(b!=0);
        System.out.println(a + "/" + b);
        Fraction f = new Fraction(a,b);
        assertEquals(b / Utilities.greatestCommonFactor(a,b), f.reciprocal().getTeller());
        assertEquals(a / Utilities.greatestCommonFactor(a, b), f.reciprocal().getNoemer());
    }
//Random values toewijzen is niet zo een goed idee want dan is er geen vaste dataset voor elke test
//    @DataPoints
//    public static int[] value = {
//            (int)(Math.random()*100),
//            (int)(Math.random()*100),
//            (int)(Math.random()*100),
//            (int)(Math.random()*100),
//            (int)(Math.random()*100),
//            (int)(Math.random()*100),
//            (int)(Math.random()*100),
//            (int)(Math.random()*100)
//    };

    @DataPoints
    public static Integer[] valies =

            fillList();



    private static Integer [] fillList() {
        List<Integer> value = new ArrayList<>();
        for (int j = 0; j<100; j++) {
            value.add(j);
        }
        return value.toArray(new Integer[value.size()]);
    }



}