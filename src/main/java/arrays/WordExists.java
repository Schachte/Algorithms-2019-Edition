package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        exist(new char[][]{{'A'}, {'A'}}, "AAA");
    }

    public static boolean exist(char[][] board, String word) {
        int row = 0;
        int col = 0;
        int count = 0;
        int stringPosition = 0;
        Set<String> seenLocations = new HashSet<>();
        while (stringPosition < word.length() || count != word.length() || (row < board.length && col < board[0].length)) {
            if (stringPosition == word.length()) break;
            if (board[row][col] == word.charAt(stringPosition) && !seenLocations.contains(row + "" + col)) {
                stringPosition++;
                count++;
                seenLocations.add(row + "" + col);
                continue;
            }

            if (row+1 < board.length) {
                if (board[row+1][col] == word.charAt(stringPosition) && !seenLocations.contains((row+1) + "" + col)) {
                    stringPosition++;
                    count++;
                    row = row+1;
                    seenLocations.add(row + "" + col);
                    continue;
                }
            }

            if (col+1 < board[0].length) {
                if (board[row][col+1] == word.charAt(stringPosition) && !seenLocations.contains(row + "" + (col+1))) {
                    stringPosition++;
                    count++;
                    col = col+1;
                    seenLocations.add(row + "" + col);
                    continue;
                }
            }

            if (col-1 >= 0) {
                if (board[row][col-1] == word.charAt(stringPosition) && !seenLocations.contains(row + "" + (col-1))) {
                    stringPosition++;
                    count++;
                    col = col-1;
                    seenLocations.add(row + "" + col);
                    continue;
                }
            }

            if (row-1 >= 0) {
                if (board[row-1][col] == word.charAt(stringPosition) && !seenLocations.contains(row-1+ "" + col)) {
                    stringPosition++;
                    count++;
                    row = row - 1;
                    seenLocations.add(row + "" + col);
                    continue;
                }
            }

            break;
        }

        return count == word.length();
    }
}
