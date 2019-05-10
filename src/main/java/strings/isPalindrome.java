package strings;


public class isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aa"));
    }

    public static boolean isPalindrome(String input) {
        if (input.isEmpty()) return true;
        int i = 0;
        int j = input.length()-1;
        while (i < j) {
            if (!Character.isLetterOrDigit(Character.toLowerCase(input.charAt(i)))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(Character.toLowerCase(input.charAt(j)))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j))) return false;
            else { i++; j--; }
        }

        return true;
    }
}
