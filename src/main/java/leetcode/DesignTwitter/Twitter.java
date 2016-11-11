package leetcode.DesignTwitter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ymyue on 6/14/16.
 * Design: "pull" model - Fan-out-on-load
 * Time complexity:
 *  - constructor: O(1)
 *  - postTweet: O(1)
 *  - getNewFeed: O(10N*log(10))
 *  - follow: O(1)
 *  - unfollow: O(1)
 * Space complexity:
 *  - O(n)
 */
public class Twitter {
    private static class Tweet {
        int timestamp;
        int tweetId;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    private Map<Integer, Set<Integer>> follow = new HashMap<>();
    private Map<Integer, Deque<Tweet>> tweets = new HashMap<> ();
    private AtomicInteger timestamp;

    /** Initialize your data structure here. */
    public Twitter() {
        timestamp = new AtomicInteger(0);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp.getAndIncrement());
        tweets.putIfAbsent(userId, new ArrayDeque<Tweet>(11));
        Deque queue = tweets.get(userId);
        queue.offer(tweet);
        if (queue.size() > 10)
            queue.poll();
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<> (10);
        Set<Integer> followees = follow.getOrDefault(userId, new HashSet<> ());
        PriorityQueue<Tweet> pq = new PriorityQueue<> (20, (x, y) -> x.timestamp - y.timestamp);
        pq.addAll(tweets.getOrDefault(userId, new ArrayDeque<Tweet> ()));
        for (int follower : followees) {
            pq.addAll(tweets.getOrDefault(follower, new ArrayDeque<Tweet> ()));
            while (pq.size() > 10)
                pq.poll();
        }
        while (!pq.isEmpty())
            newsFeed.add(0, pq.poll().tweetId);
        return newsFeed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        follow.putIfAbsent(followerId, new HashSet<> ());
        follow.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId))
            follow.get(followerId).remove(followeeId);
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
