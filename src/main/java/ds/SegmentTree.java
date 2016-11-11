package ds;

/**
 * Created by ymyue on 10/16/16.
 */
public class SegmentTree {
    int[] tree;
    int n;
    public SegmentTree(int[] array) {
        this.n = array.length;
        int m = n;
        while ((m & (m-1)) != 0) {
            m += m & -m;
        }
        tree = new int[2*m-1];
        buildTree(array, 0, array.length-1, 0, tree);
    }

    private void buildTree(int[] array, int low, int high, int pos, int[] tree) {
        if (low == high)
            tree[pos] = array[low];
        else {
            int mid = low + (high - low) / 2;
            buildTree(array, low, mid, 2*pos+1, tree);
            buildTree(array, mid+1, high, 2 * pos+2, tree);
            tree[pos] = Math.max(tree[2*pos+1], tree[2*pos+2]);
        }
    }

    public int rangeMax(int i, int j) {
        return rangeMax(i, j, 0, n-1, 0);
    }

    private int rangeMax(int i, int j, int low, int high, int pos) {
        if (i <= low && j >= high)
            return tree[pos];
        else if (j < low || i > high) {
            return Integer.MIN_VALUE;
        } else {
            int mid = low + (high - low) / 2;
            return Math.max(rangeMax(i, j, low, mid, 2*pos+1), rangeMax(i, j, mid+1, high, 2*pos + 2));
        }
    }
}
