package day20.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import day20.Stream.Student;
/*
Ex:
Make a class Student with attribute marks in it.
(i) Calculate the sum of marks of a list of students
    - reduction
    - sum function in IntStream


Streams API which was introduced in Java 8

Iterator Design Pattern
Advantage - You can loop over the elements of the data structure
without knowing the underlying details of the data structure

(i) In the iterator I am manually calling the hasNext and next methods


Streams
(i) It behaves like a pipeline of objects
(ii) Stream goes over the elements of a Data structure by itself implicitly
without calling any method lie hasNext() and next()
(iii) It makes code much smaller to write
(iv) It has features for parallel programming or Multithreading


Optionals
(i) It avoid null pointer exceptions.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> list = Arrays.asList(null,null);
        // It wont return an integer

//        Iterator<Integer> integerIterator = list.iterator();
//        while(integerIterator.hasNext())
//            System.out.println(integerIterator.next());
        Stream<List<Integer>> stream = Stream.of(list);
        Stream.of(1, 2);
        Stream.of(1);
        new Student(10);
        new Student(20);
        new Student(30);
        new Student(40);
//        Stream.of(1,2,3,4).forEach(System.out::println);
//        list.forEach(System.out::println);
//        List<Integer> newList = list.stream().map(Main::function).collect(Collectors.toList());
//        List<Integer> positiveList = list.stream().filter(e->(e>0)).
//                map(Main::function).filter(e->(e<100)).
//                collect(Collectors.toList());
//        System.out.println(newList);
//        System.out.println(positiveList);
//        Optional<Integer> optional= list.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1==null || o2==null)
//                    return 1;
//                else
//                    return Integer.compare(o1,o2);
//            }
//        });
//        System.out.println(optional.orElse(10));

//        System.out.println(list.stream().filter(e->e>0).count());
//        Optional<Integer> list2 = list.stream().filter(e->e>0).findFirst();
//        System.out.println(list2.orElse(10));
//
//        System.out.println(list.stream().distinct());
//        System.out.println("sum = "+list.stream().mapToInt(e->e.intValue()).sum());
//        Optional<Integer> op = findFunction(list);
//        if(op.isPresent() && op.get()>10)
//            System.out.println();
        /*
            accumulated number // an = 1;
            reduce(1,*) to [2,3,4,5]
            T reduce(T identity, BinaryOperator<T> accumulator);
            (an,2) -> (1,2) -> * = 2 -> an, an = 2
            (an,3) -> 2 *3 = 5 <-- an
            (an,4) -> 20 <--an
            (an,5) --> 5* 20 <-- an

         */
        System.out.println("sum using reduce = " + list.stream().reduce(0, (x, y) -> x + y));
        System.out.println("factorial using reduce = " + list.stream().reduce(1, (x, y) -> x * y));

        /*

         */


       System.out.println(Student.l1.stream().reduce(0,(x,y) ->x+y));
/*
find first return null when there are no element in the list.
These are edge case.
Integer a = function(List<Integer> list); // returns the first non negative number
if(a==null)
{
}
else if (a>10){<-- null pointer exception

}
There is big problem of this NullPointerException
The way java is built. NullPointerException
 */
    }

    public static int function(int n) {
        if (n == 1)
            return 1;
        return n * function(n - 1);
    }

    public static Optional<Integer> findFunction(List<Integer> list) {
        /*
        if there is a positive integer return that
         */
        Integer a = null;
        return Optional.ofNullable(a);

    }
}