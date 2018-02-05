/*My Solution*/
public class Range_Extraction {
    public static void main(String[] args){
        System.out.println(rangeExtraction(new int[]{-29, -28, -27, -25, -22, -20, -19, -18, -15, -13, -12, -10,
                -9, -6, -4, -3, 0, 2, 4, 5, 6, 8, 10, 12, 14, 15, 16, 18, 19, 21}));
        System.out.println(rangeExtraction(new int[]{1,2,4,5}));
        System.out.println(rangeExtraction(new int[]{1,2,3,4,-4,-3,-2,8,9,11,13,-4,-3,-2}));
    }
    public static String rangeExtraction(int[] arr) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(i < (arr.length - 2) ) {
                if( (arr[i]+1 != arr[i+1] && arr[i]+2 != arr[i+2]) || arr[i]+2 != arr[i+2] ) {
                    output.append(arr[i]).append(",");
                } else{
                    int first = arr[i];
                    int count = i;
                    while( (count <= arr.length - 2) && (arr[count]+1 == arr[count+1]) ){
                        count++;
                    }
                    int last = arr[count];
                    i = count;
                    if(last == arr[arr.length-1])
                        output.append(first).append("-").append(last);
                    else
                        output.append(first).append("-").append(last).append(",");
                }
            }else{
                if(i == arr.length-1)
                    output.append(arr[i]);
                else
                    output.append(arr[i]).append(",");
            }
        }
        return output.toString();
    }
}

/*Other Solutions*/
/*
class Solution {
    static String rangeExtraction(final int[] array) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int rangeStart = array[i];
            sb.append(rangeStart);
            for (int j = i + 1; j <= array.length; j++) {
                if (j == array.length || array[j] != rangeStart + (j - i)) {
                    if (j - i >= 3) {
                        sb.append('-').append(array[j - 1]);
                        i = j - 1;
                    }
                    sb.append(',');
                    break;
                }
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
*/

/*
import java.util.*;
class Solution {
  private static void addSequence(LinkedList<Integer> sequence, StringBuilder result) {
    result.append(sequence.getFirst());

    if (sequence.size() > 2) {
      result.append("-");
    } else if (sequence.size() == 2) {
      result.append(",");
    }

    if (sequence.size() > 1) {
      result.append(sequence.getLast());
    }
  }

    public static String rangeExtraction(int[] arr) {
        LinkedList<Integer> sequence = new LinkedList<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
          int element = arr[i];

          if (sequence.isEmpty() || element == sequence.getLast()+1) {
            sequence.add(element);
          } else {
            addSequence(sequence, result);
            result.append(",");
            sequence.clear();
            sequence.add(element);
          }
        }

        if (!sequence.isEmpty()) {
          addSequence(sequence, result);
        }

        return result.toString();
    }
}
*/

/*
class Solution {
    public static String rangeExtraction(int[] arr) {
        String solucion="";
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-2&&arr[i]+1==arr[i+1]&&arr[i]+2==arr[i+2]){
                solucion=solucion+","+arr[i]+"-";
                i+=2;
                while(i<arr.length-1&&arr[i]+1==arr[i+1])i++;
                solucion=solucion+arr[i];
            }else solucion=solucion+","+arr[i];
        }
        return solucion.substring(1);
    }
}
*/

/*
import java.util.ArrayList;
import java.util.List;

class Solution{
  public static String rangeExtraction(int[] arr){
    List<String> answer = new ArrayList<>();
    for(int i = 0;i < arr.length;i++){
      StringBuilder cur = new StringBuilder().append(arr[i]);
      if(i < arr.length - 2 && arr[i + 2] - arr[i + 1] == 1 && arr[i + 1] - arr[i] == 1){
        while(i < arr.length - 1 && arr[i + 1] - arr[i] == 1)
          i++;
        cur.append("-").append(arr[i]);
      }
      answer.add(cur.toString());
    }
    return String.join(",", answer);
  }
}
*/