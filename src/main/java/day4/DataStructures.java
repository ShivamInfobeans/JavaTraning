package day4;

import java.util.*;

public class DataStructures {
    /*
     Stack, Queue, List
     */
    public static void K_Max(PriorityQueue o1,int k)
    {

        for(int i=1;i<=4;i++)
        {
            System.out.println(o1.remove());

        }
    }
    public  LinkedHashSet abc(List l1)
    {
        LinkedHashSet ll1=new LinkedHashSet<>();

        for(int i=1;i<= l1.size();i++)
        {
            ll1.add(l1.get(i));
        }


        return ll1;
    }
    public static void main(String[] args) {
        // List is a Collection
        // concrete collection object using ArrayList
        List<String> list = new ArrayList<>();
        list.add("name-1");
        list.add("name-2");
        list.add("name-3");

        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2>o1)
                {
                   return 1;
                }
                else {
                    return -1;
                }

            }
        });
        queue.add(10);
        queue.add(200);
        queue.add(60);
        queue.add(30);
        queue.add(300);

       DataStructures.K_Max(queue,2);

//        System.out.println(list.contains("name-2"));
//        System.out.println(list.contains("name-21"));
//        System.out.println(list.remove("name-2"));
//        System.out.println(list.get(0));
//        System.out.println(list.size());

//        for(int i=0;i<list.size();i++)
//            System.out.println(list.get(i));
//
//        for(String str:list)
//            System.out.println(str);

//       Iterator<String> iterator = list.iterator();
//       while(iterator.hasNext()){
//           System.out.println(iterator.next());
//       }
        // Iterator is a design pattern to walk through
        // a data structure without knowing the internal
        // details of the data structure
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("link-1");
        stringLinkedList.add("link-2");
        stringLinkedList.addLast("link-3");
        stringLinkedList.addFirst("link-0");
        // link-0  link-1  link -2  link-3
        // If we use this get method on an array list
        // it will run very fast. Because it stores the elements in
        // an

        // But linkedlist
        //
//        for(String element:stringLinkedList)
//            System.out.println(element);

// get method for linked list has worse performance
        // To access an element at a particular index
        // in a linked list.

        // Not efficient to print out all the elments of
        // the linkedlist, because of get method
        for(int i=0;i<stringLinkedList.size();i++)
            System.out.println(stringLinkedList.get(i));

        // Efficient way -> This approach uses iterator internally
        for(String element: stringLinkedList)
            System.out.println(element);

        // This is the faster way to print all elements
        // of a linked list
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //

    }
}