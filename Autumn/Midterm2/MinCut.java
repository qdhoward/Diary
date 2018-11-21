package Autumn.Midterm2;

/**
 * Created by HaoYu on 2017/11/14.
 */
public class MinCut {
    public int minCuts(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        int[] res = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            res[i] = i;
            if (isPalindrome(input, 0, i)) {
                res[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(input, j, i)) {
                    res[i] = Math.min(res[i], res[j - 1] + 1);
                }
            }
        }
        return res[input.length() - 1];
    }
    private boolean isPalindrome (String input, int left, int right) {
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int minCuts2(String input){
        if(input == null || input.length() == 0){
            return 0;
        }
        char[] array = input.toCharArray();
        int len = array.length;
        boolean[][] check = new boolean[len][len];
        int[] cuts = new int[len];
        for(int end = 0; end <= len - 1; end++){
            cuts[end] = end;
            for(int start = 0; start <= end; start++){
                if(array[start] == array[end] && (end - start <= 1 || check[start + 1][end - 1])){
                    check[start][end] = true;
                }
                if(check[start][end]){
                    if(start - 1 < 0){
                        cuts[end] = 0;
                    } else{
                        cuts[end] = Math.min(cuts[end], 1 + cuts[start - 1]);
                    }
                }
            }
        }
        return cuts[len - 1];
    }
    public static void main(String[] args){
        System.out.print(new MinCut().minCuts2("aabaacddc"));
    }
}
