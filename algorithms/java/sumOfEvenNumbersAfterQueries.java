class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ret = new int[queries.length];
        
        // Get the sum of all even elements
        int evenSum = 0;
        for(int n:nums) {
            if (n%2 == 0)
                evenSum += n;
        }
        
        
        for(int i=0; i<queries.length; i++){
            int val = queries[i][0], index = queries[i][1];
            
            if (nums[index] % 2 == 0) {
                // If even val is added to even num then the even sum is increased by val
                if(val % 2 == 0) { 
                    evenSum += val;
                }
                // If odd val is added to even num then the num becomes odd and must be subtracted from the sum of even numbers
                else {
                    evenSum -= nums[index];
                }
            } else {
                // If num is odd and val is odd then then num + val must be added to the even sum
                if(val % 2 != 0) {
                    evenSum += nums[index] + val;
                }
            }
            
            nums[index] += val;            
            ret[i] = evenSum;
            
        }
        
        return ret;
    }
}