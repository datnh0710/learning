package com.leetcode;

import java.util.ArrayList;


public class BrowserHistory {

    private ArrayList<String> homepages;
    private int current_index;
    private int max_index;


    public BrowserHistory(String homepage) {
        homepages = new ArrayList<>();
        homepages.add(homepage);
    }

    public void visit(String url) {
        ++current_index;
        homepages.add(current_index, url);
        max_index = current_index;
    }

    public String back(int steps) {
        current_index = Math.max(0, current_index - steps);
        return homepages.get(current_index);
    }

    public String forward(int steps) {
        current_index = Math.min(max_index, current_index + steps);
        return homepages.get(current_index);
    }
}
