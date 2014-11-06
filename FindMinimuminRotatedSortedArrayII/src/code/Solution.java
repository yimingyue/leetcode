package code;
public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0)
            return -1;

        return findMinWithIndex(num, 0, num.length-1);
    }

    private int findMinWithIndex(int [] num, int start, int end) {
        if (start == end)
            return num[start];

        if (start == (end-1))
            return num[start] < num[end] ? num[start] : num[end];

        int mid = (start + end) / 2;

        if (num[start] == num[mid] && num[mid] == num[end]) {
            start++;
            while (start != mid) {
                if (num[start] == num[start-1])
                    start++;
                else
                    break;
            }
            end--;
            while (end != mid) {
                if (num[end] == num[end+1])
                    end--;
                else
                    break;
            }
            return findMinWithIndex(num, start, end);
        }

        if (num[start] < num[end]) {
            if (num[start] > num[mid] || num[mid] > num[end]) {
                System.out.println("Invalid input, not a rotated sorted list!");
                System.exit(-1);
            }
            return num[start];
        }

        if (num[start] <= num[mid] || num[mid] > num[end]) {
            if (num[start] < num[end]) {
                System.out.println("Invalid input, not a rotated sorted list!");
                System.exit(-1);
            }
            return findMinWithIndex(num, mid+1, end);
        }

        if (num[start] > num[mid] || num[mid] <= num[end]) {
            if (num[start] < num[end]) {
                System.out.println("Invalid input, not a rotated sorted list!");
                System.exit(-1);
            }
            return findMinWithIndex(num, start+1, mid);
        }

        if (num[start] > num[mid] && num[mid] > num[end]) {
            System.out.println("Invalid input, not a rotated sorted list!");
            System.exit(-1);
        }

        System.out.println("Invalid input, not a rotated sorted list!");
        System.exit(-1);
        return -1;
    }

    public static void main(String [] args) {
        Solution s = new Solution();
        int [] num = {1, 1, 3};
        System.out.println(s.findMin(num));
    }
}