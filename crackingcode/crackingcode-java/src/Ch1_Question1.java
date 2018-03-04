import java.util.Arrays;

public class Ch1_Question1 {
    public static void main(String[] args){
        String test = "tesa !q";
        System.out.println(checkUnique(test));
    }

    public static boolean checkUnique(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == arr[i+1])
                return false;
        }
        return true;
    }
}
