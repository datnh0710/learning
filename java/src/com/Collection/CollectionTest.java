package com.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
//        List<String> list = new ArrayList<String>();
        List<String> list = new ArrayList<>();
        for (String color : colors) {
            list.add(color);
        }

        String[] removeColors = {"RED", "WHITE", "BLUE"};
//        List<String> removeList = new ArrayList<String>();
        List<String> removeList = new ArrayList<>();
        for (String color : removeColors) {
            removeList.add(color);
        }

        System.out.println("ArrayList: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }

        removeColors(list, removeList);

        System.out.printf("%n%nArrayList after calling removeColors:%n");
        for (String color : list)
            System.out.printf("%s ", color);
    }

    private static void removeColors(Collection<String> list, Collection<String> removeList) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if (removeList.contains(iterator.next())){
                iterator.remove();
            }
        }
    }
}
