/*
* Count the number of duplicate integers in an array
* Input: array of integers
* Output: integer representing the number of duplicates
* */

import java.util.HashMap;

public class Counting_Duplicates {
    public static void main(String[] args){
        int[] array = new int[]{6,1,1,2,2,2,3,6,6,8,9,10,10};
        System.out.println(countDup(array));
    }
    public static int countDup(int[] arr){
        int result = 0;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(hashMap.get(arr[i]) == null){
                hashMap.put(arr[i], true);
            }else{
                if(hashMap.get(arr[i])){
                    hashMap.put(arr[i],false);
                    result++;
                }
            }
        }
        return result;
    }
}
