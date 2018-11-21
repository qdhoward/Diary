package NewAutumn.mock.thursday;

import java.util.Arrays;

public class t_11_17_2018 {
    //time: o(nlogn)
    //space: o(1)

    public int smallestDistancePair(int[] nums, int k) {
        // sort array to get the middle distance
        Arrays.sort(nums);
        // low distance: 0
        // high distance: the max_val - min_val
        int n = nums.length, low = 0, hi = nums[n - 1] - nums[0];
        while (low < hi) {
            // count : to count the number of distance that less or equal to
            //the middle distance
            int cnt = 0, j = 0, mid = (low + hi) / 2;
            for (int i = 0; i < n; ++i) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                // count is j - i - 1 is to count from i to j, how many
                // pair of distance that less or equal to middel distance
                // j - i - 1 is because when after j++, num[j] - num[i] > mid,
                // need to change j to j -1;
                // and the pair is (j-1)-i
                cnt += j - i - 1;
            }
            // if count >= k, means the number of distance <= middle is lager or equal to k
            //if we want to find the kth distance, we need to narrow the high down
            if (cnt >= k) {
                hi = mid;
            } else low = mid + 1;
        }

        return low;
    }
}
