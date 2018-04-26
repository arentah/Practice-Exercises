public class Ch1_Question9 {
    public static void main(String[] args){
    }

    public boolean isSubString(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        s2 += s2;
        return (s2.contains(s1));
    }
}
