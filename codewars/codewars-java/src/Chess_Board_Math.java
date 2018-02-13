/*My Solution*/
import java.math.BigDecimal;

public class Chess_Board_Math {
    public static void main(String[] args){
        System.out.println(game(200000000));
    }

    public static String game(long n){
        if(n == 0)
            return "[0]";
        BigDecimal tot = new BigDecimal("0.0");
        for(long i = 2; i <= n; i++){
            tot = tot.add(new BigDecimal(i-1));
        }
        tot = tot.add(new BigDecimal((double)n/(double)2));

        int count = 0;
        for(int i = 0; i < tot.toString().length(); i++){
            if(tot.toString().charAt(i) != '.')
                count++;
            else
                break;
        }
        double num = Double.parseDouble(tot.toString());
        long decimal = Long.parseLong(tot.toString().substring(count+1));
        BigDecimal str = new BigDecimal(""+decimal);

        long numerator = (long)(num * Math.pow(10, str.toString().length()));
        long denominator = (long)Math.pow(10, str.toString().length());
        long gcd = gcd(numerator, denominator);

        numerator = numerator / gcd;
        denominator = denominator / gcd;
        if(denominator == 1)
            return "["+numerator+"]";

        return "["+numerator+", "+denominator+"]";
    }

    static long gcd(long a, long b)
    {
        if(a == 0 || b == 0) return a+b; // base case
        return gcd(b,a%b);
    }

    //Did not use
    static long gcd_loop(long a, long b)
    {
        while(a!=0 && b!=0) // until either one of them is 0
        {
            long c = b;
            b = a%b;
            a = c;
        }
        return a+b; // either one is 0, so return the non-zero value
    }
}

/*Other Solutions*/
/*
import java.util.Arrays;

public class Suite2 {

//    Solution:
//    Imagine folding the chessboard along the top-left - bottom-right diagonal.
//    - After this folding, every non-diagonal element will be paired in a way that their sum is 1.
//    - Furthermore, every diagonal element is 1/2.
//    From these two observations it follows that the sum is always n*n/2.
//
//    Condition is needed because of the special requirements of the output format.

    public static String game(long n) {
        long square = n * n;
        return square/2 == (double)square / 2d
                ? Arrays.toString(new long[]{square/2})
                : Arrays.toString(new long[]{square, 2});
        }
}
*/

/*
public class Suite2 {

   public static String game(long n) {
        long result = n * n;
        if (result % 2 == 0) {
            return "[" + result / 2 + "]";
        } else {
            return "[" + result + ", 2]";
        }
    }
}
*/

/*
public class Suite2 {
  public static String game(long n) {
    return n % 2 == 0 ? "[" + (n / 2 * n) + "]" : "[" + (n * n) + ", 2]";//What a worthless return value
  }
}
*/

/*
public class Suite2 {

  public static String game(long n) {
    return n*n%2>0?"["+n*n+", 2]":"["+n*n/2+"]";
  }
}
*/

/*
public class Suite2 {

  public static String game(long n) {
    return n % 2 == 0 ? "["+n*n/2+"]" : "["+n*n+", "+"2]";
  }
}
*/

/*
public class Suite2 {

  public static String game(long n) {
    long sum = n*n;
    if (n % 2 == 0) {
      return "[" + sum/2 +"]";
    }else{
      return "[" + sum + "," + " 2]";
    }
  }
}
*/