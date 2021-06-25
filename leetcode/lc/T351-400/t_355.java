package leetcoder;

import java.util.*;


class Twitter {
    private Stack<Integer>  tweets = new Stack<>();
    private Map<Integer,Integer> tweetsMap = new HashMap<>();
    private List<Set<Integer>> users = new ArrayList<>();

    public Twitter() {
        for (int i = 0; i < 1000; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(i);
            users.add(s);
        }
    }
    public void postTweet(int userId, int tweetId) {
        tweets.push(tweetId);
        tweetsMap.put(tweetId,userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res= new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        while(res.size() < 10 ){
            if (tweets.size() == 0) break;;
            int tmpId = tweets.pop();
            s.push(tmpId);
            if(users.get(userId).contains(tweetsMap.get(tmpId)))
                res.add(tmpId);
        }
        while(!s.isEmpty()){
            tweets.add(s.pop());
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId !=  followeeId)
            users.get(followerId).remove(followeeId);
    }
}











public class AAA {
    public static void main(String[] args) {

    }
}
