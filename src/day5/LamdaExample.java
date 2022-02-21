package day5;

public class LamdaExample<b> {
    public static void main(String[] args) {
        System.out.println(function(1,2,new MinusOperation()));
    }

    // function(a,b,operation) and depending upon this third argument. performs
    // the operation.
    // a + b , a - b
    // function(a,b,operation)  operation = "+", "-", "*", "/"
    String  a="abc";
    String  b="xyz";


    // I can add any number of new operators and this function definition
    // remain same.
    public static int function(int num1, int num2, Operation operation){
        return operation.operate(num1,num2);
    }
}
interface Operation{
    public int operate(int num1, int num2);
}
class AddOperation implements Operation{

    @Override
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}
class power implements Operation{

    @Override
    public int operate(int num1, int num2) {
        for(int i=0;i<num2;i++)
        {
            num1=num1*num1;
        }
        return num1;
    }
}
class MinusOperation implements  Operation{

    @Override
    public int operate(int num1, int num2) {
        return num1-num2;
    }
}