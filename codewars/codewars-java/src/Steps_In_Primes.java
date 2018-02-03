/*My Solution*/
import java.util.ArrayList;
public class Steps_In_Primes {
    public static void main(String[] args){

        long[] tmp = gap(10,100,110);
        if(tmp != null)
        {for(int i = 0; i < tmp.length; i++){
            System.out.println(tmp[i]);
        }}

    }
    public static long[] gap(int g, long m, long n) {
        if(m == n)
            return null;
        ArrayList<Long> primes = findPrimes_fast(m,n);
        ArrayList<Long> result = new ArrayList<>();
        for(int i = 0; i < primes.size(); i++){
            if(primes.contains(primes.get(i)+g)){
                result.add(primes.get(i));
                result.add(primes.get(i)+g);
                break;
            }
        }
        if(result.isEmpty())
            return null;

        long[] res = new long[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
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
}

/*Other Solutions*/
/*
import java.util.HashSet;
import java.util.OptionalLong;
import java.util.stream.LongStream;

class StepInPrimes {

    private static HashSet<Long> primes = new HashSet<>();

    public static long[] step(int stepLength, long start, long end) {
        OptionalLong smallerPrime = LongStream.rangeClosed(start, end).filter(i -> isPrime(i) && isPrime(i+stepLength)).findFirst();
        return smallerPrime.isPresent()
                ? new long[]{smallerPrime.getAsLong(), smallerPrime.getAsLong()+stepLength}
                : null;
    }

    private static boolean isPrime(long primeCandidate){
        if(primes.contains(primeCandidate))
            return true;

        for(long i=2; i<Math.sqrt(primeCandidate)+1; i++){
            if(primeCandidate%i == 0)
                return false;
        }

        primes.add(primeCandidate);
        return true;
    }
}
*/

/*
class StepInPrimes {

    public static long[] step(int g, long m, long n) {
        long start = m;
        long end = n;
        long step = g;

        for (long i=start;i<=(end-step);i++){
          if (isPrime(i) && isPrime(i+step)){
            return new long[]{i, i+step};
          }
        }
        return null;
    }

    public static boolean isPrime(long input){
      if (input == 1 || input == 3) return false;
      if (input % 2 == 0) return false;
      long sqrt_value = (long)Math.sqrt(input);
      for (long i=3;i<=sqrt_value;i+=2){
        if (input%i == 0) return false;
      }
      return true;
    }
}
*/

/*
public class StepInPrimes {
  public static long[] step(int g, long m, long n) {
    return java.util.stream.LongStream.iterate(m % 2 == 0 ? m + 1 : m, l -> l + 2).limit((n - m) / 2).filter(l -> java.math.BigInteger.valueOf(l).isProbablePrime(2) && java.math.BigInteger.valueOf(l + g).isProbablePrime(2)).mapToObj(l -> new long[]{l, l + g}).findFirst().orElse(null);
  }
}
*/