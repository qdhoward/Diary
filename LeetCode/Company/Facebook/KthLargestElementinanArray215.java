package LeetCode.Company.Facebook;

public class KthLargestElementinanArray215 {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
        // System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    private void quickSelect(int[] nums, int left, int right, int k) {
        int index = partition(nums, left, right);
        if (index == k) {
            return;
        } else if (index > k) {
            quickSelect(nums, left, index - 1, k);
        } else {
            quickSelect(nums, index + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int index = left + (int) (Math.random() * (right - left + 1));
        int pivot = nums[index];
        swap(nums, right, index);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (nums[leftBound] < pivot) {
                leftBound++;
            } else if (nums[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(nums, leftBound++, rightBound--);
            }
        }
        swap(nums, leftBound, right);
        // System.out.println(pivot);
        // System.out.println(leftBound);
        return leftBound;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
