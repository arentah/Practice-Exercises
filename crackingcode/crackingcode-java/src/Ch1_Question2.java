import java.util.Arrays;

public class Ch1_Question2 {
    public static void main(String[] args){
        System.out.println(checkPermutation("helloworld","worldhello"));
    }

    public static boolean checkPermutation(String str1, String str2){
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        Arrays.sort(str1Array);
        Arrays.sort(str2Array);

        String sortedStr1 = new String(str1Array);
        String sortedStr2 = new String(str2Array);

        return sortedStr1.equals(sortedStr2);
    }
}
