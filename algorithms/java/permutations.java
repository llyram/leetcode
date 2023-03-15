class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, 0);

        return res;

    }

    public void permute(List<List<Integer>> res, int[] nums, int start) {
        if(start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i:nums) list.add(i);
            res.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            permute(res, nums, start+1);
            swap(nums, i, start);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}