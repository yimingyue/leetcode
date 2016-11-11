package leetcode.DesignHitCounter;

import org.junit.Test;

/**
 * Created by ymyue on 7/16/16.
 */
public class TestHitCounter {

    @Test
    public void test0() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(4);
        hitCounter.getHits(300);
        hitCounter.getHits(301);
        hitCounter.getHits(302);
        hitCounter.getHits(303);
        hitCounter.getHits(304);
        hitCounter.hit(501);
        hitCounter.getHits(600);
    }
}
