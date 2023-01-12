class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();

        int max_area = Integer.MIN_VALUE; // variable to store max area 

        for(int i=0; i<heights.length; i++) { // iterate over heights array
            int index = i;
            while (!st.isEmpty() && heights[i] < st.peek()[1]){ // if current height is less than previous height
                index = st.peek()[0];
                max_area = Math.max(max_area, st.peek()[1] * (i-index));
                st.pop();
            } 
            st.push(new int[]{index, heights[i]});
        }

        while(!st.isEmpty()) { // check area of remaining values in the stack
            max_area = Math.max(max_area, st.peek()[1] * (heights.length - st.peek()[0]));

            st.pop();
        }

        return max_area;
    }
}