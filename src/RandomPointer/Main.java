package RandomPointer;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/10/14
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        RandomListNode head = new RandomListNode(-1);
        head.next = null;
        head.random = null;
        Solution s = new Solution();
        RandomListNode c = s.copyRandomList(head);
    }
}
