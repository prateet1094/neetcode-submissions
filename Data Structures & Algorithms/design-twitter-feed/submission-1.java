class Twitter {
    class Node {
        Tweet tweet;
        Node next;
        Node(Tweet tweet){
            this.tweet = tweet;
        }
    }
   class Tweet {
        public int timestamp;
        public int tweetId;
        public Tweet(int timestamp,int tweetId){
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }
   

    public static int currtime;
    HashMap<Integer,HashSet<Integer>> following;
    HashMap<Integer,Node> tweets;

 


    public Twitter() {
        currtime = 0;
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        currtime++;
        follow(userId,userId);

        if(!tweets.containsKey(userId)){
            tweets.put(userId,new Node(new Tweet(currtime,tweetId)));
        } else{
            Node newHead = new Node(new Tweet(currtime,tweetId));
            newHead.next  = tweets.get(userId);
            tweets.put(userId,newHead);
            
        }

        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->b.tweet.timestamp-a.tweet.timestamp);
        if(following.containsKey(userId)){
            for(int followee: following.get(userId)){
                if(tweets.containsKey(followee)){
                    queue.add(tweets.get(followee));
                }
            }
            while(!queue.isEmpty() && result.size()<10){
                Node tw = queue.remove();
                result.add(tw.tweet.tweetId);
                if(tw.next!=null){
                    queue.add(tw.next);
                }
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId,new HashSet<Integer>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}
