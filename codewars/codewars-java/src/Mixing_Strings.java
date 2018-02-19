/*My Solution*/
import java.util.*;

public class Mixing_Strings {
    public static void main(String[] args) {
        System.out.println(mix("looping is fun but dangerous", "less dangerous than coding"));
    }

    public static String mix(String s1, String s2) {
        StringBuilder output = new StringBuilder();
        char[] str1 = s1.replaceAll("([^a-z])", "").toCharArray();
        char[] str2 = s2.replaceAll("([^a-z])", "").toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        char[] charRemoveDup = removeDup(new String(str1) + new String(str2)).toCharArray();

        HashMap<Character, Integer> hashMap1 = getCharCount(str1);
        HashMap<Character, Integer> hashMap2 = getCharCount(str2);
        char[] sortedCharRemoveDup = charRemoveDup.clone();
        Arrays.sort(sortedCharRemoveDup);

        for (int i = (str1.length + str2.length - 1); i > 1; i--) {
            if (hashMap1.containsValue(i)) {
                if (hashMap2.containsValue(i)) {
                    ArrayList<Character> foundHashMap1 = new ArrayList<>();
                    ArrayList<Character> foundHashMap2 = new ArrayList<>();

                    for (int j = 0; j < charRemoveDup.length; j++) {
                        if ((hashMap1.get(charRemoveDup[j]) != null) && (hashMap1.get(charRemoveDup[j]) == i)) {
                            foundHashMap1.add(charRemoveDup[j]);
                        }
                    }
                    for (int j = 0; j < charRemoveDup.length; j++) {
                        if ((hashMap2.get(charRemoveDup[j]) != null) && (hashMap2.get(charRemoveDup[j]) == i)) {
                            foundHashMap2.add(charRemoveDup[j]);
                        }
                    }

                    if (foundHashMap1.size() == 1 && foundHashMap2.size() == 1) {
                        char[] hashMap1CharArray = new char[hashMap1.get(foundHashMap1.get(0))];
                        char[] hashMap2CharArray = new char[hashMap2.get(foundHashMap2.get(0))];
                        Arrays.fill(hashMap1CharArray, foundHashMap1.get(0));
                        Arrays.fill(hashMap2CharArray, foundHashMap2.get(0));
                        if (foundHashMap1.get(0) < foundHashMap2.get(0)) {
                            output.append("1:").append(new String(hashMap1CharArray)).append("/");
                            output.append("2:").append(new String(hashMap2CharArray)).append("/");
                        } else if (foundHashMap2.get(0) < foundHashMap1.get(0)) {
                            output.append("2:").append(new String(hashMap2CharArray)).append("/");
                            output.append("1:").append(new String(hashMap1CharArray)).append("/");
                        } else {
                            output.append("=:").append(new String(hashMap1CharArray)).append("/");
                        }
                    }
                    else {
                        for (int j = 0; j < sortedCharRemoveDup.length; j++) {
                            if (hashMap1.containsKey(sortedCharRemoveDup[j]) && !hashMap2.containsKey(sortedCharRemoveDup[j])
                                    && hashMap1.get(sortedCharRemoveDup[j]) == i) {
                                char[] hashMap1CharArray = new char[hashMap1.get(sortedCharRemoveDup[j])];
                                Arrays.fill(hashMap1CharArray, sortedCharRemoveDup[j]);
                                output.append("1:").append(new String(hashMap1CharArray)).append("/");
                                continue;
                            }
                            if(hashMap1.containsKey(sortedCharRemoveDup[j]) && hashMap2.containsKey(sortedCharRemoveDup[j])
                                    && hashMap1.get(sortedCharRemoveDup[j]) == i && hashMap2.get(sortedCharRemoveDup[j]) < i){
                                char[] hashMap1CharArray = new char[hashMap1.get(sortedCharRemoveDup[j])];
                                Arrays.fill(hashMap1CharArray, sortedCharRemoveDup[j]);
                                output.append("1:").append(new String(hashMap1CharArray)).append("/");
                                continue;
                            }
                            if ( (hashMap2.containsKey(sortedCharRemoveDup[j]) && !hashMap1.containsKey(sortedCharRemoveDup[j])
                                    && hashMap2.get(sortedCharRemoveDup[j]) == i) || (hashMap2.containsKey(sortedCharRemoveDup[j])
                                    && hashMap1.containsKey(sortedCharRemoveDup[j]) && hashMap2.get(sortedCharRemoveDup[j]) == i
                                    && hashMap1.get(sortedCharRemoveDup[j]) < i) ) {
                                char[] hashMap2CharArray = new char[hashMap2.get(sortedCharRemoveDup[j])];
                                Arrays.fill(hashMap2CharArray, sortedCharRemoveDup[j]);
                                output.append("2:").append(new String(hashMap2CharArray)).append("/");
                                continue;
                            }
                            if (hashMap1.containsKey(sortedCharRemoveDup[j]) && hashMap2.containsKey(sortedCharRemoveDup[j])
                                    && hashMap1.get(sortedCharRemoveDup[j]) == i && hashMap2.get(sortedCharRemoveDup[j]) == i) {
                                char[] hashMap1CharArray = new char[hashMap1.get(sortedCharRemoveDup[j])];
                                Arrays.fill(hashMap1CharArray, sortedCharRemoveDup[j]);
                                output.append("=:").append(new String(hashMap1CharArray)).append("/");
                            }
                        }
                    }
                } else {
                    ArrayList<Character> found = new ArrayList<>();
                    for (int j = 0; j < charRemoveDup.length; j++) {
                        if ((hashMap1.get(charRemoveDup[j]) != null) && (hashMap1.get(charRemoveDup[j]) == i)) {
                            found.add(charRemoveDup[j]);
                        }
                    }
                    if (found.size() == 1) { //could be replaced with found.size() instead of count
                        if (hashMap2.containsKey(found.get(0))) {
                            if (hashMap2.get(found.get(0)) > i) {
                                continue;
                            }
                        }
                        char[] fill = new char[hashMap1.get(found.get(0))];
                        Arrays.fill(fill, found.get(0));
                        output.append("1:").append(new String(fill)).append("/");
                    } else {
                        for (int j = 0; j < found.size(); j++) {
                            if (hashMap2.containsKey(found.get(j))) {
                                if (hashMap2.get(found.get(j)) > i) {
                                } else {
                                    char[] fill = new char[hashMap1.get(found.get(j))];
                                    Arrays.fill(fill, found.get(j));
                                    output.append("1:").append(new String(fill)).append("/");
                                }
                            } else {
                                char[] fill = new char[hashMap1.get(found.get(j))];
                                Arrays.fill(fill, found.get(j));
                                output.append("1:").append(new String(fill)).append("/");
                            }
                        }
                    }
                }
            } else if (hashMap2.containsValue(i)) { //second case
                if (!hashMap1.containsKey(i)) {
                    ArrayList<Character> found = new ArrayList<>();
                    for (int j = 0; j < charRemoveDup.length; j++) {
                        if ((hashMap2.get(charRemoveDup[j]) != null) && (hashMap2.get(charRemoveDup[j]) == i)) {
                            found.add(charRemoveDup[j]);
                        }
                    }
                    if (found.size() == 1) { //could be replaced with found.size() instead of count
                        if (hashMap1.containsKey(found.get(0))) {
                            if (hashMap1.get(found.get(0)) > i) {
                                continue;
                            }
                        }
                        char[] fill = new char[hashMap2.get(found.get(0))];
                        Arrays.fill(fill, found.get(0));
                        output.append("2:").append(new String(fill)).append("/");
                    } else {
                        for (int j = 0; j < found.size(); j++) {
                            if (hashMap1.containsKey(found.get(j))) {
                                if (hashMap1.get(found.get(j)) > i) {
                                } else {
                                    char[] fill = new char[hashMap2.get(found.get(j))];
                                    Arrays.fill(fill, found.get(j));
                                    output.append("2:").append(new String(fill)).append("/");
                                }
                            } else {
                                char[] fill = new char[hashMap2.get(found.get(j))];
                                Arrays.fill(fill, found.get(j));
                                output.append("2:").append(new String(fill)).append("/");
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < sortedCharRemoveDup.length; j++) {
                        if ((hashMap1.containsKey(sortedCharRemoveDup[j]) && !hashMap2.containsKey(sortedCharRemoveDup[j])
                                && hashMap1.get(sortedCharRemoveDup[j]) == i) || (hashMap1.containsKey(sortedCharRemoveDup[j])
                                && hashMap2.containsKey(sortedCharRemoveDup[j]) && hashMap1.get(sortedCharRemoveDup[j]) == i
                                && hashMap2.get(sortedCharRemoveDup[j]) < i)) {
                            char[] hashMap1CharArray = new char[hashMap1.get(sortedCharRemoveDup[j])];
                            Arrays.fill(hashMap1CharArray, sortedCharRemoveDup[j]);
                            output.append("1:").append(new String(hashMap1CharArray)).append("/");
                            continue;
                        }
                        if (hashMap2.containsKey(sortedCharRemoveDup[j]) && !hashMap1.containsKey(sortedCharRemoveDup[j])
                                && hashMap2.get(sortedCharRemoveDup[j]) == i) {
                            char[] hashMap2CharArray = new char[hashMap2.get(sortedCharRemoveDup[j])];
                            Arrays.fill(hashMap2CharArray, sortedCharRemoveDup[j]);
                            output.append("2:").append(new String(hashMap2CharArray)).append("/");
                            continue;
                        }
                        if(hashMap2.containsKey(sortedCharRemoveDup[j]) && hashMap1.containsKey(sortedCharRemoveDup[j])
                                && hashMap2.get(sortedCharRemoveDup[j]) == i && hashMap1.get(sortedCharRemoveDup[j]) < i){
                            char[] hashMap2CharArray = new char[hashMap2.get(sortedCharRemoveDup[j])];
                            Arrays.fill(hashMap2CharArray, sortedCharRemoveDup[j]);
                            output.append("2:").append(new String(hashMap2CharArray)).append("/");
                            continue;
                        }
                        if (hashMap2.containsKey(sortedCharRemoveDup[j]) && hashMap1.containsKey(sortedCharRemoveDup[j])
                                && hashMap2.get(sortedCharRemoveDup[j]) == i && hashMap1.get(sortedCharRemoveDup[j]) == i) {
                            char[] hashMap2CharArray = new char[hashMap2.get(sortedCharRemoveDup[j])];
                            Arrays.fill(hashMap2CharArray, sortedCharRemoveDup[j]);
                            output.append("=:").append(new String(hashMap2CharArray)).append("/");
                        }
                    }
                }
            }
        }
        return correctFormat(output.toString());
    }

    public static String correctFormat(String str){
        String[] arr = str.split("/");
        for(int j = 0; j < arr.length; j++){
            for(int k = j; k < arr.length; k++){
                if(arr[j].length() == arr[k].length() && !arr[j].equals(arr[k])){
                    if(arr[k].charAt(0) < arr[j].charAt(0)){
                        String tmp = arr[k];
                        arr[k] = arr[j];
                        arr[j] = tmp;
                    }
                    else if(arr[k].charAt(0) == arr[j].charAt(0)){
                        if(arr[k].charAt(2) < arr[j].charAt(2)){
                            String tmp = arr[k];
                            arr[k] = arr[j];
                            arr[j] = tmp;
                        }
                    }
                }

            }
        }
        return String.join("/",arr);
    }

    public static HashMap<Character, Integer> getCharCount(char[] tmp) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char i : tmp) {
            if (hashMap.get(i) != null) {
                int count = hashMap.get(i);
                hashMap.put(i, ++count);
            } else {
                hashMap.put(i, 1);
            }
        }
        return hashMap;
    }

