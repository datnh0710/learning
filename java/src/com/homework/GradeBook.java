package com.homework;

import java.util.Arrays;

public class GradeBook {
    private String courseName;
    private int[] grades;


    public GradeBook(String courseName, int[] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    public void processGrades() {
        outputGrades();

        System.out.printf("%nClass average is %2.0f%n", getAverage());

        System.out.printf("Lowest grade is %d%nHigh grade is %d%n%n", getMinimum(), getMaximum());

        outputBarChar();

    }

    public void outputBarChar() {
        System.out.println("Grades distribution: ");
        int[] frequency = new int[11];
        for (int grade : grades) {
            ++frequency[grade / 10];
        }
        for (int i = 0; i < frequency.length; i++) {
            if (i == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            }
            for (int star = 0; star < frequency[i]; star++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void outputGrades() {
        System.out.printf("The grades are: %n%n");
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("Student %2d: %3d%n",i + 1, grades[i]);
            
        }
    }

    public int getMaximum() {
        int max = grades[0];
        for (int value : grades) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public int getMinimum() {
        int min = grades[0];
        for (int value : grades) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public double getAverage() {
        int total = 0;
        for (int value : grades) {
            total += value;
        }
        return total / grades.length;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }


}
