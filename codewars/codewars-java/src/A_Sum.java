/*My Solution, works on very large numbers but fails on extremely large numbers, need to address this issue*/
public class A_Sum {

    public static long total = 0;

    public static void main(String[] args){
        System.out.println(findNb(657330022518226L));
    }

    public static long findNb(long m) {
        return findNb_Helper(m, 1, 0);
    }

    public static long findNb_Helper(long m, long result, long temp){
        if(temp > m)
            return -1;
        temp += (result * result * result);
        if(temp == m)
            return result;
        result++;
        return findNb_Helper(m, result, temp );
    }
}

/*Other Solutions*/
/*public class ASum {

  public static long findNb(long m) {
    long mm = 0, n = 0;
    while (mm < m) mm += ++n * n * n;
    return mm == m ? n : -1;
  }
}*/

/*
public class ASum {

  public static long findNb(long m) {
    long n = 0;
    long cubeSize = 0;
    for (; cubeSize < m; n++)
      cubeSize += n * n * n;
    return (cubeSize == m) ? n - 1 : -1;
  }
}
*/

/*
public class ASum {

  public static long findNb(long m) {
    long total = 0;
    int counter = 0;

    while (total < m) {
      counter++;
      total = total + (long) Math.pow(counter, 3);
    }

    if (m == total)
      return counter;
    return -1;
  }
}
*/

/*
public class ASum {

  public static long findNb(long m) {
  long ex=(long)Math.sqrt((long) Math.sqrt(m)*2);
  if((ex*(ex+1)/2)*(ex*(ex+1)/2)==m) return ex; else return -1;
 }
}
*/

/*
public class ASum {

    public static long findNb(long m) {
        long sum = 0;
        long n = 0;
        while (sum < m) {
            n++;
            sum += n*n*n;
        }
        if (sum == m) {
            return n;
        } else {
            return -1;
        }
    }
}
*/

/*
public class ASum {

  public static long findNb(long m) {
    // your code
    long i = 0;
    long totalVolume = 0;
    while(totalVolume < m) {
      i++;
      totalVolume += (i * i * i);
    }
    if(totalVolume == m) {
        return i;
    }
    else {
        return -1;
    }
  }
}
*/

/*
public static long findNb(long m) {
// m = 1^3 + 2^3 + ... + n^3
// aka (n(n +1)/2)^2
// use quadratic function?
// sqrt(m) * 2 = n(n+1)
// sqrt(m) * 2 = n^sq + n
// 0 = nsq + n - 2*sqrt(m)
// -b +- sqrt(b^sq - 4ac) / 2a
// a = 1
// b = 1
// c = 2 * sqrt(m)
long a = 1;
long b = 1;
long c = -2 * (long)Math.sqrt(m);

if (c * c != 4 * m) {
     return -1;
}

long sqrt = (long) Math.sqrt(b*b - 4*a*c);
long low = (-1*b - sqrt) / (2*a);
long high = (-1*b + sqrt) / (2*a);

return low >= 0 ? low : high;
}
*/