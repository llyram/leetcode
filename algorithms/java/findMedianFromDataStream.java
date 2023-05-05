class MedianFinder {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    boolean even;    

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even) {
            pq2.add(num);
            pq1.add(pq2.poll());
        } else {
            pq1.add(num);
            pq2.add(pq1.poll());
        }

        even = !even;
    }
    
    public double findMedian() {
        if(even) {
            return (double)(pq1.peek() + pq2.peek()) / 2;
        } else {
            return pq1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */