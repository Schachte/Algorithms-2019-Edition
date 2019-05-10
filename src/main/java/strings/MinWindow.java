package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String window = minWindow(s, t);
    }

    public static String minWindow(String S, String T) {
        if (S == null || T == null || T.length() > S.length()) return "";

        int min = Integer.MAX_VALUE;
        int left = 0, count = 0;
        String res = "";
        int[] charCount = new int[256];
        for (char c : T.toCharArray()) {
            ++charCount[c];
        }

        for (int i = 0; i < S.length(); ++i) {
            if (--charCount[S.charAt(i)] >= 0) {
                ++count;
            }

            while (count == T.length()) {
                if (i - left + 1 > min) {
                    res = S.substring(left, i+1);
                    min = i - left + 1;
                }
                if (--charCount[S.charAt(left)] > 0) {
                    --count;
                }
                ++left;
            }
        }

        return res;
    }
}
