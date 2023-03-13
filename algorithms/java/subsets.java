class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(0, res, nums, sub);

        return res;
    }

    public void dfs(int i, List<List<Integer>> res, int[] nums, List<Integer> sub) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(sub));
        } else {
            sub.add(nums[i]);
            dfs(i+1, res, nums, sub);

            sub.remove(sub.size()-1);
            dfs(i+1, res, nums, sub);
        }
    }
    
}