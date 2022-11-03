class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums) {
            set.add(i);
        }
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            int len = 1;
            if(set.contains(nums[i]-1)) {
                continue;
            }
            while(set.contains(++nums[i])) {
                len++;
            }
            
            res = Math.max(res, len);
        }
        
        return res;
    }
}