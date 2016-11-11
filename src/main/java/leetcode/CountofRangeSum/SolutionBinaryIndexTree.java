package leetcode.CountofRangeSum;

/**
 * Created by ymyue on 7/30/16.
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 */
public class SolutionBinaryIndexTree {
    class BinaryIndexTree {
        int[] BITree;
        int n;
        public void update(int index, int val) {
            index += 1;
            while (index <= n) {
                BITree[index] += val;
                index += index & (-index);
            }
        }

        public void getSum(int index) {
            index += 1;
            int sum = 0;
            while (index > 0) {
                sum += BITree[index];
                index -= index & (-index);
            }
        }

        public BinaryIndexTree(int[] input) {
            this.n = input.length;
            this.BITree = new int[n+1];
            for (int i = 0; i < n; i++)
                update(i, input[i]);
        }
    }
}
