package leetcode.RotateArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ymyue on 10/31/15.
 */
public class TestRotateArray {
    @Test
    public void test1() {
        int[] inputArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        int[] outputArr = {17,18,19,20,21,22,23,24,25,26,27,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Solution s = new Solution();
        s.rotate(inputArr, 38);
        assertArrayEquals(inputArr, outputArr);
    }

}
