package leetcode.SerializeandDeserializeBinaryTree;

import ds.TreeNode;
import org.junit.Test;

/**
 * Created by ymyue on 12/10/15.
 */
public class TestCodec {
    @Test
    public void test0() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Codec codec = new Codec();
        TreeNode dRoot = codec.deserialize(codec.serialize(root));
    }
}
