package leetcode.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/31/15.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<> ();
        list.add(root.val);
        List<Integer> rList = rightSideView(root.right);
        List<Integer> lList =  rightSideView (root.left);
        list.addAll(rList);
        if (lList.size() > rList.size())
            list.addAll(lList.subList(rList.size(), lList.size()));
        return list;
    }
}
