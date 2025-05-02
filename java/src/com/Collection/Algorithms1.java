package com.Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms1 {
    public static void main(String[] args) {
        Character[] letters = {'P', 'C', 'M'};
        List<Character> characterList = Arrays.asList(letters);
        System.out.println("list contains: ");
        output(characterList);

        //reserve
        Collections.reverse(characterList);
        System.out.printf("%nAfter calling reverse, list contains:%n");
        output(characterList);

        Character[] lettersCopy = new Character[3];
        List<Character> copyList = Arrays.asList(lettersCopy);

        //copy the contents of list into copy list
        Collections.copy(copyList,characterList);
        output(copyList);

        Collections.fill(characterList,'r');
        System.out.printf("%nAfter calling fill, list contains:%n");
        output(characterList);


    }

    private static void output(List<Character> characterList) {
        System.out.printf("%nThe list is: %n");

        for (Character c: characterList){
            System.out.printf("%s ", c);
        }
        System.out.printf("%nMax: %s", Collections.max(characterList));
        System.out.printf("%nMin: %s", Collections.min(characterList));

    }
}
