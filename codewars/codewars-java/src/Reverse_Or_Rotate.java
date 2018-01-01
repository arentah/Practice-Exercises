import java.util.ArrayList;

/*My Solution*/
public class Reverse_Or_Rotate {
    public static void main(String[] args) {
        System.out.println(revRot("563000655734469485", 4));
    }

    public static String revRot(String str, int sz) {
        if (sz > str.length() || sz <= 0 || str.length() <= 0)
            return "";

        ArrayList<char[]> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i += sz) {
            if ((i + sz) <= str.length())
                arrayList.add(str.substring(i, i + sz).toCharArray());
        }

        for (int i = 0; i < arrayList.size(); i++) {
            char[] tmp = arrayList.get(i);
            int sum = 0;
            for (int y = 0; y < tmp.length; y++) {
                sum += Integer.parseInt("" + tmp[y]);
            }
            if (sum % 2 == 0)
                tmp = Rev(tmp);
            else if (sum % 2 != 0)
                tmp = Rot(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            char[] tmp = arrayList.get(i);
            for (char c : tmp)
                sb.append(c);
        }
        return sb.toString();
    }

    public static char[] Rev(char[] charArray) {
        for (int i = charArray.length - 1, y = 0; i >= charArray.length / 2; i--, y++) {
            char temp = charArray[y];
            charArray[y] = charArray[i];
            charArray[i] = temp;
        }
        return charArray;
    }

    public static char[] Rot(char[] charArray) {
        char tempFirst = charArray[0];
        for (int i = 1, y = 0; i < charArray.length; i++, y++) {
            charArray[y] = charArray[i];
        }
        charArray[charArray.length - 1] = tempFirst;
        return charArray;
    }
}

/*Other Solutions*/
/*
class RevRot {

    public static String revRot(String nums, int sz) {
        StringBuffer groups = new StringBuffer();
        for (int i = 0, len = nums.length(); i + sz <= len && sz > 0; i += sz) {
            String group = nums.substring(i, i + sz);
            groups.append(isDivisible(group) ? new StringBuffer(group).reverse() : group.substring(1) + group.charAt(0));
        }
        return groups.toString();
    }

    public static boolean isDivisible(String group) {
        int sum = 0;
        for (char num : group.toCharArray()) {
            sum += Character.getNumericValue(num);
        }
        return sum % 2 == 0;
    }

}
*/

/*
class RevRot {

    public static String revRot(String str, int sz){

        if(sz <= 0 || str.isEmpty()) return "";

        int part = str.length() / sz;
        if(part < 1) return "";

        String retVal = "";
        for(int i = 0; i < part; i++){
            String chunk = str.substring(i * sz, i * sz + sz);

            int digitSum = getDigitSum(chunk);
            retVal += isEven(digitSum) ? reverseString(chunk) : rotate(chunk);
        }

        return retVal;
    }

    private static int getDigitSum(String n){
        int sum = 0;
        int length = n.length();

        for(int i = 0; i < length; i++)
          sum += Integer.parseInt(String.valueOf(n.charAt(i)));

        return sum;
    }

    private static boolean isEven(int n){
        return n % 2 ==0;
    }

    private static String rotate(String str){
        String retVal = str;

        return retVal.substring(1) + retVal.substring(0, 1);
    }

    private static String reverseString(String str){
        String retVal = "";
        int length = str.length();

        for(int i = length - 1; i >= 0; i--)
            retVal += str.charAt(i);
        return retVal;
    }
}
*/

/*
class RevRot {

    public static String revRot(String strng, int sz) {
        if ((sz==0) || (strng == "") || (sz > strng.length())) return "";  // INVALID CASES -> Return empty string

        String result = "";                                                // this string will contain the result to be returned

        for (int i = 0; i < (strng.length()/sz); i++){                     // for each chunk of sz elements
            String chunk = strng.substring(i*sz, i*sz + sz);
            int digitSum = 0;
                                                                           // Because our final goal is to determine if the digtSum is odd or even
            for (int j = 0; j < sz; j++){                                  // There is no need of summing the cubes of the numbers
                digitSum += Character.getNumericValue(chunk.charAt(j));    // odd^n remains odd, even^n remains even
            }                                                              // so the proportion of even and odd numbers remains the same

            if ((digitSum % 2) == 0){                                      // REVERSE CHUNK
                for (int k = sz-1; k >= 0; k--){                           //   by adding every character of the chunk to the result from right to left
                    result += chunk.charAt(k);
                }
            }else{                                                         // ROTATE CHUNK TO THE LEFT BY ONE POSITION
                result += chunk.substring(1) + chunk.charAt(0);            //   by adding the chunk to the result with its first character in the end
            }
        }

        return result;
    }
}
*/