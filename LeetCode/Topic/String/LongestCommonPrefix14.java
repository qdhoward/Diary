package LeetCode.Topic.String;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            char common = strs[0].charAt(index);
            int i = 0;
            for (i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || strs[i].charAt(index) != common) {
                    return sb.toString();
                    //TODO 不满足条件直接return
                }
            }
            if (i == strs.length) {
                sb.append(common);
            }
            index++;

        }
        return sb.toString();
    }
}
