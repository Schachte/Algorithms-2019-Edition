package strings;

public class NeedleInHaystack {
    public static void main(String[] args) {
        int result = needleInHaystack("ryan schachte", "acht");
    }

    // N^2 brute force
    public static int needleInHaystack(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {

            // We have a possible beginning here
            if (haystack.charAt(i) == needle.charAt(0)) {
                int currentNeedle = 0;
                for (int x = i; x < haystack.length(); x++) {
                    if (currentNeedle < needle.length() && haystack.charAt(x) == needle.charAt(currentNeedle)) {
                        currentNeedle++;
                    } else {
                        break;
                    }
                }

                if (currentNeedle == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
