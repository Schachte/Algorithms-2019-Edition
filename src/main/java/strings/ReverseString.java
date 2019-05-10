package strings;


import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String reversed = reverseString("hello world! ");
    }

    public static String reverseString(String input) {
        if (input.isEmpty()) return "";

        Stack<String> words = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == ' ') {
                if (!builder.toString().isEmpty()) {
                    words.push(builder.toString());
                }
                builder = new StringBuilder();
                continue;
            } else {
                builder.append(c);
            }
        }
        if (!builder.toString().isEmpty())
            words.add(builder.toString());
        builder = new StringBuilder();

        while (!words.isEmpty()) {
            if (words.peek().isEmpty()) {
                words.pop();
                continue;
            }
            if (words.size() == 1) {
                builder.append(words.pop());
            } else {
                builder.append(words.pop() + " ");
            }
        }

        return builder.toString();
    }
}
