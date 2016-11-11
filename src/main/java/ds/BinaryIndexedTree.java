package ds;

/**
 * Created by ymyue on 10/15/16.
 */
public class BinaryIndexedTree {
    private int[] array;
    private int[] tree;
    public BinaryIndexedTree(int[] array) {
        this.array = array;
        this.tree = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            update(i, array[i]);
        }
    }

    private void update(int idx, int val) {
        int diff = val - array[idx];
        idx++;
        while (idx < tree.length) {
            tree[idx] += diff;
            idx = getNext(idx);
        }
    }

    private int getParent(int idx) {
        return idx - (idx & (-idx));
    }

    private int getNext(int idx) {
        return idx + (idx & (-idx));
    }
}
