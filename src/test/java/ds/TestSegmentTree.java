package ds;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/16/16.
 */
public class TestSegmentTree {
    @Test
    public void test0() {
        SegmentTree segmentTree = new SegmentTree(new int[]{-1, 2, 4, -3, 5}) ;
        Assert.assertEquals(4, segmentTree.rangeMax(0, 2));
        Assert.assertEquals(4, segmentTree.rangeMax(1, 3));
        Assert.assertEquals(5, segmentTree.rangeMax(2, 4));
        Assert.assertEquals(2, segmentTree.rangeMax(0, 1));
        Assert.assertEquals(-3, segmentTree.rangeMax(3, 3));
    }
}
