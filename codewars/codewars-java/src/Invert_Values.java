/*My Solution*/
public class Invert_Values {
    public static void main(String[] args){}

    public static int[] invert(int[] array) {
        for(int i = 0; i < array.length; i++)
            array[i] *= -1;
        return array;
    }
}

/*Other Solutions*/
/*
public class Kata {
  public static int[] invert(int[] array) {
    return java.util.Arrays.stream(array).map(i -> -i).toArray();
  }
}
*/

/*
public class Kata {
  public static int[] invert(int[] array) {
    int [] res = new int[array.length];
    for(int i = 0; i < array.length; i++)
      res[i] = -array[i];
    return res;
  }
}
*/

/*
public class Kata {
  public static int[] invert(int[] array) {

  for(int i = 0; i < array.length; i++) {
    array[i] *= -1;
  }

  return array;
  }
}
*/

/*
import java.util.Arrays;

public class Kata {
    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(i -> -i).toArray();
    }
}
*/