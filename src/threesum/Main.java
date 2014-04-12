package threesum;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/4/14
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        int [] num = {0,2,1,-3};
        Solution s = new Solution();
        int r = s.threeSumClosest(num, 1);
        System.out.println(r);
    }
}
