package com.String;

import com.array.Array;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class String_class {
    public static void main(String[] args) {
//        time_compare_string();
//            compareString();
//        immutable_string();
//        StringBuffer inputString = new StringBuffer("datnh0710@gmail.com");
//        findDuplicateCharCount(inputString.toString());


//        maxOccurringChar("datnh0710@gmail.comaaaa",'a');
//        reverseString("I am datnguyen");
//            reverseStringWithPreservingOfSpace("I am Hoang Dat Nguyen");
//        System.out.println(recursiveString("datnh0710@gmail.com"));
//        System.out.println(isAnagram1("KeEp", "pEek"));
//        StringBuilder warriorProfession = new StringBuilder("Dragon ");
//        String warriorWeapon = "Sword ";
//        changeWarriorClass(warriorProfession, warriorWeapon);
//
//        System.out.println("Warrior=" + warriorProfession + " Weapon=" + warriorWeapon);
        System.out.printf("%s%n", length1("hello 1world"));
        System.out.printf("%s%n", length1(" world"));
        System.out.printf("%s%n", length1("world"));


    }

    static void compareString() {
        String s1 = new String("hello");
        String s2 = "goodbye";
        String s3 = "Happy Birthday";
        String s4 = "happy Birthday";
        System.out.printf(
                "s1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n%n", s1, s2, s3, s4);

        // test for equality
        if (s1.equals("hello")) // true
            System.out.println("s1 equals \"hello\"");
        else
            System.out.println("s1 does not equal \"hello\"");

        // test for equality with ==
        if (s1 == "hello") // false; they are not the same object
            System.out.println("s1 is the same object as \"hello\"");
        else
            System.out.println("s1 is not the same object as \"hello\"");

        // test for equality (ignore case)
        if (s3.equalsIgnoreCase(s4)) // true
            System.out.printf("%s equals %s with case ignored%n", s3, s4);
        else
            System.out.println("s3 does not equal s4");

        System.out.printf(
                "%ns1.compareTo(s2) is %d", s1.compareTo(s2));
        System.out.printf(
                "%ns2.compareTo(s1) is %d", s2.compareTo(s1));
        System.out.printf(
                "%ns1.compareTo(s1) is %d", s1.compareTo(s1));
        System.out.printf(
                "%ns3.compareTo(s4) is %d", s3.compareTo(s4));
        System.out.printf(
                "%ns4.compareTo(s3) is %d%n%n", s4.compareTo(s3));

        if (s3.regionMatches(0, s4, 0, 5))
            System.out.println("First 5 characters of s3 and s4 match");
        else
            System.out.println(
                    "First 5 characters of s3 and s4 do not match");
// test regionMatches (ignore case)
        if (s3.regionMatches(true, 0, s4, 0, 5))
            System.out.println("First 5 characters of s3 and s4 match with case ignored");
        else
            System.out.println(
                    "First 5 characters of s3 and s4 do not match");
    }

    static void changeWarriorClass(StringBuilder warriorProfession, String weapon) {
        warriorProfession.append("Knight");
        weapon = "Dragon " + weapon;
        System.out.printf("1: warriorProfession: %s%n", warriorProfession);
        System.out.printf("1: weapon: %s%n", weapon);
        weapon = null;
        warriorProfession = null;
        System.out.printf("2: warriorProfession: %s%n", warriorProfession);
        System.out.printf("2: weapon: %s%n", weapon);
    }

    public static void immutable_string() {
        String s = "datnh";
        String s1 = "datnh";
        System.out.println("Shallow compare: " + s == s1);
        System.out.println("Deep compare: " + s.equals(s1));
        System.out.println("Hashcode compare: %d " + s.hashCode() + " %d " + s1.hashCode());

        // add more string into s1
        s1 = s1 + "dxzz2";
        System.out.println("Shallow compare after add more string: " + s == s1);
        System.out.println("Deep compare after add more string: " + s.equals(s1));
        System.out.println("Hashcode compare after add more string: %d " + s.hashCode() + " %d " + s1.hashCode());

        // using "new" operator
        String s3 = new String("datnh");
        System.out.println("Using new operator: " + s3);
        s3.concat("dxzz2");
        System.out.println("Using new operator after add more character: " + s3);
    }

    public static void time_compare_string() {
        // created String by using String literal
        String s = "datnh";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            s = s + "test";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by String class : " + (endTime - startTime) + " ms");

        // created String by using "New" operator

        //Stringbuffer with thread safety
        StringBuffer stringBuffer = new StringBuffer("datnh");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            stringBuffer.append("test");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder class : " + (endTime - startTime) + " ms");

        //Stringbuilder without thread safety
        StringBuilder stringBuilder = new StringBuilder("datnh");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append("test");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder class : " + (endTime - startTime) + " ms");


    }

    public static void findDuplicateCharCount(String inputString) {
        // creating a HastMap containing char as a key and it's occurrences as value.
        HashMap<Character, Integer> duplication = new HashMap<Character, Integer>();

        //converting given string to char arr
        if (inputString.length() == 0)
            return;
        char[] givenString = inputString.toCharArray();
        //check each char of givenString
        for (char c : givenString) {
            //check if char existed in duplication, incrementing it's count by 1
            if (duplication.containsKey(c)) {
                duplication.put(c, duplication.get(c) + 1);
            } else { //if a char is not existed in duplication --> put the char and value =1  into duplication
                duplication.put(c, 1);
            }
        }
        System.out.println("Duplicate Characters In : " + inputString);
        for (Map.Entry r : duplication.entrySet()) {
            System.out.println(r.getKey() + " : " + r.getValue());
        }

    }

    // find max occurred of a char in inputString
    public static void maxOccurringChar(String inputString, Character inputChar) {
        if (inputString.length() == 0)
            return;
        int max = inputString.length() - inputString.replace(inputChar.toString(), "").length();
        System.out.println("Max occurring Char: " + max);
    }

    // using reverse in Stringbuffer
    public static void reverseString(String inputString) {
        if (inputString.length() == 0 || inputString == null)
            return;
//        inputString.replace(" ","");
        StringBuffer outputString = new StringBuffer(inputString);
        System.out.println(outputString.reverse());
        return;
    }

    //using the recursive
    //example : datnh0710
    //1st step will get the 1st char and return the rest of inputString (atnh0710 + d)
    // following step --> return:  (tnh0710 + a) + d
    // --> 0170hntad
    public static String recursiveString(String inputString) {
        if (inputString.length() <= 1 || inputString == null)
            return inputString;
        return recursiveString(inputString.substring(1)) + inputString.charAt(0);

    }

    public static void reverseStringWithPreservingOfSpace(String inputString) {
        if (inputString.length() == 0 || inputString == null)
            return;
        // Converting inputString to char array
        char[] inputStringArray = inputString.toCharArray();

        // create the new array
        char[] resultArray = new char[inputStringArray.length];

        // add every space into the new array
        for (int i = 0; i < inputStringArray.length; i++) {
            if (inputStringArray[i] == ' ') {
                resultArray[i] = ' ';
            }
        }

        int j = resultArray.length - 1;
        for (int i = 0; i < inputStringArray.length; i++) {
            if (inputStringArray[i] != ' ') {
                if (resultArray[j] == ' ') {
                    j--;
                }
                resultArray[j] = inputStringArray[i];
                j--;
            }
        }
        System.out.println(inputString + " ---> " + String.valueOf(resultArray));
    }

    public static boolean isAnagram(String inputString1, String inputString2) {
        String copyValueS1 = inputString1.replaceAll("\\s", "");
        String copyValueS2 = inputString2.replaceAll("\\s", "");

        if (copyValueS1.length() != copyValueS2.length())
            return false;
        else {
            char[] s1Array = copyValueS1.toLowerCase().toCharArray();
            char[] s2Array = copyValueS2.toLowerCase().toCharArray();
            Arrays.sort(s1Array);
            Arrays.sort(s2Array);
            return Arrays.equals(s1Array, s2Array);

        }
    }

    public static boolean isAnagram1(String inputString1, String inputString2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String s1 = inputString1.toLowerCase().replaceAll("\\s", "");
        String s2 = inputString2.toLowerCase().replaceAll("\\s", "");
        for (int i = 0; i < s1.length(); i++) {
            hashMap.put(s1.charAt(i), 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (hashMap.containsKey(s2.charAt(i))) {
                hashMap.remove(s2.charAt(i));
            }
        }

        return hashMap.isEmpty();
    }

    private static int length(String s) {
        String[] tmp = s.split(" ");
        int len = tmp.length;
        if( len<1){
            return 0;
        }

        return tmp[len-1].length();

    }
    private static int length1(String s) {
        if (s.length() < 0)
            return 0;
        int count =0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) == ' ' && count> 0 )
                return count;
            if(s.charAt(i) != ' ')
                count++;
        }
        return count;



    }


}
