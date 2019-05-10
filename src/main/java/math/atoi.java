package math;

public class atoi {
    public static void main(String[] args) {
//        int data = myAtoi("445");
//        int data2 = myAtoi("  445");
//        int data2 = myAtoi("  -42");
//        int data2 = myAtoi("4193 with words");
        int data2 = myAtoi("-91283472332");
//        int data3 = myAtoi("234234283489234892348234");
    }
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int negative = 1;
        long value = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;
            if (str.charAt(i) == '-') {
                negative = -1;
                continue;
            }
            if (!isDigit(str.charAt(i))) {
                return (int) value * negative;
            }
            value = value * 10 + getVal(str.charAt(i));
            if (negative == 1 && value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (negative == -1 && -value < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) value * negative;
    }
    private static boolean isDigit(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    private static int getVal(char c) {
        return c - '0';
    }
}
