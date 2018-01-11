/*My Solution*/
public class Remove_Trailing_Exclamation {

    public static void main(String[] args){
    }
    public static String removeBang(String str) {
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length; i++){
            String tmp = split[i].replaceAll("!*$","");
            if(i == split.length - 1)
                sb.append(tmp);
            else
                sb.append(tmp).append(" ");
        }
        return sb.toString();
    }
}

/*Other Solutions*/
/*
public class R {
  public static String removeBang(String str) {
    return str.replaceAll("\\b!+", "");
  }
}
*/

/*
public class R {
  public static String removeBang(String str) {
    return str.replaceAll("(\\w+)\\!+", "$1");
  }
}
*/

/*
public class R {
  public static String removeBang(String str) {
    return str.replaceAll("\\b(?!\\w)!+", "");
  }
}
*/
