import java.util.LinkedList;

public class Ch2_Question2 {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");list.add("world");list.add("what");list.add("a");list.add("beautiful");list.add("day!");
        System.out.println(kthToLast(list,2));
    }

    public static String kthToLast(LinkedList<String> list, int k){
        int size = list.size() - 1;
        if(k >= size)
            return "Outside boundaries of linked list...";

        return list.get(size-k);
    }
}
