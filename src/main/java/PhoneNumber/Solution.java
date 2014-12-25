package PhoneNumber;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/15/14
 * Time: 9:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {

    static String convertSecondsToReadableTime(int seconds) {
        if (seconds <= 0)
            return "";
        int second = 1;
        int minute = second * 60;
        int hour = minute * 60;
        int day = hour*24;
        int month = day*30;
        int year = month*12;

        int years = 0;
        int months = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;

        if (seconds >= year)
            years = seconds / year;
        seconds = seconds - years * year;

        if (seconds >= month)
            months = seconds / month;
        seconds = seconds - months * month;

        if (days >= day)
            days = seconds / day;
        seconds = seconds - days * day;

        if (seconds >= hour)
            hours = seconds / hour;
        seconds = seconds - hours * hour;

        if (seconds >= minute)
            minutes = seconds / minute;
        seconds = seconds - minutes * minute;

        String rString = "";
        if (years != 0) {
            rString += years;
            rString += " years, ";
        }
        if (months != 0) {
            rString += months;
            rString += " months, ";
        }
        if (days != 0) {
            rString += days;
            rString += " days, ";
        }
        if (hours != 0) {
            rString += hours;
            rString += " hours, ";
        }
        if (minutes != 0) {
            rString += minutes;
            rString += " minutes, ";
        }
        if (seconds != 0) {
            rString += seconds;
            rString += " seconds, ";
        }
        if (rString.isEmpty())
            return rString;
        else
            return rString.substring(0, rString.length()-2);
    }

    public static int getMostProfit(int[] a) {
    for (int j =a.length-1; j >=1; j--)
        a[j] -= a[j-1];
    a[0] = 0;
    int sum = 0;
    int maxSum =0;
    for (int j =0; j < a.length; j++) {
        sum+=a[j];
        if (sum > maxSum)
            maxSum = sum;
        if (sum < 0)
            sum = 0;
    }
    return maxSum;
    }

static String queryPhoneNumByDigits(String digits, String contacts) {
    String noMatched = "no matched";

    if (digits == null || digits.isEmpty())
        return contacts;

    if (contacts == null || contacts.isEmpty())
        return noMatched;

    String [] contactArray = contacts.split(",");
    List<String> contactList = Arrays.asList(contactArray);
    List<Integer> indexs = new ArrayList<Integer>();
    for (int l = 0; l < contactList.size(); l++)
        indexs.add(-1);
    // index of char at current digit
    int i = 0;

    while (i < digits.length()) {
        for (int l = 0; l < contactList.size(); l++) {
            if (indexs.get(l) == -2)
                continue;
            String s = contactList.get(l);
            if (indexs.get(l)+1 < s.length()) {
                int index = s.substring(indexs.get(l)+1).indexOf(digits.charAt(i));
                if (index != -1) {
                    indexs.set(l, indexs.get(l)+1+index);
                } else {
                    indexs.set(l, -2);
                }
            } else {
                indexs.set(l, -2);
            }
        }
        i++;
    }

    String rString = "";
    int l = 0;
    for (String s : contactList) {
        if (indexs.get(l) != -2) {
            rString += s;
            rString += ",";
        }
        l++;
    }

    if (rString.isEmpty())
        return noMatched;
    else
        rString = rString.substring(0, rString.length()-1);
    return rString;
}
}
