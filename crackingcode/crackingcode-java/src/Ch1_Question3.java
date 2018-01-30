public class Ch1_Question3 {
    public static void main(String[]args){
        String test = "Mr John Smith   ";
        System.out.println(removeSpaces(test,13));
    }

    public static String removeSpaces(String str, int num){
        return str.substring(0,num).replaceAll(" ","%20");
    }
}

