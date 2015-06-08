package com.osherove;

/**
 * Created by jeansmits on 08/06/15.
 */
public class Calculator {


    public static int add(String s) {
        int a = 0;
        int b = 0;

        try {
            a = Character.getNumericValue(s.charAt(0));
            b = Character.getNumericValue(s.charAt(2));
        } catch (StringIndexOutOfBoundsException e) {
        }
        return a+b;
    }




}
