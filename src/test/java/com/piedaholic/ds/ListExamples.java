package com.piedaholic.ds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExamples {
    public static void array_list_examples() {
        List<String> gorillas = new ArrayList<>();
        for (var koko : gorillas)
            System.out.println(koko);

        /*-
         * In the second for-each loop, you might think that the diamond operator <>
         * cannot be used with var without a compilation error, but it absolutely can.
         * This result is monkeys having a type of ArrayList<Object> with albert having
         * a data type of Object.
         * While var might indicate an ambiguous data type, 
         * there is no such thing as an undefined data type in Java.
         */

        var monkeys = new ArrayList<>();
        for (var albert : monkeys)
            System.out.println(albert);
        /*-
        Since the left side does not define a generic type, 
        the compiler will treat this as List<Object>, 
        and ham will have a data type of Object
        */
        List chimpanzees = new ArrayList<Integer>();
        for (var ham : chimpanzees)
            System.out.println(ham);
    }

    public void traverse_list_1(List<?> list) {
        int index = 0;
        for (var o : list) {
            System.out.println(o);
            assert o.equals(list.get(index));
            index++;
        }
        assert list.size() == index + 1;
    }

    public void traverse_list_2(List<?> list) {
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }
    }

    public void traverse_list_3(List<?> list) {
        Iterator<?> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public void traverse_list_4(List<?> list) {
        list.forEach(item -> System.out.println(item));
    }

    public void list_To_Array(List<?> list){
       for (var item : list.toArray()){
           System.out.println(item);
       }
    }
}
