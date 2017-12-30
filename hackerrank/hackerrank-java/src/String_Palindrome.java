import java.io.*;
import java.util.*;

public class String_Palindrome {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Character beg;
        Character end;
        boolean flag = true;
        for(int i = 0, j = input.length()-1; i <= (input.length()-1)/2 && j > (input.length()-1)/2; i++, j--){
            beg = input.charAt(i);
            end = input.charAt(j);
            if(!beg.equals(end)){
                flag = false;
                break;
            }
        }
        if(flag == true){
            System.out.println("Yes");
        }
        else
            System.out.println("No");

    }
}
