/*My Solution*/
import java.util.HashMap;

public class Find_Most_Frequent {
    public static void main(String[] args){
    }
    public static int mostFrequentItemCount(int[] collection) {
        if(collection.length == 0)
            return -1;
        else{
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int count = 0;
            int highCount = 0;
            int highValue = 0;
            for (int i = 0; i < collection.length; i++) {
                if(hashMap.get(collection[i]) == null){
                    count = 1;
                    hashMap.put(collection[i], count);
                    if(count > highCount){
                        highCount = count;
                        highValue = collection[i];
                    }
                }
                else{
                    count = hashMap.get(collection[i]) + 1;
                    hashMap.put(collection[i], count);
                    if(count > highCount){
                        highCount = count;
                        highValue = collection[i];
                    }
                }
            }
            return highCount; //return highValue if you want to know which value was the most frequent
        }
    }
}

/*Other Solutions*/
/*
public class Kata {
   public static int mostFrequentItemCount(int[] collection) {
    int most = 0;
    for (int i = 0; i<collection.length; i++){
    int count = 0;
      for(int x : collection){
      if (x==collection[i]){
      count++;
      }
    } if (count>most){
    most=count;
    }
    }
    return most;
  }
}
*/

/*
import java.util.Arrays;
import java.util.HashMap;

public class Kata {
    public static int mostFrequentItemCount(int[] collection) {
        if (collection.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : collection) {
            Integer i = map.get(n);
            if (i == null) {
                map.put(n, 1);
            } else {
                map.put(n, i + 1);
            }
        }

        return map.entrySet().stream().max((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue())).get().getValue();
    }
}
*/

/*
import java.util.*;
public class Kata {
  public static int mostFrequentItemCount(int[] collection) {
    if (collection.length == 0) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer number : collection)
      map.put(number, map.containsKey(number) ? map.get(number)+1 : 1);
    return map.values().stream().max(Integer::compareTo).get();
  }
}
*/