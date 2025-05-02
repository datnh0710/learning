package com.leetcode;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {

    }

    /**
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid =0;
        while(left<=right){
            mid = left + (right-left)/2;
            int val = guess(mid);
            if(val == 0)
                break;
            else if (val == -1){
                right= mid;
            }else{
                left = mid +1;
            }

        }
        return mid;
    }

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    private int guess(int num) {
        return 0;
    }
}
