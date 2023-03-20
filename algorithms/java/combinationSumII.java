class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(res, combination, candidates, target, 0);

        return res;
    }

    public void dfs(
        List<List<Integer>> res, 
        List<Integer> combination, 
        int[] candidates, 
        int target, 
        int index
    ) {
       if(target == 0) {
           res.add(new ArrayList<>(combination));
       } else if (target > 0) {
           for(int i=index; i < candidates.length; i++) {
               if(i>index && candidates[i] == candidates[i-1]) continue;
               combination.add(candidates[i]);
               dfs(res, combination, candidates, target - candidates[i], i+1);
               combination.remove(combination.size() - 1);
           }
       }
    }
}