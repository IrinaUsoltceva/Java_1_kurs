package exameni2;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.util.*;

/**
 * Created by Alina_A on 22.06.2017.
 */
public class NumberSixteen {
    public static void main(String[] args) {


        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        List<String> list3 = new LinkedList<>();

        list2.add("abcd");
        list2.add("1tfs");
        list1.add("dsgsg");
        list1.add("ab24e2fcd");

        System.out.println(list1);
        System.out.println(list2);

        //for-each
        for (String x: list1)
            System.out.println(x);

        System.out.println(list2.size());

        System.out.println(list2.contains(list1));

        list1.clear();
        System.out.println(list1);

        System.out.println();

        HashSet<String> states1 = new HashSet<>();
        states1.add("Германия");
        states1.add("Франция");
        states1.add("Италия");

        for(String state : states1)
            System.out.println(state);
        System.out.println();

        //-------

        TreeSet<String> states2 = new TreeSet<>();
        states2.addAll(states1);

        for(String state : states2)
            System.out.println(state);
        System.out.println();

        //-------

        LinkedHashSet<String> states3 = new LinkedHashSet<>();
        states3.addAll(states1);

        for(String state : states3)
            System.out.println(state);


    }


}
