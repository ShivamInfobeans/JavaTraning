package Java_Assessment;

import java.util.*;

public class Question5 {
    public static void K_Largest(List l1, int k)
    {


        Comparator comparator = Collections.reverseOrder();
        Collections.sort(l1, comparator);
        for (Object a:l1)
        {
            if(k==0)break;
            System.out.println((Integer)a);
            k--;

        }


    }
    public static void main(String[] args) {

        int k=4;
        ArrayList<Integer>l1 = new ArrayList<Integer>();
        l1.add(10);
        l1.add(50);
        l1.add(100);
        l1.add(150);
        l1.add(250);
        l1.add(100);
        l1.add(150);
        l1.add(250);
       K_Largest(l1, k);
    }
}
