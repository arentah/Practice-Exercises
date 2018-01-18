/*My Solution*/
public class Count_Char_Sums {
    public static void main(String[] args){
    }
    public static Boolean compare(String s1, String s2){
        if(s1 == null) s1 = "";
        if(s2 == null) s2 = "";
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int sumS1 = 0;
        int sumS2 = 0;
        for(char tmp : str1){
            if((tmp >= 97 && tmp <= 122) || (tmp >= 65 && tmp <= 90))
                sumS1 += Character.toUpperCase(tmp);
            else {
                sumS1 = 0;
                break;
            }
        }
        for(char tmp : str2){
            if((tmp >= 97 && tmp <= 122) || (tmp >= 65 && tmp <= 90))
                sumS2 += Character.toUpperCase(tmp);
            else {
                sumS2 = 0;
                break;
            }
        }
        return sumS1 == sumS2;
    }
}

/*Other Solutions*/
/*
public class Kata {
  public static boolean compare(String s1, String s2) {

    if (s1 == null || !s1.matches("[a-zA-Z]+")) s1 = "";
    if (s2 == null || !s2.matches("[a-zA-Z]+")) s2 = "";

    return s1.toUpperCase().chars().sum() == s2.toUpperCase().chars().sum();
  }
}
*/

/*
public class Kata {
  public static Boolean compare(String s1, String s2) {
    return getSum(s1) == getSum(s2);
  }
  public static int getSum(String s) {
    if (s == null || s.length() != s.replaceAll("[^A-Za-z]","").length())
      return 0;
    return s.toUpperCase().chars().sum();
  }
}
*/

/*
public class Kata
{
  public static Boolean compare(String s1, String s2)
  {
    if(s1 == null || !s1.matches("[A-Za-z]+")) s1="";
    if(s2 == null || !s2.matches("[A-Za-z]+")) s2="";

    s1 = s1.toUpperCase();
    s2 = s2.toUpperCase();
    if(s1.equals(s2)) return true;

    int total1 = 0, total2 = 0;
    for(char c : s1.toCharArray()) {
      total1 += ((int)c);
    }
    for(char c : s2.toCharArray()) {
      total2 += ((int)c);
    }
    return total1 == total2;
  }
}
*/

/*
public class Kata
{
  public static Boolean compare(String s1, String s2)
  {
    return (s1 == null || s1.matches(".*[^a-zA-Z].*") ? 0 : s1.toUpperCase().chars().sum()) ==
           (s2 == null || s2.matches(".*[^a-zA-Z].*") ? 0 : s2.toUpperCase().chars().sum());
  }
}
*/

/*
public class Kata
{
  public static int getAsciiVal(String input)
  {
      int value = 0;
      if(input == null)
        value = 0;
      else if(input.equals(""))
        value = 0;
      else {
        char[] input_chars = input.toUpperCase().toCharArray();
        for(Character c : input_chars)
        {
            if(!Character.isLetter(c))
            {
                value = 0;
                break;
            }
            value += (int)c;
        }
      }
      return value;
  }
  public static Boolean compare(String s1, String s2)
  {
      if(getAsciiVal(s1) == getAsciiVal(s2))
          return true;
      else
          return false ;
  }
}
*/