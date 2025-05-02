package com.breakandcontinue;

public class Break_Continue {
    public static void main(String[] args) {
        // break method
//        break_method();

        // continue method
        continue_method();

    }

    public static void break_method() {
        for (int i = 0; i < 10; i++) {
            // if i == 4 ->> skip all execute line after break; and stop get out the loop
            if (i == 4) {
                break;
            }
            System.out.printf("Break method number increasing: %d \n", i);
        }
    }

    public static void continue_method() {
        for (int i = 0; i < 10; i++) {
            // if i == 5 ->> skip all execute line after "continue" and continue after that;
            if (i == 5) {
//                i++;
                continue;
            }
            System.out.printf("Continue method number increasing: %d \n", i);
        }
    }
}
