class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int j=0; j<nums.length; j++) {
            nums[i] = nums[j];
            if(nums[j] != val) {
                i++;
            }
        }

        return i;
    }
}