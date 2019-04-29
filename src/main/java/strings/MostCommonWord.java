package strings;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String common = mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String biggestWord = "";
        String lru = "";
        int maxCount = 0;

        List<String> bannedList = new ArrayList<>();
        bannedList.addAll(Arrays.asList("!", "?", "'", ",", ";", ".", ""));
        bannedList.addAll(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase();

        Map<String, Integer> frequencyList = new HashMap<>();
        Set<String> bannedWords = new HashSet<>(bannedList);

        for (String item : paragraph.split("!|\\?|'|,|;|\\.|\\s+")) {
            if (!bannedWords.contains(item) && frequencyList.containsKey(item)) {
                frequencyList.put(item, frequencyList.get(item) + 1);
                if (frequencyList.get(item) > maxCount) {
                    biggestWord = item;
                    maxCount = frequencyList.get(item);
                }
            } else if (!bannedWords.contains(item)) {
                frequencyList.put(item, 1);
                lru = item;
            }
        }

        return biggestWord == "" && frequencyList.size() > 0 ? lru : biggestWord;
    }
}
