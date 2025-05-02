package com.leetcode;

/**
 * @author datnh0710
 * @created 08/11/2023 - 11:39 PM
 * @packege com.leetcode
 * @project java
 */
public class CountValidWords {
    public static void main(String[] args) {

    }

    public int countValidWords(String sentence) {
        int count = 0;
        String [] tmp = sentence.trim().split("\\s+");

        for(String s : tmp){
            if(valueStr(s)){
                ++count;
            }
        }
        return count;
    }

    public boolean valueStr(String s){
        int hyphen = 0;

        char[] cs = s.toCharArray();
        int i = 0;

        for (char c : cs){
            if (Character.isDigit(c)){
                return false;
            }
            if (c == '-'){
                if (i == 0 || !Character.isLowerCase(cs[i-1])){
                    return false;
                }
                if (i+1 == cs.length || !Character.isLowerCase(cs[i+1])){
                    return false;
                }
                if (++hyphen > 1){
                    return false;
                }
            }else if(c == '!' || c== '.' || c== ','){
                if (i != cs.length - 1 ){
                    return false;
                }
            }

            i++;
        }

        return true;
    }

}
