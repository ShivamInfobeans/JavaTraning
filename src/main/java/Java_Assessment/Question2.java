package Java_Assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    public static boolean find(int size,int arr[],int sum)
    {


        for(int i=0;i<size;i++)
        {
            for(int j=i+1;j<size;j++)
            {
                if(arr[i]+arr[j]==sum)return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of List");
        int size = sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter Elements of List");
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter Sum");
        int sum=sc.nextInt();
        System.out.println(find(size,arr,sum));

    }
}
