class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Get a count of all the characters in tasks
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Create new Max Priority queue and add the values of the tasks count
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: map.values()) {
            pq.add(i);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        // The loop must continue till the priority queue and the queue both have elements remaining
        while(pq.size() > 0 || q.size() > 0) {
            time++;
            // If pq has elements then pop the most frequent element and add to the queue along with the time interval it can be used at next
            if(pq.size() > 0) {
                int cnt = pq.poll() - 1;
                if (cnt != 0) {
                    q.add(new int[]{cnt, time+n});
                }
            }

            // if the queue has elements and the front of the queue has cooled down then add it back to the pq
            if (q.size() > 0 && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }

            // If both the pq is empty and the queue has no elements that have cooled down then the time unit is idle
        }

        return time;
    }
}