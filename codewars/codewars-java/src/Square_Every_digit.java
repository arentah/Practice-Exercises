/*My Solution*/
public class Square_Every_digit {
    public static void main(String[] args){
    }

    public static int squareDigits(int n) {
        String input = ""+n;
        char[] charArray = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArray.length; i++){

            int tmp = Integer.parseInt(""+charArray[i]);
            tmp *= tmp;
            sb.append(tmp);
        }

        return Integer.parseInt(sb.toString());
    }
}

/*Other Solutions*/
/*
public class SquareDigit {

  public int squareDigits(int n) {
    String result = "";

    while (n != 0) {
      int digit = n % 10 ;
      result = digit*digit + result ;
      n /= 10 ;
    }

    return Integer.parseInt(result) ;
  }

}
*/

/*
import java.util.stream.Collectors;
public class SquareDigit {

    public int squareDigits(int n) {
        return Integer.parseInt(String.valueOf(n)
                                      .chars()
                                      .map(i -> Integer.parseInt(String.valueOf((char) i)))
                                      .map(i -> i * i)
                                      .mapToObj(String::valueOf)
                                      .collect(Collectors.joining("")));
    }

}
*/

/*
public class SquareDigit {
  private static final int BASE = 10;

  public int squareDigits(int n) {
    if (n < BASE) {
      return n * n;
    }
    int digit = n % BASE;
    int squaredDigit = digit * digit;
    return squaredDigit + (squaredDigit < BASE ? BASE : BASE * BASE) * squareDigits(n / BASE);
  }
}
*/

/*
public class SquareDigit {

  public int squareDigits(int n) {
      if (n < 10) return n * n;
      else {
        int h = squareDigits(n / 10);
        int l = n % 10;
        return Integer.parseInt(h + "" + l * l);
      }
  }

}
*/

/*
public class SquareDigit {

  public int squareDigits(int n) {

    String strDigits = String.valueOf(n);
    String result = "";

    for (char c : strDigits.toCharArray()) {
      int digit = Character.digit(c, 10);
      result += digit * digit;
    }

    return Integer.parseInt(result);
  }

}
*/