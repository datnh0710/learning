package com.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author datnh0710
 * @created 10/11/2021 - 8:36 PM
 * @packege com.leetcode
 * @project java
 */
public class Question1 {
    public static void main(String[] args) {

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> mapBan = new HashMap<>();
        for (String ban : banned){
            mapBan.put(ban.toLowerCase(),1);
        }
        //String[] tmp = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        String[] tmp = paragraph.replaceAll("[\\W]", " ").toLowerCase().split("\\s+");
        Map<String,Integer> map = new HashMap<>();

        for (String str : tmp ){
            if(!mapBan.containsKey(str)){
                if(!map.containsKey(str)){
                    map.put(str,1);
                }else{
                    map.put(str,map.get(str)+1);
                }
            }
        }
        int max = (Collections.max(map.values()));
        String final_str = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() == max) {
                final_str = entry.getKey();
            }
        }
        return final_str;

    }
}
