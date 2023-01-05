class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // Sort position and speed based on position
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        for(int i=0; i<position.length; i++) {
            speed[i] = map.get(position[i]);
        }
        // code for sorting ends

        // create a stack for storing time taken to target
        Stack<Float> st = new Stack<>();

        for(int i=position.length-1; i>=0; i--) {
            // calculate time taken by i to reach target
            float currTime = (float)(target - position[i]) / speed[i];
            
            if (st.isEmpty()) {
                st.push(currTime);
                continue;
            }

            // if time taken by curr car to reach target is more than time taken by car ahead then a new fleet will be formed so we push the time to the stack. 
            // if time taken by curr car to reach target is less than time taken by car ahead then curr car will join the fleet of the car ahead and no push to stack is required.
            if (currTime > st.peek()) {
                st.push(currTime);
            }
        }
        // we return the size of the stack which is the number of fleets.
        return st.size();


    }
}