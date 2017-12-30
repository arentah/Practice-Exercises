import java.util.*;
import java.io.*;

public class Strings_Anagrams {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();
        boolean ret = isAnagram(a,b);
        System.out.println((ret) ? "Anagrams":"Not Anagrams");
    }
    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();

        char []arr_1 = a.toCharArray();
        Character []arr_a= new Character[a.length()];
        char []arr_2 = b.toCharArray();
        Character []arr_b = new Character[b.length()];

        for(int i = 0; i < a.length(); i++){
            arr_a[i] = arr_1[i];
            arr_b[i] = arr_2[i];
        }

        for(int i = 0; i < a.length(); i++){
            for(int j = i; j < a.length(); j++){
                if(i == j)
                    continue;
                if(arr_a[i].compareTo(arr_a[j]) > 0){
                    char tmp = arr_a[i];
                    arr_a[i] = arr_a[j];
                    arr_a[j] = tmp;
                }
                if(arr_b[i].compareTo(arr_b[j]) > 0){
                    char tmp = arr_b[i];
                    arr_b[i] = arr_b[j];
                    arr_b[j] = tmp;
                }
            }
        }
        return Arrays.equals(arr_a,arr_b);
    }
}
