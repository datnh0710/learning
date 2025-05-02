package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author datnh0710
 * @created 14/11/2023 - 12:21 PM
 * @packege com.leetcode
 * @project java
 */
public class ReformatDate {
    public static void main(String[] args) {
        String date = "20th Oct 2052";
        reformatDate(date);
    }
    public static String reformatDate(String date) {

        String res = "";
        String[] arrDate = date.trim().split(" ");
        String[] arr = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        if (Integer.parseInt(arrDate[2]) >= 1900 && Integer.parseInt(arrDate[2]) <= 2100){
            res += arrDate[2] + "-";
        }

        for (int i = 0; i < arr.length; i++) {
            if (arrDate[1].equals(arr[i])){
                if (i>8){
                    res += i + 1 + "-";
                }else{
                    res += "0" + i + 1 + "-";
                }

            }
        }
        String tmp = "";
        for (char c : arrDate[0].toCharArray()){
            if (Character.isDigit(c)){
                tmp += String.valueOf(c);
            }
        }
        if (tmp.length()<=1){
            tmp = "0"+tmp;
        }

        return res+tmp;
    }
}
