
import java.util.*;
import java.io.*;
public class Strings_Token {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
//        str = str.replace("."," ");
//        str = str.replace("!"," ");
//        str = str.replace("_"," ");
//        str = str.replace("?"," ");
//        str = str.replace("'"," ");
//        str = str.replace(",","");


        //str = str.replaceAll("[,]","");
        str = str.replaceAll("[._!?,@']"," ");
        String []token = str.split("[\\s]");

        ArrayList<String> finalToken = new ArrayList<>();
        for(String s: token){
            if(!s.equals("")){
                finalToken.add(s);
            }
        }

        System.out.println(finalToken.size());
        for(String s: finalToken){
            System.out.println(s);
        }

        scan.close();
    }
}
