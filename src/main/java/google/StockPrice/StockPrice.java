package google.StockPrice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/1/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=202732&highlight=google
 */
public class StockPrice {
    Map<Integer, Integer> map = new HashMap<>();

    public void addPrice(int timestamp, double price) {
        map.put(timestamp, (int)(price * 100));
    }

    public double getPrice(int timestamp) {
        return ((double)map.get(timestamp)) / 100;
    }

    public double getNewestPrice() {
        int timestamp = 0;
        int price = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > timestamp)
                price = entry.getKey();
        }
        return (double)(price) /100;
    }

    public double getHighestPrice() {
        int highestPrice = 0;
        for (int price : map.values()) {
            highestPrice = Math.max(highestPrice, price);
        }
        return (double)highestPrice / 100;
    }

    public double getLowestPrice() {
        int lowestPrice = Integer.MAX_VALUE;
        for (int price : map.values())
            lowestPrice = Math.min(lowestPrice, price);
        return (double)lowestPrice / 100;
    }

    public void remove(int timestamp) {
        map.remove(timestamp);
    }
}
