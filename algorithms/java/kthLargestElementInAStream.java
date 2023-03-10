class KthLargest {

    private PriorityQueue<Integer> pq;
    private int _k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        _k = k;
        for(int i:nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size() < _k || val > pq.peek()) {
            pq.add(val);
        }
        if(pq.size() > _k) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */