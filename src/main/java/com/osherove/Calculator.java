package com.osherove;

/**
 * Created by jeansmits on 08/06/15.
 */
public class Calculator {
private static final String STANDARD_SEPARATOR_TOKEN = ",";


    public static int add(String s) {
        int a = 0;
        String [] parts = s.split(setSeparatorToken(s));

        for (String part : parts) {
            a = a + Integer.parseInt(part);
        }
        return a;
    }



    private static String setSeparatorToken(String s) {
        if (s.substring(0, 2).equals("//") && s.substring(3, 5).equals("\n")) {
            return String.valueOf(s.charAt(2));
        } else {
            return STANDARD_SEPARATOR_TOKEN;
        }

    }


}
