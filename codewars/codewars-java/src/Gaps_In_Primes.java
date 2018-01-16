/*My Solution*/
import java.util.ArrayList;
public class Gaps_In_Primes {
    public static void main(String[] args){}
    public static long[] gap(int g, long m, long n) {
        if(m == n)
            return null;
        ArrayList<Long> primes = findPrimes_fast(m,n);
        ArrayList<Long> result = new ArrayList<>();
        for(int i = 0; i < primes.size(); i++){
            if(i != primes.size()-1){
                if(primes.get(i) + g == primes.get(i+1)){
                    result.add(primes.get(i));
                    result.add(primes.get(i+1));
                    break;
                }
            }
        }
        long[] res = new long[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        if(res.length == 0)
            return null;
        return res;
    }

    public static ArrayList<Long> findPrimes_fast(long unknown,long limit) {
        assert limit >= 2;
        ArrayList<Long> list = new ArrayList<>();
        final boolean[] nonPrimes = new boolean[(int)limit];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
        int sqrt = (int) Math.sqrt(limit);
        for (int i = 2; i <= sqrt; i++) {
            if (nonPrimes[i]) continue;
            for (int j = i; j<limit; j+=i) {
                if (!nonPrimes[j] && i != j) nonPrimes[j] = true;
            }
        }
        for(long i = unknown; i < nonPrimes.length; i++){
            if(!nonPrimes[(int)i])
                list.add(i);
        }
        return list;
    }

    //Used for testing purposes
    public static ArrayList<Long> findPrimes(long low, long high){
        ArrayList<Long> result_negative = new ArrayList<>();
        for(long i = low; i <= high; i++){
            for(long j = 2; j < i; j++){
                if(i % j == 0){
                    result_negative.add(i);
                    break;
                }
            }
        }
        ArrayList<Long> result = new ArrayList<>();
        long count = low;
        int inc = 0;
        while(count <= high){
            if(result_negative.get(inc) != count){
                result.add(count);
                count++;
            }
            else if(result_negative.get(inc) == count){
                if(inc != result_negative.size()-1)
                    inc++;
                else{
                    if(high > count)
                        result.add(high);
                    break;
                }
                count++;
            }
        }
        return result;
    }
}

/*Other Solutions*/
/*
import java.util.Arrays;
import java.util.ArrayList;

class GapInPrimes {
    public static long[] gap(int g, long m, long n) {
        // If the start number is equal to the end number,
        // then surely there are no primes between them,
        // unless the difference is zero but that's not in the prompt.
        // Also if the summation of the start number and the gap is greater
        // than the end number, then there's surely the return is null.
        if (m == n || (m+g) > n){
          return null;
        } else {
          return strategizer(g,  m,  n);
        }
    }
    // If the lower number is a prime, we can start from it;
    // otherwise, start from the next one. (nano optimization)
    private static long[] strategizer(int diff, long lower, long upper){
      if(isPrime(lower)){
        return finder(diff, lower, upper);
      } else {
        return finder(diff, lower+1, upper);
      }
    }
    // This is where the magic happens
    private static long[] finder(int diff, long lower, long upper){
      long[] ret = new long[2];
      for(long x = lower; x+diff <= upper; x++){
        // If we find a prime, check if number after the gap is also a prime.
        // If so, BINGO!
        if(isPrime(x) && isPrime(x+diff) && noPrimesBetween(x, x+diff)){
          ret[0] = x;
          ret[1] = x+diff;
          return ret;
        }
      }
      return null;
    }
    private static boolean isPrime(long x){
      // micro optimization
      if(x == 2){
        return true;
      } else if (x%2 == 0) {
        return false;
      }

      for(int i = 2; i <= Math.sqrt(x); i++){
        if(x%i == 0){
          return false;
        }
      }
      return true;
    }
    private static boolean noPrimesBetween(long lowbound, long highbound){
      while(++lowbound < highbound){
        if(isPrime(lowbound)){
          return false;
        }
      }
      return true;
    }
}
*/

/*
import java.util.Arrays;
class GapInPrimes {
    public static long[] gap(int g, long m, long n) {
        long last = Long.MIN_VALUE;
        for (long i = m; i < n; i++) {
            if (isPrime(i)) {
                if (i - last == g) {
                    return new long[]{last, i};
                }
                last = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long i) {
        for (long j = 2; j < i / 2; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
*/

/*
import java.math.BigInteger;
import java.util.stream.LongStream;

class GapInPrimes {
  public static long[] gap(long g, long m, long n) {
    return LongStream.iterate(m % 2 == 0 ? m + 1 : m, l -> l + 2).limit((n - m) / 2).filter(l -> BigInteger.valueOf(l).isProbablePrime(5) && BigInteger.valueOf(l + g).isProbablePrime(5)).filter(l -> {
      return LongStream.iterate(l + 2, c -> c + 2).limit((g - 2) / 2).parallel().filter(c -> BigInteger.valueOf(c).isProbablePrime(5)).mapToObj(c -> false).findAny().orElse(true);
    }).mapToObj(l -> new long[]{l, l + g}).findFirst().orElse(null);
  }
}
*/
