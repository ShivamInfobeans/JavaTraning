package Java_Assessment;

import java.util.Scanner;

public class Question3 {
    public static int fib_recursive(int n)
    {
        if(n<=1)
        {
            return n;
        }

        return fib_recursive(n-1)+fib_recursive(n-2);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("Fib by recursive function :"+fib_recursive(n));
    }
}
