class Twitter {
    LinkedList<Integer> q;
    HashMap<Integer, Integer> tweets;
    HashMap<Integer, List<Integer>> followList;

    public Twitter() {
        q = new LinkedList<>();
        followList = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.put(tweetId, userId);
        q.addFirst(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> follows = followList.getOrDefault(userId, new ArrayList<>());
        List<Integer> feed = new ArrayList<>();
        for(int i=0; i<q.size(); i++) {
            if(
                follows.contains(
                    tweets.get(
                        q.get(i)
                    )
                ) || (
                    tweets.get(q.get(i)) == userId
                )
            ) {
                feed.add(q.get(i));
            }
            if(feed.size() >= 10) break;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followList.containsKey(followerId)) {
            followList.put(followerId, new ArrayList<>());
        } 
        followList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followList.containsKey(followerId)) {
            return;
        }
        // if(!followList.get(followerId).contains(followeeId)) return;
        followList.get(followerId).remove(Integer.valueOf(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */