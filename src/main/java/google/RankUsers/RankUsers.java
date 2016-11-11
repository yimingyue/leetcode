package google.RankUsers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ymyue on 10/5/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=183346&highlight=google
 */
public class RankUsers {
    public static class TreeNode {
        Set<String> ids;
        int score;
        int num;    // number of nodes on left sub tree
        TreeNode left;
        TreeNode right;
    }

    TreeNode root = null;
    Map<String, Integer> map;
    public RankUsers() {
        map = new HashMap<>();
    }

    public boolean addUser(String id, int score) {
        if (map.containsKey(id)) {
            deleteNode(root, map.get(id), id);
            map.put(id, score);
            addNode(root, score, id);
            return false;
        } else {
            map.put(id, score);
            addNode(root, score, id);
            return true;
        }
    }

    public String findByRank(int k) {
         return findByRank(root, k);
    }

    // log(N)
    // Virtual Delete
    private void deleteNode(TreeNode root, int score, String id) {
        if (root == null)
            return;
        if (root.score == score) {
            root.ids.remove(id);
        } else if (root.score < score) {
            deleteNode(root.right, score, id);
        } else {
            root.num--;
            deleteNode(root.left, score, id);
        }
    }

    // logN
    private void addNode(TreeNode root, int score, String id) {
        if (root == null)
            return;
        if (root.score == score) {
            root.ids.add(id);
        } else if (root.score < score)
            addNode(root.right, score, id);
        else {
            root.num++;
            addNode(root.left, score, id);
        }
    }

    public String findByRank(TreeNode root, int k) {
        if (root == null)
            return null;
        if (k > root.num && k <= root.num + root.ids.size())
            return root.ids.iterator().next();
        else if (k < root.num)
            return findByRank(root.left, k);
        else
            return findByRank(root.right, k - root.num - root.ids.size());
    }
}
