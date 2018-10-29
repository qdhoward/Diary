package NewAutumn.topic.BacktrackDFS;

import java.util.*;

public class isPalindrome {
    public boolean solution(String s) {
        //Time O(n) Space O(n)
        Map<Character, Integer> occurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = occurrence.get(s.charAt(i));
            Integer updatedValue = count == null ? 1 : count + 1;
            occurrence.put(s.charAt(i), updatedValue);
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            Integer count = occurrence.get(s.charAt(i));
            if (count % 2 == 1) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }

    public List<String> allPalindrome(String s) {
        //Time O(n!) Space O(n)
        Map<Character, Integer> occurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = occurrence.get(s.charAt(i));
            Integer updatedValue = count == null ? 1 : count + 1;
            occurrence.put(s.charAt(i), updatedValue);
        }
        char distinctChar = ' ';
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : occurrence.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                distinctChar = entry.getKey();
            }
            for (int j = 0; j < entry.getValue() / 2; j++) {
                sb.append(entry.getKey());
            }
        }
        List<String> halfPermutation = getAllPermutation(sb.toString());
        List<String> res = new ArrayList<>();
        for (String half : halfPermutation) {
            String wholePermutation;
            if (distinctChar == ' ') {
                wholePermutation = half + reverse(half);
            } else {
                wholePermutation = half + distinctChar + reverse(half);
            }
            res.add(wholePermutation);
        }
        return res;
    }

    public List<String> getAllPermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        getAllPermutationHelper(array, res, 0);
        return res;
    }

    private void getAllPermutationHelper(char[] array, List<String> res, int index) {
        // Time O(n!) Space O(n)
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        Set<Character> visited = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (visited.add(array[i])) {
                swap(array, i, index);
                getAllPermutationHelper(array, res, index + 1);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    private String reverse(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i <= array.length / 2 - 1; i++) {
            swap(array, i, array.length - 1 - i);
        }
        return new String(array);
    }
}
