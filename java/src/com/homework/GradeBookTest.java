package com.homework;

public class GradeBookTest {
    public static void main(String[] args) {
        int[] grades ={100,90,99,70,75,80,82,90,88,99,78,58,68,40};
        GradeBook gb = new GradeBook("Math",grades);
        System.out.printf("Welcome to the World: %n%s%n%n", gb.getCourseName());
        gb.processGrades();



    }
}
