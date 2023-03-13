class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        dfs(res, combination, candidates, 0, target, 0);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> combination, int[] candidates, int sum, int target, int index) {
        if(index >= candidates.length) {
            return;
        }
        if(sum == target) {
            // combination.add(candidates[index]);
            res.add(new ArrayList<>(combination));
        } else if (sum > target) {
            return;
        } else {

            // adding current value
            combination.add(candidates[index]);
            dfs(res, combination, candidates, sum + candidates[index], target, index);
            
            combination.remove(combination.size()-1);
            dfs(res, combination, candidates, sum, target, index+1);

        }

    }
}