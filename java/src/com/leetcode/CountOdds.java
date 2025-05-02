package com.leetcode;

/**
 * @author datnh0710
 * @created 14/11/2023 - 4:02 PM
 * @packege com.leetcode
 * @project java
 */
public class CountOdds {
    public int countOdds(int low, int high) {
        int count = 0;

        if (low%2 !=0){
            ++count;
            int i = low;
            while (i <= high){
                ++count;
                i+=2;
            }
        }else{
            int i = low+1;
            while (i <= high){
                ++count;
                i+=2;
            }
        }
        return count;
    }

    public int countOdds1(int low, int high) {
        if(low%2==0 && high%2==0)
            return (high-low)/2;
        else if(low%2==1 && high%2==1)
            return (high-low)/2+1;
        else
            return (high-low+1)/2;
    }
}
