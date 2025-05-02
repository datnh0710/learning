package com.leetcode;

/**
 * @author datnh0710
 * @created 13/11/2023 - 9:48 PM
 * @packege com.leetcode
 * @project java
 */
public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        if (sentences.length <= 0){
            return res;
        }else{
            res = sentences[0].trim().split(" ").length;

            int size = sentences.length;
            for (int i = 1; i < size; i++) {
                int tmp = sentences[i].trim().split(" ").length;
                if (res < tmp){
                    res = tmp;
                }
            }
        }

        return res;
    }
}
