package LeetCode.Topic.Array;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums1[j--];
            }
        }
        //TODO 如果nums1最后剩下了，不用管，已经在num1里面了
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
