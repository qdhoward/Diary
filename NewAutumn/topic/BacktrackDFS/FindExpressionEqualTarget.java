package NewAutumn.topic.BacktrackDFS;

import java.util.*;

public class FindExpressionEqualTarget {
    public List<String> solution(int[] input, int target) {
        List<int[]> allPermutation = allPermutation(input);
        List<String> res = new ArrayList<>();
        for (int[] permutation : allPermutation) {
            System.out.println(Arrays.toString(permutation));
            StringBuilder sb = new StringBuilder();
            pathHelper(permutation, 0, target, permutation[0], sb, res);
        }
        return res;
    }
    private List<int[]> allPermutation(int[] input) {
        List<int[]> res = new ArrayList<>();
        helper(input, res, 0);
        return res;
    }

    private void pathHelper (int[] input, int index, int target, int curResult, StringBuilder sb, List<String> res) {
        if (index == input.length - 1) {
            if (curResult == target) {
                res.add(sb.toString());
            }
            return;
        }

        //Sum
        curResult += input[index + 1];
        String path;
        if (index == 0) {
            path = "(" + input[index] + "+" + input[index + 1] + ")";
            sb.append(path);
        } else {
            path = "+" + input[index + 1] + ")";
            sb.append(path);
            sb.insert(0, "(");
        }
        pathHelper(input, index + 1, target, curResult, sb, res);
        if (index != 0) {
            sb.deleteCharAt(0);
        }
        sb.delete(sb.length() - path.length(), sb.length());
        curResult -= input[index + 1];

        //Subtract
        curResult -= input[index + 1];
        if (index == 0) {
            path = "(" + input[index] + "-" + input[index + 1] + ")";
            sb.append(path);
        } else {
            path = "-" + input[index + 1] + ")";
            sb.append(path);
            sb.insert(0, "(");
        }
        pathHelper(input, index + 1, target, curResult, sb, res);
        if (index != 0) {
            sb.deleteCharAt(0);
        }
        sb.delete(sb.length() - path.length(), sb.length());
        curResult += input[index + 1];

        //Multiply
        curResult *= input[index + 1];
        path = index == 0 ? input[index] + "*" + input[index + 1] : "*" + input[index + 1];
        sb.append(path);
        pathHelper(input, index + 1, target, curResult, sb, res);
        sb.delete(sb.length() - path.length(), sb.length());
        curResult /= input[index + 1];

        //Divide
        curResult /= input[index + 1];
        path = index == 0 ? input[index] + "/" + input[index + 1] : "/" + input[index + 1];
        sb.append(path);
        pathHelper(input, index + 1, target, curResult, sb, res);
        sb.delete(sb.length() - path.length(), sb.length());
    }

    private void helper(int[] input, List<int[]> res, int index) {
        if (index == input.length) {
            res.add(Arrays.copyOf(input, input.length));
        }
        Set<Integer> added = new HashSet<>();
        for (int i = index; i < input.length; i++) {
            if (added.add(input[i])) {
                swap(input, index, i);
                helper(input, res, index + 1);
                swap(input, index, i);
            }
        }
    }

    private void swap(int[] input, int left, int right) {
        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }
}
