package TwoSum;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 3/14/14
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        int [] numbers = {3,2,4};
        for (int i : s.twoSum(numbers, 6))
            System.out.println(i);
    }
}
