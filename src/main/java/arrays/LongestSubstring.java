package arrays;

import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

class LongestSubstring {

    public static void main(String []args) {
      System.out.println(LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * Goal: Find the substring of the greatest length of characters that don't repeat
     * abcabcbb -> abc abcb
     * */
    public static int lengthOfLongestSubstring(String s) {
      int i,j,max;
      int stringLength = s.length();
      Set<Character> tracker = new HashSet<>();
      i = j = max = 0;

      while (i < stringLength && j < stringLength) {
        if (!tracker.contains(s.charAt(j))) {
          tracker.add(s.charAt(j++));
          max = Math.max(max, j - i);
        } else {
          tracker.remove(s.charAt(i++));
        }
      }
      return max;
    }
}
