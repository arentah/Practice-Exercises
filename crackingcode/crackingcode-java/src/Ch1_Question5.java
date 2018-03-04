public class Ch1_Question5 {
    public static void main(String[] args){
        String str1 = "pale";
        String str2 = "bale";

        System.out.println(oneAway(str1, str2));
    }

    public static boolean oneAway(String str1, String str2){
        if(str1.equals(str2))
            return true;
        if(Math.abs(str1.length() - str2.length()) > 1)
            return false;

        boolean flag = true;
        String longer;
        String shorter;

        if (str1.length() != str2.length()) {
            longer = str1.length() < str2.length() ? str2 : str1;
            shorter = str1.length() < str2.length() ? str1 : str2;
        }else{
            longer = str1;
            shorter = str2;
            flag = false;
        }

        int inc = 0;
        int count = 0;
        for(int i = 0; i < longer.length(); i++){
            try{
                if(flag && longer.charAt(i) == shorter.charAt(inc)){
                    inc++;
                    continue;
                }
                else if(!flag && longer.charAt(i) == shorter.charAt(i)){
                    continue;
                }
                else
                    count++;
            }catch(StringIndexOutOfBoundsException e) {
                count++;
            }
            if(count >= 2)
                return false;
        }
        return true;
    }
}
