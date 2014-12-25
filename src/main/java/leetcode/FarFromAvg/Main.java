package leetcode.FarFromAvg;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/23/14
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
//        int [] a = {-7, -7, -31, 186 , -98, 63, 22345, -71376263, 1,3,10};
        int [] a = {-2,147,483,648, 1, 2,147,483,647, 2,147,483,647};
        System.out.println(s.solution(a));
    }
}
