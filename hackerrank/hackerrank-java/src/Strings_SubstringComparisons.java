import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Strings_SubstringComparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        if(s.length() == k){
            smallest = s;
            largest = s;
        }
        else {
            for(int i = 0; i < s.length(); i++){
                if(smallest.equals(""))
                    smallest = s.substring(0,k);
                if(largest.equals(""))
                    largest = s.substring(1,k+1);
                try {
                    String tmp = s.substring(i,i+k);
                    if(tmp.compareTo(smallest) <= 0)
                        smallest = tmp;
                    if(tmp.compareTo(largest) > 0)
                        largest = tmp;

                } catch (Exception e) {}
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}
