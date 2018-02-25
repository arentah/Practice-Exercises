public class Ch1_Question6 {

    public static void main(String[] args){
        System.out.println(stringCompression("aabccccdddaaaf"));
    }

    public static String stringCompression(String str){
        StringBuilder sb = new StringBuilder();
        char[] tmp = str.toCharArray();
        int count = 1;
        for(int i = 0; i < tmp.length; i++){
            if (i != tmp.length-1) {
                if(tmp[i] == tmp[i+1]){
                    count++;
                }else if(tmp[i] != tmp[i+1]){
                    sb.append(tmp[i]).append(count);
                    count = 1;
                }
            }else
                sb.append(tmp[i]).append(count);
        }

        if(sb.toString().length() >= str.length())
            return str;
        else
            return sb.toString();
    }
}
