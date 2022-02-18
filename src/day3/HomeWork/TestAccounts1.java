package day3.HomeWork;

public class TestAccounts1  {
    public static void main(String[] args) {
        Account a1=new Account("shivam",1000);
        Account a2=new Account("devendra",1000);
        Account a3=new Account("shubham",1000);
        Account a4=new Account("shivam",1000);
       System.out.println( Account.getNumAccount());
       Account.consolidate(a1,a4);
        System.out.println( Account.getNumAccount());
        System.out.println(a1);

    }



}
