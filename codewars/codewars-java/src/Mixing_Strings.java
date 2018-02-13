import java.util.*;

public class Mixing_Strings {
    public static void main(String[] args){





        //newMix("hello", "world");
        System.out.println(mix("Are they here","yes, they are here"));
    }

    public static String mix(String s1, String s2){
        StringBuilder output = new StringBuilder();
        char[] str1 = s1.replaceAll("([^a-z])","").toCharArray();
        char[] str2 = s2.replaceAll("([^a-z])","").toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        char[] charRemoveDup = removeDup(new String(str1)+new String(str2)).toCharArray();

        HashMap<Character, Integer> hashMap1 = getCharCount(str1);
        HashMap<Character, Integer> hashMap2 = getCharCount(str2);

        for(int i = (s1+s2).length() - 1; i >= 0; i--){

            if(hashMap1.containsValue(i)){

                if(hashMap2.containsValue(i)){


                }else{
                    int count = 0;
                    ArrayList<Character> found = new ArrayList<>();
                    for (int j = 0; j < charRemoveDup.length; j++) {
                        if( (hashMap1.get(charRemoveDup[j]) != null) && (hashMap1.get(charRemoveDup[j]) == i)){
                           count++;
                           found.add(charRemoveDup[j]);
                        }
                    }
                    if(count == 1){
                        char[] fill = new char[hashMap1.get(found.get(0))];
                        Arrays.fill(fill, found.get(0));
                        output.append("1:").append(new String(fill)).append("/");
                    }else{
                        char[] tmpSorted = new char[found.size()];
                        for(int m = 0; i < found.size(); m++){
                            tmpSorted[m] = found.get(m);
                        }
                        Arrays.sort(tmpSorted);
                        for(int k = 0; k < tmpSorted.length; k++){
                            char[] fill = new char[hashMap1.get(found.get(k))];
                            Arrays.fill(fill, found.get(k));
                            output.append("1:").append(new String(fill)).append("/");
                        }
                    }
                }


            }else if(hashMap2.containsValue(i)){


                if(hashMap1.containsValue(i)){

                }
            }



        }


        return output.toString();
    }

//    public static String mix(String s1, String s2){
//        StringBuilder output = new StringBuilder();
//        char[] str1 = s1.replaceAll("([^a-z])","").toCharArray();
//        char[] str2 = s2.replaceAll("([^a-z])","").toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        char[] charArray = removeDup(new String(str1)+new String(str2)).toCharArray();
//
//        HashMap<Character, Integer> hashMap1 = getCharCount(str1);
//        HashMap<Character, Integer> hashMap2 = getCharCount(str2);
//        System.out.println(hashMap1.toString());
//        System.out.println(hashMap2.toString());
//
//        for(int i = 0; i < charArray.length; i++){
//            int max1 = 0;
//            int max2 = 0;
//            if (hashMap1.containsKey(charArray[i])) {
//                max1 = hashMap1.get(charArray[i]);
//            }
//            if (hashMap2.containsKey(charArray[i])) {
//                max2 = hashMap2.get(charArray[i]);
//            }
//
//            if(max1 > max2 && max1 > 1){
//                char[] fill = new char[max1];
//                Arrays.fill(fill, charArray[i]);
//                output.append("1:").append(new String(fill)).append("/");
//
//            }else if(max2 > max1 && max2 > 1){
//                char[] fill = new char[max2];
//                Arrays.fill(fill, charArray[i]);
//                output.append("2:").append(new String(fill)).append("/");
//
//            }else if(max1 == max2 && max1 > 1){
//                char[] fill = new char[max1];
//                Arrays.fill(fill, charArray[i]);
//                output.append("=:").append(new String(fill)).append("/");
//
//            }
//        }
//        return output.toString();
//    }


