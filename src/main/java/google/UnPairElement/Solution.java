package google.UnPairElement;

/**
 * Created by ymyue on 10/15/16.
 */
public class Solution {
    public int unpairedElement(int[] array) {
        int low = 0;
        int high = array.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                if (mid+1 == array.length)
                    return array[mid];
                else if (array[mid] == array[mid+1])
                    low = mid+2;
                else
                    high = mid;
            } else {
                if (array[mid] == array[mid-1])
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        return array[low];
    }
}
