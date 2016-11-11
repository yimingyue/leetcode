package leetcode.DesignHitCounter;

/**
 * Created by ymyue on 7/16/16.
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class HitCounter {
    int timestamp = 1;
    int range = 300;
    int[] hits = new int[range];
    int count = 0;

    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        wipe(timestamp);
        hits[timestamp%range]++;
        count++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        wipe(timestamp);
        return count;
    }

    private synchronized void wipe(int timestamp) {
        int len = Math.min(timestamp - this.timestamp, range);
        for (int i = 1; i <= len; i++) {
            count -= hits[(this.timestamp+i)%range];
            hits[(this.timestamp+i)%range] = 0;
        }
        this.timestamp = timestamp;
    }
}