    public static HashMap<Character, Integer> getCharCount(char[] tmp){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char i : tmp){
            if(hashMap.get(i) != null){
                int count = hashMap.get(i);
                hashMap.put(i,++count);
            }else{
                hashMap.put(i, 1);
            }
        }
        return hashMap;
    }
    public static String removeDup(String str){
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < arr.length; i++){
            if(sb.indexOf(""+arr[i]) == -1){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}


/*for(int i = 0; i < charArray.length; i++) {
            Set t = hashMap1.keySet();
            int maximum1 = 0;
            char max_c1 = ' ';
            int maximum2 = 0;
            char max_c2 = ' ';
            Iterator it = t.iterator();
            while (it.hasNext()) {
                char c = (char) it.next();
                if (hashMap1.get(c) > maximum1) {
                    maximum1 = hashMap1.get(c);
                    max_c1 = c;
                }
            }
            while (it.hasNext()) {
                char c = (char) it.next();
                if (hashMap2.get(c) > maximum2) {
                    maximum2 = hashMap2.get(c);
                    max_c2 = c;
                }
            }

            hashMap1.remove(max_c1);
            hashMap2.remove(max_c2);
            if(max_c1 == max_c2 && max_c1 > 1){
                if(maximum1 > maximum2){
                    char[] fill = new char[maximum1];
                    Arrays.fill(fill,max_c1);
                    output.append("1:").append(new String(fill)).append("/");
                }else if(maximum2 > maximum1){
                    char[] fill = new char[maximum2];
                    Arrays.fill(fill,max_c2);
                    output.append("2:").append(new String(fill)).append("/");
                }else{
                    char[] fill = new char[maximum1];
                    Arrays.fill(fill, charArray[i]);
                    output.append("=:").append(new String(fill)).append("/");
                }
            }else{
                if(maximum1 > maximum2 && maximum1 > 1 && maximum2 > 1){
                    char[] fill = new char[maximum1];
                    Arrays.fill(fill,max_c1);
                    output.append("1:").append(new String(fill)).append("/");
                    char[] fill2 = new char[maximum2];
                    Arrays.fill(fill2,max_c2);
                    output.append("2:").append(new String(fill2)).append("/");
                }
                if(maximum2 > maximum1 && maximum2 > 1 && maximum2 > 1){
                    char[] fill2 = new char[maximum2];
                    Arrays.fill(fill2,max_c2);
                    output.append("2:").append(new String(fill2)).append("/");
                    char[] fill = new char[maximum1];
                    Arrays.fill(fill,max_c1);
                    output.append("1:").append(new String(fill)).append("/");
                }

            }*/

//        System.out.println();
//        System.out.println(hashMap1.toString());
////        for(Object c : t){
////            System.out.print(c);
////        }System.out.println();
//        System.out.println();

//        System.out.println(hashMap1.toString());
//        System.out.println(hashMap2.toString());

//        for(Character c : hashMap1.keySet()){
//            System.out.print(c+" ");
//        }System.out.println();
//
//        for(Character c : hashMap2.keySet()){
//            System.out.println(c+" "+hashMap2.get(c));
//
//        }System.out.println();

//                if (i < charArray.length -1) {
//                    char[] fill = new char[max1];
//                    Arrays.fill(fill, charArray[i]);
//                    output.append("1:").append(new String(fill)).append("/");
//                }else{
//                    char[] fill = new char[max1];
//                    Arrays.fill(fill, charArray[i]);
//                    output.append("1:").append(new String(fill));
//                }

//                if (i < charArray.length -1) {
//                    char[] fill = new char[max2];
//                    Arrays.fill(fill, charArray[i]);
//                    output.append("2:").append(new String(fill)).append("/");
//                }else{
//                    char[] fill = new char[max2];
//                    Arrays.fill(fill, charArray[i]);
//                    output.append("2:").append(new String(fill));
//                }

//                if (i < charArray.length - 1) {
//                    char[] fill = new char[max1];
//                    Arrays.fill(fill, charArray[i]);
//                    output.append("=:").append(new String(fill)).append("/");
//                }else{
//                    char[] fill = new char[max1];
//                    Arrays.fill(fill, charArray[i]);
//                    output.append("=:").append(new String(fill));
//                }


//String tmp = "Are they here? Yes, they are here";
//System.out.println(tmp.replaceAll("([^a-zA-Z])","").replaceAll("([A-Z])","$1").toLowerCase());