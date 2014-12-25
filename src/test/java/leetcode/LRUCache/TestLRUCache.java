package LRUCache;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/29/14
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLRUCache {
    @Test
    public void Test1() {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        assertEquals(cache.get(2), 1);
    }
}
