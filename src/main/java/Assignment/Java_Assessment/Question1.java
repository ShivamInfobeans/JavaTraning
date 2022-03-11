package Assignment.Java_Assessment;

import java.util.Scanner;

public class Question1 {


    public static boolean Isvalid(String s1)
    {
        boolean isvalid=true;
        int top=-1;
        int size=s1.length();
        int[] stack = new int[size];

        for(int i=0;i<size;i++)
        {
            if(s1.charAt(i)=='(' || s1.charAt(i)=='{' || s1.charAt(i)=='[')
            {
                top++;
                push(s1.charAt(i),stack,top);

            }
            if(s1.charAt(i)==']' && stack[top]=='[')
            {
               top--;

            }
            if(s1.charAt(i)=='}' && stack[top]=='{')
            {
               top--;

            }
                if(s1.charAt(i)==')' && stack[top]=='(')
                {
                    top--;
                }
        }
        if(top!=-1)
        {
            isvalid=false;
        }
        return isvalid;
    }
    public static void push(char a,int[] stack,int i)
    {
    stack[i]=a;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        System.out.println("String is "+Isvalid(s1));
    }


}
