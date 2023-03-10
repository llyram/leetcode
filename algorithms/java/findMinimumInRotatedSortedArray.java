class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = end / 2;
        int min = nums[start];
        while(start <= end) {
            min = Math.min(min, nums[mid]); // set min value

            if(nums[start] < nums[end]) {       // if array is already sorted 
                return Math.min(min, nums[start]); // check if left most value is less than the min value stored and return
            }

            if(nums[mid] >= nums[start]){ // if mid value is greater than the start value then search the right subarray
                start = mid+1;
            } else { // if mid value is less than the start value then search the left subarray
                end = mid-1;
            }

            mid = (start + end) / 2;
        }

        return min;
    }
}