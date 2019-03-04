package Fun.Amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static int[] findMedian(int[] arr, int k) {
        if(arr == null || arr.length == 0) return arr;

        // if(arr.length < k - 1) throw exception for the invalid input

        int[] res = new int[arr.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(arr.length, Collections.reverseOrder()); // maxHeap

        PriorityQueue<Integer> right = new PriorityQueue<Integer>();  // minHeap

        for(int i = 0; i < arr.length; i++) {
            if(left.size() <= right.size()) {
                right.add(arr[i]);
                left.add(right.remove());
            } else {
                left.add(arr[i]);
                right.add(left.remove());
            }
            if(left.size() + right.size() == k) {
                int median;
                if(left.size() == right.size()) {
                    median = (left.peek() + right.peek()) / 2;
                } else {
                    median = left.peek();
                }
                int start = i - k + 1;
                res[start] = median;
                if(!left.remove(arr[start])) {
                    right.remove(arr[start]);
                }
            }

        }
        return res;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int[] arr = new int[]{1,3,3,-3,5,3,6,7};

        int k = 3;
        int[] res = findMedian(arr, k);
        for(int i : res) {
            System.out.println("res is " + i);

        }
        int[] arr1 = new int[0];
        int[] res1 = findMedian(arr1, k);
        for(int i : res1) {
            System.out.println("res1 is " + i);
        }
    }
}
