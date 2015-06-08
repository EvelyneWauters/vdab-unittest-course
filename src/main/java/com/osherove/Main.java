package com.osherove;

/**
 * Created by jeansmits on 08/06/15.
 */
public class Main {
    public static void main(String[] args) {
        String s = "";
        int a = 0;
        String [] parts = s.split(",");
        for (String part : parts) {
            System.out.println(Integer.parseInt(part));
            a = a + Integer.parseInt(part);
            System.out.println(a);
        }
    }



}
