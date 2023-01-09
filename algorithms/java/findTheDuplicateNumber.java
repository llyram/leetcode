class Solution {
    public int findDuplicate(int[] nums) {
        // Floyd's Algorithm

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);

        int n = 0;

        while(n != slow) {
            n = nums[n];
            slow = nums[slow];
        }

        return n;
    }
}