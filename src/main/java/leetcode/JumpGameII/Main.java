package leetcode.JumpGameII;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/23/14
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        int [] A = new int[25002];
        int i = 0;
        for (; i < 25000; i++)
            A[i] = 25000-i;
        A[i++] = 1;
        A[i++] = 0;
        System.out.println(s.jump(A));
    }
}
