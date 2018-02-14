import java.util.HashMap;
import java.util.Set;

public class Sentence_Word_Count {
    public static void main(String[] args){
        System.out.println(countWords("This is a a sample test sentence."));
    }
    public static String countWords(String str){
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] arr = str.split("\\s+");
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i].replaceAll("[^a-zA-z]","").toLowerCase();
            if(hashMap.get(arr[i]) == null){
                hashMap.put(arr[i],1);
            }else{
                int tmp = hashMap.get(arr[i]);
                hashMap.put(arr[i], ++tmp);
            }
        }
        Set test = hashMap.keySet();
        for(Object t : test){
            result.append(t).append(" ").append(hashMap.get((String)t)).append("\n");
        }
        result.delete(result.length()-1,result.length());
        return result.toString();
    }
}
