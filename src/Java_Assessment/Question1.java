package Java_Assessment;

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
                push(s1.charAt(i),stack,i);
                top++;
            }
            if(s1.charAt(i)==']' && stack[top]=='[')
            {
                top=pop(top);

            }
            if(s1.charAt(i)=='}' && stack[top]=='{')
            {
                top=pop(top);

            }
                if(s1.charAt(i)==')' && stack[top]=='(')
                {
                    top=pop(top);

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
    public static int pop(int top)
    {
        top--;
return top;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        System.out.println("String is "+Isvalid(s1));
    }


}
