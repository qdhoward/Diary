package LeetCode.Amazon;

public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {//分别对应 replace，delete, insert
                    distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i - 1][j] + 1);
                    distance[i][j] = Math.min(distance[i][j], distance[i][j - 1] + 1);
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}
