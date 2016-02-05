package interview.amazon.Staircase;

/**
 * Created by ymyue on 1/11/16.
 */
public class Solution {
    public void StairCase(int n) {
        if (n < 1 || n > 100)
            return;
        for (int i = 0; i < n; i++) {

            int j = 0;
            while (j < n-i-1) {
                System.out.print(' ');
                j++;
            }
            while (j < n){
                System.out.print('#');
                j++;
            }
            if (i != n)
                System.out.println();
        }
    }
}
