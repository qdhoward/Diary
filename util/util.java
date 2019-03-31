package util;

import java.util.*;

public class util {
    private static int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        System.out.println(longestTime(new boolean[] {true, true, true}, 0));
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    public static int longestTime(boolean[] arr, int k) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0; //number of change from 0 to 1
        int left = 0,right = 0;
        int max = 0;
        while(right < arr.length) {
            if (count > k) {
                if (!arr[left]) {
                    count--;
                }
                left++;
            } else {
                max = Math.max(max, right - left);
                if (!arr[right]) {
                    count++;
                }
                right++;
            }
        }
        return max;
    }

}
