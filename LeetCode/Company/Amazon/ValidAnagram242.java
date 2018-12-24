package LeetCode.Company.Amazon;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) {
                return false;
            }
        }
        return true;
    }
}
