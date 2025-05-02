package com.leetcode;

public class XOROperationinanArray {
    public static void main(String[] args) {

    }

    public int xorOperation(int n, int start) {
        if (n == 1)
            return start;
        int cur = 0;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            cur = start + 2 * i;
            xor ^= cur;
        }
        return xor;
    }
}
