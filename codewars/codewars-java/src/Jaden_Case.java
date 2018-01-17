/*My Solution*/
public class Jaden_Case {
    public static void main(String[] args){
        String str = "How can mirrors be real if our eyes aren't real";
        System.out.println(toJadenCase(str));
    }
    public static String toJadenCase(String phrase){
        try {
            if(phrase.length() == 0)
                return null;
            String[] str = phrase.split(" ");
            for(int i = 0; i < str.length; i++){
                char[] tmp = str[i].toCharArray();
                if(tmp[0] >= 97 && tmp[0] <= 122)
                    tmp[0] = Character.toUpperCase(tmp[0]);
                str[i] = new String(tmp);
            }
            return String.join(" ",str);
        } catch (Exception e) {
            return null;
        }
    }
}

/*Other Solution*/
/*
import java.lang.Character;
public class JadenCase {

  public String toJadenCase(String phrase) {
    if(phrase == null || phrase.equals("")) return null;

    char[] array = phrase.toCharArray();

    for(int x = 0; x < array.length; x++) {
      if(x == 0 || array[x-1] == ' ') {
        array[x] = Character.toUpperCase(array[x]);
      }
    }

    return new String(array);
  }

}
*/

/*
import java.util.Arrays;
import java.util.stream.Collectors;
public class JadenCase {

  public String toJadenCase(String phrase) {
      if (null == phrase || phrase.length() == 0) {
          return null;
      }

      return Arrays.stream(phrase.split(" "))
                   .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
                   .collect(Collectors.joining(" "));
  }

}
*/

/*
import java.util.Arrays;
import java.util.stream.Collectors;
public class JadenCase {

  public String toJadenCase(String phrase) {
    if(phrase == null || phrase.isEmpty()) return null;
    return Arrays.stream(phrase.split("\\s+")).map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
        .collect(Collectors.joining(" "));
  }

}
*/

