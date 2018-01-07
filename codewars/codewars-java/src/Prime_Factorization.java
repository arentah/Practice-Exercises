/*My Solution*/
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Prime_Factorization {
    public static void main(String[] args){
        System.out.println(primeFactorization(777546020000L));
    }

    public static String primeFactorization(long num){
        String  str = "";
        if(num == 1)return str += "(" + 1 + ")";
        if(isPrime(num)) return str += "(" + num + ")";
        ArrayList<Integer> primes = findPrimes_fast((int)Math.sqrt(num));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num; i++){
            for(int j = 0; j < primes.size(); j++){
                if(isPrime(num)){
                    list.add((int)num);
                    num = 1L;
                    break;
                }
                if(num % primes.get(j) == 0){
                    num /= primes.get(j);
                    list.add(primes.get(j));
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder(str);
        int count = 1;
        int current = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(current == list.get(i)) {
                count++;
                continue;
            }
            if(current != list.get(i)) {
                if(count == 1){
                    sb.append("(").append(current).append(")");
                }
                else{
                    sb.append("(").append(current).append("**").append(count).append(")");
                }
                count = 1;
                current = list.get(i);
            }
        }
        if(count == 1)
            sb.append("(").append(current).append(")");
        else
            sb.append("(").append(current).append("**").append(count).append(")");
        return sb.toString();
    }

    public static ArrayList<Integer> findPrimes_fast(int limit) {
        assert limit >= 2;
        ArrayList<Integer> list = new ArrayList<>();
        final boolean[] nonPrimes = new boolean[limit];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
        int sqrt = (int) Math.sqrt(limit);
        for (int i = 2; i <= sqrt; i++) {
            if (nonPrimes[i]) continue;
            for (int j = i; j<limit; j+=i) {
                if (!nonPrimes[j] && i != j) nonPrimes[j] = true;
            }
        }
        for(int i = 0; i < nonPrimes.length; i++){
            if(!nonPrimes[i])
                list.add(i);
        }
        return list;
    }

    public static boolean isPrime(long n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {

            if(n%i==0)
                return false;
        }
        return true;
    }

    public static ArrayList<Integer> findPrimes_fast_Modified(BigInteger limit) {
        ArrayList<Integer> list = new ArrayList<>();
        final boolean[] nonPrimes = new boolean[Integer.parseInt(limit.toString())];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
        BigInteger sqrt = bigIntSqRootFloor(limit);
        for (int i = 2; i <= Integer.parseInt(sqrt.toString()); i++) {
            if (nonPrimes[i]) continue;
            for (int j = i; j<Integer.parseInt(limit.toString()); j+=i) {
                if (!nonPrimes[j] && i != j) nonPrimes[j] = true;
            }
        }
        for(int i = 0; i < nonPrimes.length; i++){
            if(!nonPrimes[i])
                list.add(i);
        }
        return list;
    }

    public static BigInteger bigIntSqRootFloor(BigInteger x)
            throws IllegalArgumentException {
        if (x.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Negative argument.");
        }
        if (x .equals(BigInteger.ZERO) || x.equals(BigInteger.ONE)) {
            return x;
        }
        BigInteger two = BigInteger.valueOf(2L);
        BigInteger y;
        for (y = x.divide(two);
             y.compareTo(x.divide(y)) > 0;
             y = ((x.divide(y)).add(y)).divide(two));
        return y;
    }
}

/*Other Solutions*/
/*
public class PrimeDecomp {

    public static String factors(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }
}
*/

/*
import java.util.*;
import java.util.stream.*;

public class PrimeDecomp {
  public static String factors(int n) {
    List<String> l = new ArrayList<String>();
    for (int i = 2; i <= n; i++) {
      int times = 0;
      while (n % i == 0) {
        n /= i;
        times++;
      }
      if (times == 1) l.add(Integer.toString(i));
      else if (times > 1) l.add(String.format("%d**%d", i, times));
    }
    return l.stream().collect(Collectors.joining(")(", "(", ")"));
  }
}
*/

/*
public class PrimeDecomp {

    public static String factors(int n) {
        String result = "";
        int cur = n;
        for(int i = 2; i<=cur; i++){
            int ct = 0;
            while(cur%i == 0){
              ct += 1;
              cur = cur/i;
            }
            if(ct == 1)
                result  = result + "(" + i + ")";
            else if(ct > 1)
                result  = result + "(" + i + "**" + ct + ")";
        }
        return result;
    }

}
*/