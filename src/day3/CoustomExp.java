package day3;

import java.util.Scanner;

public class CoustomExp {
    public static void main(String args[]) throws MyException {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        if(x<18)
            throw new MyException();
    }
}
