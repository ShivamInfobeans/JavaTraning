package day3.HomeWork;

public class Account {

    private String name;
    private int balance=0;
    private static int numAccount=0;

    public Account(String name,int balance) {
        this.name = name;
        this.balance = balance;
        numAccount++;
    }

    public void close(Account a1)
    {
        a1.name="Closed";
        numAccount--;
    }
    public static int getNumAccount() {
        return numAccount;
    }
    public static String  getNumName(Account a1) {
        return a1.name;
    }
    public static Account consolidate(Account a1,Account a2)
    {

        if(a1.name==a2.name)
        {
       a1.balance=a1.balance+ a2.balance;
       a2.balance=0;
       a2.name="Closed";
       numAccount--;
        }
        return a1;

    }
    public String toString()
    {


        return "Name="+name+"balance="+balance+"";
    }
}
