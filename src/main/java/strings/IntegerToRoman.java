package strings;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(romanToInt("MMXIV"));

    }

    public static String intToRoman(int value) {
        final String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] romanInt = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romanBuilder = new StringBuilder();
        int idx = 0;

        while (value > 0) {
            if (value - romanInt[idx] >= 0) {
                romanBuilder.append(roman[idx]);
                value -= romanInt[idx];
            } else {
                idx++;
            }
        }

        return romanBuilder.toString();
    }

    public static int romanToInt(String value) {
        int computedValue = 0;
        Map<String, Integer> romanMap = new HashMap();
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);

        for (int i = 0; i < value.length(); i++) {
            if (i + 1 < value.length() && romanMap.containsKey(String.valueOf(value.charAt(i)) + String.valueOf(value.charAt(i + 1)))) {
                computedValue += romanMap.get(String.valueOf(value.charAt(i)) + String.valueOf(value.charAt(i + 1)));
                i+=1;
            } else if (romanMap.containsKey(String.valueOf(value.charAt(i)))) {
                computedValue += romanMap.get(String.valueOf(value.charAt(i)));
            }
        }
        return computedValue;
    }
}
