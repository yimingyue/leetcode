package AppAnnie;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 6/8/14
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution solution = new Solution();
        boolean  [][] matrix = {{true,true,true},{true,false,true},{true,true,true}};
        solution.shortestPath(matrix);
    }
}
