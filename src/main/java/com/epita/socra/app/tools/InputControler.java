package com.epita.socra.app.tools;

public class InputControler {

    public static boolean isNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
            return true;
    }
}
