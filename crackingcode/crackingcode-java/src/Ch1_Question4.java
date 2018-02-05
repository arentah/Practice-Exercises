import java.util.Arrays;
public class Ch1_Question4 {
    public static void main(String[] args){
        System.out.println(checkPermutationPalindrome("racecar"));
    }
    public static boolean checkPermutationPalindrome(String str){
        char[] tmp = str.toCharArray();
        Arrays.sort(tmp);
        char first = tmp[0];
        boolean flag = false;
        int count = 1;
        for(int i = 1; i < tmp.length+1; i++){
            if(i < tmp.length && tmp[i] == first)
                count++;
            else{
                if(count % 2 != 0){
                    if(flag)
                        return false;
                    flag = true;
                }
                if(i < tmp.length){
                    first = tmp[i];
                    count = 1;
                }
            }
        }
        return true;
    }
}
