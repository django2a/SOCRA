package com.epita.socra.app.tools;

import java.util.HashMap;

public class MorseConverter {

    private static Integer sum = 0;

    public static String convertToMorse(String message) {
        final String[] table = {"_ _ _ _ _", ". _ _ _ _", ". . _ _ _", ". . . _ _", ". . . . _", ". . . . .",
            "_ . . . .", "_ _ . . .", "_ _ _ . .", "_ _ _ _ ."};
        String converted = "";

        for (int i = 0; i < message.length(); i++) {
            converted += table[Character.getNumericValue(message.charAt(i))];
            converted += ' ';
        }

        return converted;
    }

    private static int atoi(String message) {
        int res = 0;

        for (int i = 0; i < message.length(); i++)
            if (!Character.isDigit(message.charAt(i)))
                return -1;
            else
                res = res * 10 + Character.getNumericValue(message.charAt(i));

        return res;
    }

    public static String addToSum(String message) {
        sum += (InputControler.isNumeric(message) ? atoi(message) : atoi(convertFromMorse(message)));
        return sum.toString();
    }

    public static String convertFromMorse(String message) {
        final String[] table = {"_ _ _ _ _", ". _ _ _ _", ". . _ _ _", ". . . _ _", ". . . . _", ". . . . .",
            "_ . . . .", "_ _ . . .", "_ _ _ . .", "_ _ _ _ ."};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < table.length; ++i)
            map.put(table[i], i);
        String converted = "";

        for (int i = 0; i < message.length(); i += 10) {
            converted += map.get(message.substring(i, i + 9));
        }

        return converted;
    }
}