    public static String removeDup(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (sb.indexOf("" + arr[i]) == -1) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}

/*Other Solutions*/
/*
import java.util.*;
import java.util.stream.Collectors;

public class Mixing {
    public static String mix(String s1, String s2) {

        List<String> finalStr = new ArrayList();

        for (char c = 'a'; c <= 'z'; c++) {
            String s1_char = s1.replaceAll("[^"+c+"]+","");
            String s2_char = s2.replaceAll("[^"+c+"]+","");

            int s1_length = s1_char.length();
            int s2_length = s2_char.length();

            if(s1_length>1 || s2_length>1){
                if(s1_length == s2_length){
                    finalStr.add("=:"+s1_char);
                }
                if(s1_length>s2_length){
                    finalStr.add("1:"+s1_char);
                }
                if(s1_length<s2_length){
                    finalStr.add("2:"+s2_char);
                }
            }
        }
        Comparator<String> length = (x,y) -> y.length()-x.length();
        Comparator<String> type_value = (x,y) -> Character.compare(x.charAt(0),y.charAt(0));

        return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
    }

}
*/

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Mixing {

    public static String mix(String s1, String s2) {
        HashMap<Character,Count> map=new HashMap<>();
        for(char c:s1.toCharArray()){
            if(map.containsKey(c)){
                map.get(c).times1++;
            }
            else{
                Count count=new Count();
                count.c=c;
                count.times1++;
                map.put(c,count);
            }
        }
        for(char c:s2.toCharArray()){
            if(map.containsKey(c)){
                map.get(c).times2++;
            }
            else{
                Count count=new Count();
                count.c=c;
                count.times2++;
                map.put(c,count);
            }
        }
        List<Count> list=new ArrayList<Count>(map.values());
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        for(Count c:list){
            if(c.getMax()>1&&c.c>='a'&&c.c<='z'){
                if(sb.length()!=0)
                    sb.append("/");
                sb.append(c.getMaxIndexString());
                sb.append(":");
                for(int i=0;i<c.getMax();i++){
                    sb.append(c.c);
                }
            }
        }
        return sb.toString();
    }
    private static class Count implements Comparable<Count>{
        char c;
        int times1=0;
        int times2=0;
        @Override
        public int compareTo(Count b){
            if(b.getMax()!=getMax())
                return b.getMax()-getMax();
            if(getMaxIndexString()!=b.getMaxIndexString()){
                return getMaxIndexString()-b.getMaxIndexString();
            }
            return c-b.c;
        }
        public int getMax(){
            return Math.max(times1,times2);
        }
        public int getMaxIndex(){
            return times1>times2?1:2;
        }
        public char getMaxIndexString(){
            return times1==times2?'=':times1>times2?'1':'2';
        }
    }
}
*/

/*
import java.util.Set;
import java.util.TreeSet;

public class Mixing {
    public static String mix(final String s1, final String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        final int[] a1 = new int[26];
        final int[] a2 = new int[26];

        char c1, c2;
        for (int i = 0; i < l1; i++) {
            c1 = s1.charAt(i);
            if (c1 >= 'a' && c1 <= 'z') a1[c1 - 'a']++;
        }
        for (int i = 0; i < l2; i++) {
            c2 = s2.charAt(i);
            if (c2 >= 'a' && c2 <= 'z') a2[c2 - 'a']++;
        }

        final Set<String> result = new TreeSet<>((o1, o2) -> {
            final int l = o1.length() - o2.length();
            return l == 0 ? o1.compareTo(o2) : -l;
        });

        int l;
        char w;
        for (int i = 0; i < 26; i++) {
            l1 = a1[i];
            l2 = a2[i];
            if (l1 <= 1 && (l1 ^ l2) <= 1) continue;

            if      (l1 > l2) {w = '1'; l = l1;}
            else if (l1 < l2) {w = '2'; l = l2;}
            else              {w = '='; l = l1;}

            final StringBuilder sb = new StringBuilder();
            sb.append(w).append(':');
            for (int j = 0; j < l; j++) {
                sb.append((char) (i + 'a'));
            }
            result.add(sb.append('/').toString());
        }

        final StringBuilder res = new StringBuilder();
        for (String s : result) res.append(s);
        if (res.length() > 0) res.deleteCharAt(res.length() - 1);

        return res.toString();
    }
}
*/


//Good to know
//System.out.println(tmp.replaceAll("([^a-zA-Z])","").replaceAll("([A-Z])","$1").toLowerCase());
