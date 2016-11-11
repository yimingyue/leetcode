package google.IntegerToIpAddress;

/**
 * Created by ymyue on 10/5/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=202563&highlight=google
 * Question 1
 * 1. 给一个 32bit的integer, convert 成 IP address, like 1.2.3.4 。 其中每8bit代表IP里的一个数字。
 */
public class Solution {
    public String getIpAddress(int val) {
        return new StringBuilder().append(val >> 24).append('.').append((val >> 16) & 0xff).append('.').append((val >> 8) & 0xff).append('.').append(val & 0xff).toString();
    }
}
