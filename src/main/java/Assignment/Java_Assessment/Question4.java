package Assignment.Java_Assessment;

import java.util.Scanner;

public class Question4 {

    public static boolean Isvalid(int row,int arr[][])
    {
        int arr1[][]=new int[row][row];
        for(int i=0;i<row;i++)
            for(int j=0;j<row;j++)
                arr1[i][j]= arr[j][i];


        for (int i=0;i<row;i++)
            for (int j=0;j<row;j++)
                if (arr1[i][j] != arr[i][j])
                    return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of row or col");
        int row=sc.nextInt();
        int arr[][]=new int[row][row];
        System.out.println("enter elements");
        for(int i=0;i<row;i++)
            for(int j=0;j<row;j++)
                arr[i][j]= sc.nextInt();

        System.out.println(Isvalid(row,arr));
    }
}
