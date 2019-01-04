package LeetCode.Topic.Array;

import java.util.*;

public class MajorityElementII229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        } else if (nums.length == 1) {
            return Collections.singletonList(nums[0]);
        }
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 1;
        int count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
//        System.out.println(candidate1);
//        System.out.println(candidate2);
//        System.out.println(count1);
//        System.out.println(count2);
        count1 = 0;
        count2 = 0;
        //TODO 最后再扫一遍，看看两个candidate哪个只真正的majority
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3 && count2 > nums.length / 3) {
            return Arrays.asList(candidate1, candidate2);
        } else if (count1 > nums.length / 3 || count2 > nums.length / 3){
            return count1 > nums.length / 3 ? Collections.singletonList(candidate1) : Collections.singletonList(candidate2);
        } else {
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        System.out.println(new MajorityElementII229().majorityElement(new int[] {3, 2, 3}));
    }
}
