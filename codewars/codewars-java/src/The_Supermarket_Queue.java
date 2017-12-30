import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*My Solution*/
public class The_Supermarket_Queue {

    public static void main(String[] args){
        int[] x = {2, 2, 3, 3, 4, 4};
        System.out.println(solveSuperMarketQueue(x, 2));
    }

    private static int solveSuperMarketQueue(int[] customers, int n) {
        int time = 0;
        if(n == 1){
            for(int i = 0; i < customers.length; i++){
                time += customers[i];
            }
            return time;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < customers.length; i++){
            queue.add(customers[i]);
        }
        int[] array = new int[n];
        int arrCount = 0;
        while(true){
            if(arrCount >= array.length){
                arrCount = 0;
                for(int i = 0; i < array.length; i++){
                    if(array[i] != 0)
                        array[i]--;
                }
                time++;
                for(int i = 0; i < array.length; i++){
                    if(array[i] == 0){
                        arrCount = 0;
                        break;
                    }
                    else
                        arrCount = array.length;
                }
            }
            if(!queue.isEmpty() && arrCount < array.length){
                if(array[arrCount] == 0){
                    array[arrCount] = queue.poll();
                }
                arrCount++;
            }
            if(queue.isEmpty()){
                int max = 0;
                for(int temp : array){
                    if(temp > max)
                        max = temp;
                }
                time += max;
                break;
            }
        }
        return time;
    }
}

/*Other Solutions*/
/*
import java.util.Arrays;
public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      int[] result = new int[n];
      for(int i = 0; i < customers.length; i++){
        result[0] += customers[i];
        Arrays.sort(result);
      }
      return result[n-1];
    }
}
*/

/*
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

  public static int solveSuperMarketQueue(int[] customers, int n) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < n; i++)
      q.add(0);
    for (int t : customers)
      q.add(q.remove() + t);
    return Collections.max(q);
  }

}
*/

/*
import java.util.Arrays;
public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      int[] registers = new int[n];
      for(int i : customers) {
        registers[smallestIndex(registers)] += i;
      }
      return registers[biggestIndex(registers)];
    }

    public static int smallestIndex(int[] arr) {
      int smallestIndex = 0;
      for(int i = 0; i < arr.length; i++) {
        if(arr[smallestIndex] > arr[i])
          smallestIndex = i;
      }
      return smallestIndex;
    }

    public static int biggestIndex(int[] arr) {
      int biggestIndex = 0;
      for(int i = 0; i < arr.length; i++) {
        if(arr[biggestIndex] < arr[i])
          biggestIndex = i;
      }
      return biggestIndex;
    }

}
*/

/*
import java.util.Arrays;
import java.util.stream.IntStream;
public class Solution {

        public static int solveSuperMarketQueue(int[] customers, int n) {

            if((customers.length == 0) || (n == 0)) return 0;
            int sum = IntStream.of(customers).sum();
            if(n == 1) return sum;

            int times[] = new int[n];

            for (int client: customers){
                Arrays.sort(times);
                times[0] += client;
            }
            return Arrays.stream(times).max().getAsInt();

    }
}
*/

/*
import java.util.*;
public class Solution {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.nCopies(n, 0));
        for (int customer : customers) queue.add(queue.poll() + customer);
        return Collections.max(queue);
    }

}
*/