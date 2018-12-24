package LeetCode.Topic.Array;

public class FindtheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[nums[0]];
        int hare = nums[nums[nums[0]]];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
