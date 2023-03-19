class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        Arrays.sort(nums);
        subset(res, sub, nums, 0);

        return res;
    }

    public void subset(List<List<Integer>> res, List<Integer> sub, int[] nums, int i) {
        if(i==nums.length) {
            res.add(new ArrayList(sub));
            return;
        }
        sub.add(nums[i]);
        subset(res, sub, nums, i+1);
        sub.remove(sub.size()-1);
        while(i+1<nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        subset(res, sub, nums, i+1);

    }
}