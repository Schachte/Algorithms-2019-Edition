package math;

public class IntegerReversal {
    public static void main(String[] args) {
        System.out.println(reverseInt(1242));

    }

    public static int reverseInt(int input) {
        int reversed = 0;
        while (input > 0) {
            reversed = reversed * 10 + (input % 10);
            input = input / 10;
        }
        return reversed;
    }
}
