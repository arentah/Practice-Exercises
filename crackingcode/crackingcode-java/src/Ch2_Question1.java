import java.util.LinkedList;
import java.util.Random;

public class Ch2_Question1 {
    public static void main(String[] args){

        LinkedList<Integer> list = new LinkedList<>();
        list.add(8);list.add(3);list.add(12);list.add(5);list.add(3);list.add(8);list.add(9);list.add(13);list.add(1);list.add(2);
        System.out.println(list);
        list = removeDuplicatesNoBuffer(list);
        System.out.println(list);
    }

    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list){

        LinkedList<Integer> result = new LinkedList<>();
        for(Integer integer : list){
            if(!result.contains(integer))
                result.add(integer);
        }
        return result;
    }

    public static LinkedList<Integer> removeDuplicatesNoBuffer(LinkedList<Integer> list){
        Integer tmp = null;
        for(int i = 0 ; i < list.size(); i++){
            tmp = list.get(i);
            list.remove(i);
            while(list.contains(tmp)){
                list.remove(tmp);
            }
            list.add(i, tmp);
        }
        return list;
    }
}
