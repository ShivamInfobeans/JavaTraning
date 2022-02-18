package day3;

import java.util.ArrayList;
import java.util.List;

public class List1 {

    List<Integer> list=new ArrayList<>();
    Integer sum=0;
    public Integer Add(Integer x)
    {
        sum=0;
        list.add(x);
        for (int i=0;i<list.size();i++)
        {
            sum=sum+ list.get(i);
        }
        return sum;
    }
    public static void main(String args[])
    {

    }
}
