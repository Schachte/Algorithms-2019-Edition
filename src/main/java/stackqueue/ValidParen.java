package stackqueue;

import java.util.*;

public class ValidParen {
    public static void main(String[] args) {
        isValid("([)]");
    }
    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();

        Set<Character> left = new HashSet<>();
        Set<Character> right = new HashSet<>();
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('(', ')');
        mappings.put('{', '}');
        mappings.put('[', ']');

        left.add('(');
        left.add('{');
        left.add('[');
        right.add(')');
        right.add('}');
        right.add(']');

        // Populate the two stacks
        for (int i = 0; i < s.length(); i++) {
            char currentItem = s.charAt(i);
            if (left.contains(currentItem)) {
                s1.push(currentItem);
            } else if (right.contains(currentItem)) {
                s2.push(currentItem);
            }
        }

        if (s1.size() != s2.size()) return false;

        while (!s1.isEmpty()) {
            if (mappings.get(s1.pop()) != s2.pop()) return false;
        }

        return true;
    }
}

