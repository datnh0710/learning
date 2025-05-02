package com.EmunClass;

public enum EmunClass {
    JHTP("Java How to program", "2015"),
    CHTP("C How to program", "2013"),
    IW3HTP("Internet & World Wide Web How to Program", "2012");

    private String title;
    private String copyRightYear;

    EmunClass(String title, String copyRightYear) {
        this.title = title;
        this.copyRightYear = copyRightYear;
    }
    public String getTitle(){
        return title;
    }
    public String getCopyRightYear(){
        return copyRightYear;
    }

}
