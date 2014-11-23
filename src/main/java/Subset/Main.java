package Subset;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 3/11/14
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] argv) {
        Solution s = new Solution();
        int [] num = {1,4,3,5,4,4,7,7,8,0};
        System.out.println(s.subsetsWithDup(num));
    }
}
