class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                   
                    // Compare method for place element in
                    // reverse order
                    public int compare(int[] a, int[] b)
                    {
                        int A = a[0]*a[0] + a[1]*a[1];
                        int B = b[0]*b[0] + b[1]*b[1];
                        if (A > B)
                            return 1;
                        if (B > A)
                            return -1;
                        return 0;
                    }
                }
        );
        for(int[] i: points) {
            pq.add(i);
        }

        int[][] res = new int[k][2];

        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}