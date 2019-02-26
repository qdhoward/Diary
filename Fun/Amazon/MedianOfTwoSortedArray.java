package Fun.Amazon;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 != 0) {
            return kthSmallest(nums1, nums2, 0, 0, length / 2 + 1);
        } else {
            int a = kthSmallest(nums1, nums2, 0, 0, length / 2);
            int b = kthSmallest(nums1, nums2, 0, 0, length / 2 + 1);
            return (a + b) / 2.0;
        }
    }
    private int kthSmallest(int[] a, int[] b, int aleft, int bleft, int k) {
        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }
        if (bleft >= b.length) {
            return a[aleft + k -1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }
        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval < bval) {
            return kthSmallest(a, b, amid + 1, bleft, k - k / 2);
        } else {
            return kthSmallest(a, b, aleft, bmid + 1, k - k / 2);
        }
    }
}
