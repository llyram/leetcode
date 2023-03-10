class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closest_sum = nums[0] + nums[1] + nums[nums.length - 1];
        int curr_sum;
        
        
        for(int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                curr_sum = nums[i] + nums[left] + nums[right];
               
                if (curr_sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(target - curr_sum) < Math.abs(target - closest_sum)) {
                   closest_sum = curr_sum;
               } 
            }    
        }
        
        return closest_sum;
    }
}