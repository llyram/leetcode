import java.util.Arrays;
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int[] remaining = new int[capacity.length];
        int bagsFilled = 0;
        
        for (int i=0; i<capacity.length; i++) {
            remaining[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(remaining);
        
        // System.out.println(remaining);
        
        for (int i=0; i<capacity.length; i++) {
            System.out.println(remaining[i]);
            
            if (additionalRocks >= remaining[i]) {
                additionalRocks -= remaining[i];                
                bagsFilled++;
            }
        }
        
        return bagsFilled;
    }
}