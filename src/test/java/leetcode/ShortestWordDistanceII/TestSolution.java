package leetcode.ShortestWordDistanceII;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/12/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        WordDistance wordDistance = new WordDistance(new String[]{"a", "b"});
        Assert.assertEquals(1, wordDistance.shortest("a", "b"));
        Assert.assertEquals(1, wordDistance.shortest("b", "a"));
    }
}
