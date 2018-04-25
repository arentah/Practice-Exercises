import java.util.regex.*;
import java.util.Scanner;

public class Regex {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}
class MyRegex{
    String pattern = ("(([0-1]([0-9]{1,2})?)|((2(([0-4][0-9])|(5[0-5])))|2[0-9]|2)|[3-9]{1,2}).(([0-1]([0-9]{1,2})?)|((2(([0-4][0-9])|(5[0-5])))|2[0-9]|2)|[3-9]{1,2})." +
            "(([0-1]([0-9]{1,2})?)|((2(([0-4][0-9])|(5[0-5])))|2[0-9]|2)|[3-9]{1,2}).(([0-1]([0-9]{1,2})?)|((2(([0-4][0-9])|(5[0-5])))|2[0-9]|2)|[3-9]{1,2})");
}