class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            if(map.keySet().contains(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
                return res;
            }
            
            map.put(target-nums[i], i);
        }
        
        return res;
    }
}