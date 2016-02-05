package leetcode.KthLargestElementinanArray;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ymyue on 1/24/16.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<> (nums.length, new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
                if (v1 == v2)
                    return 0;
                return v1 > v2 ? -1 : 1;
            }
        });
            for (int num : nums) {
                pq.offer(num);
            }
            int result = 0;
            for (int i = 0; i < k; i++)
            result = pq.poll();
            return result;
        }

    private void buildHeap(int[] heap) {
        for (int i = heap.length/2; i >= 0; i--)
            minify(heap, i);
    }

    private void minify(int[] heap, int i) {
        int smallest = i;
        if (2*i+1 < heap.length && heap[smallest] > heap[2*i+1])
            smallest = 2*i+1;
        if (2*i+2 < heap.length && heap[smallest] > heap[2*i+2])
            smallest = 2*i+2;
        if (smallest != i) {
            int tmp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = tmp;
            minify(heap, smallest);
        }
    }

    private void insertHeap(int[] heap, int val) {
        if (heap[0] >= val)
            return;
        heap[0] = val;
        minify(heap, 0);
    }
}
