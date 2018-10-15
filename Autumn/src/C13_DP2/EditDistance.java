package C13_DP2;

/**
 * Created by HaoYu on 2017/10/31.
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        // Write your solution here.
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < one.length() + 1; i++) {
            for (int j = 0; j < two.length() + 1; j++) {
                if (i == 0) {//TODO 这道题和DictionaryWord一样，长度都是+1，distance[i][j]表示
                    //one到i-1 change into two到j-1需要的步数
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {//注意判断条件是-1
                    distance[i][j] = distance[i - 1][j - 1];//Do nothing 直接继承
                } else {//分别对应 replace，delete, insert
                    distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i - 1][j] + 1);
                    distance[i][j] = Math.min(distance[i][j], distance[i][j - 1] + 1);
                }
            }
        }
        return distance[one.length()][two.length()];
    }
}
