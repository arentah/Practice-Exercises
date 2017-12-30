/*My Solution*/
public class Exes_And_Os {

    public static void main(String []args){
    }

    public static boolean getXO (String str) {

        int countX = 0;
        int countO = 0;
        char[] arr = str.toCharArray();

        for(char temp : arr){
            temp = Character.toLowerCase(temp);
            if(temp == 'x')
                countX++;
            else if(temp == 'o')
                countO++;
        }

        return countX == countO;
    }
}

/*Another solution*/
/*public static boolean getXO(String str) {
    str = str.toLowerCase();
    return str.replace("o", "").length() == str.replace("x", "").length();

}*/
