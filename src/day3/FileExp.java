package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileExp
{
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("text.txt");
        PrintWriter print=new PrintWriter("text2.txt");
    }
}
