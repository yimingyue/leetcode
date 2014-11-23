package TrappingRainWater;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/25/14
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main (String [] args) {
        Solution s = new Solution();
//        int [] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] A = {4,2,3};
        System.out.println(s.trap(A));

    }
}
