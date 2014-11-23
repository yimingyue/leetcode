package PhoneNumber;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/15/14
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main (String [] args) {
        String digits = "777";
        String contacts = "777777,187562870,18633228756,13472120213,187562870";
        System.out.println(Solution.queryPhoneNumByDigits(digits, contacts));
//        System.out.println(Solution.convertSecondsToReadableTime(128));
//        int [] a = {105,106,105,103,104,105,108,110,109,102,103,108};
//        System.out.println(Solution.getMostProfit(a));
    }
}
