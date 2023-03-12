class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i:stones) {
            pq.add(i);
        }

        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if(x == y) {
                continue;
            }
            
            pq.add(y-x);
        }

        if(pq.size() == 1) {
            return pq.poll();
        }

        return 0;
    }
}