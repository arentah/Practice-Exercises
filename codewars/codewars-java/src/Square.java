/*My Solution*/
public class Square {
    public static void main(String[] args){
    }

    public static boolean isSquare(int n) {
        if(Math.sqrt(n) % (int)Math.sqrt(n) == 0 )
            return true;
        else
            return false;
    }
}

/*Other Solutions*/
/*
import static java.lang.Math.*;
public class Square {
    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }
}
*/

/*
public class Square {
    public static boolean isSquare(int n) {
        long s = Math.round(Math.sqrt(n));
        return s * s == n;
    }
}
*/