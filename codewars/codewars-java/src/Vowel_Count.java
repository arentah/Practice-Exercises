/*My Solution*/
public class Vowel_Count {
    public static void main(String[] args){
    }

    public static int getCount(String str) {
        int vowelsCount = 0;
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++){

            if('a' == charArray[i] || 'e' == charArray[i] ||
                    'i' == charArray[i] || 'o' == charArray[i] || 'u' == charArray[i])
                vowelsCount++;
        }
        return vowelsCount;
    }
}

/*Other Solutions*/
/*
public class Vowels {

    public static int getCount(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }

}
*/

/*
public class Vowels {

  public static int getCount(String str) {
    int vowelsCount = 0;

    for(char c : str.toCharArray())
      vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

    return vowelsCount;
  }

}
*/

/*
public class Vowels {

  public static int getCount(String str) {
    return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
  }

}
*/

/*
import java.util.List;
import java.util.Arrays;

public class Vowels {

  private static List<Character> vowels;

  static {
    vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
  }

  public static int getCount(String str) {
    int vowelsCount = 0;
    for(int i = 0; i < str.length(); i++) {
      if (vowels.contains(str.charAt(i))) {
        vowelsCount++;
      }
    }
    return vowelsCount;
  }

}
*/

/*
public class Vowels {

  public static int getCount(String str) {
    int vowelsCount = 0;
    for(int i = 0; i < str.length(); i++) {
        switch(str.charAt(i)) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            vowelsCount++;
        }
    }
    return vowelsCount;
  }

}
*/

