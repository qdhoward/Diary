package NewAutumn.topic.BacktrackDFS;

public class index {
    public static void main (String[] args) {
        BacktrackDFS test = new BacktrackDFS();
        System.out.println(test.allFactor(12));
        System.out.println(test.allSumCombination(4));
        System.out.println(test.allSumPermutation(3));

        isPalindrome test2 = new isPalindrome();
        System.out.println(test2.solution("google"));
        System.out.println(test2.solution("aab"));
        System.out.println(test2.allPalindrome("aaaabb"));
        System.out.println(test2.allPalindrome("aaaacccbb"));
    }
}
