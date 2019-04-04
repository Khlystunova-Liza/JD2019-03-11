package by.it.bolotko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner2 {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        //проверим добавление
        myList.add("First"); arList.add("First");
        myList.add("Two"); arList.add("Two");
        myList.add("Four"); arList.add("Four");
        System.out.println("myList: " + myList + "\narList: " + arList);
        myList.add(2, "Tree"); arList.add(2, "Tree");
        myList.add(0, "Start"); arList.add(0, "Start");
        System.out.println("myList: " + myList + "\narList: " + arList);
        //проверим удаление
        myList.remove("Start"); arList.remove("Start");
        myList.remove(3); arList.remove(3);
        System.out.println("myList: " + myList + "\narList" + arList);
        //проверим чтение
        System.out.println("myList(0): " + myList.get(0) + "\narList: " + arList.get(0));
    }
}
