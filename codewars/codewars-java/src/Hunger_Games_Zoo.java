/*My Solution*/
import java.util.ArrayList;
import java.util.Arrays;

public class Hunger_Games_Zoo {
    public static void main(String[] args){
        String input = "little-fish,sheep,sheep,chicken,bug,fox,chicken,panda,bicycle,fox";
        String [] tmp = whoEatsWho(input);
        for(int i = 0; i < tmp.length; i++){
            System.out.println(tmp[i]);
        }
    }
    public static String[] whoEatsWho(final String zoo) {
        ArrayList<String> res = new ArrayList<>();
        res.add(zoo);
        ArrayList<String> newZoo = new ArrayList<>(Arrays.asList(zoo.split(",")));
        int count = 0;
        while(count < newZoo.size()) {
            if (count == 0 && newZoo.size() > 1) {
                if(checkSingle(null, newZoo.get(count), newZoo.get(count + 1)) == 2){
                    res.add(newZoo.get(count)+" eats "+newZoo.get(count + 1));
                    newZoo.remove(count + 1);
                    count = 0;
                    continue;
                }
            }
            else if(count == newZoo.size() - 1 && newZoo.size() > 1){
                if(checkSingle(newZoo.get(count - 1), newZoo.get(count), null) == 1){
                    res.add(newZoo.get(count)+" eats "+newZoo.get(count - 1));
                    newZoo.remove(count - 1);
                    count = 0;
                    continue;
                }
            }
            else if(newZoo.size() > 2){
                if(checkBoth(newZoo.get(count - 1), newZoo.get(count), newZoo.get(count + 1)) == 1){
                    res.add(newZoo.get(count)+" eats "+newZoo.get(count - 1));
                    newZoo.remove(count - 1);
                    count = 0;
                    continue;
                } else if (checkBoth(newZoo.get(count - 1), newZoo.get(count), newZoo.get(count + 1)) == 2) {
                    res.add(newZoo.get(count)+" eats "+newZoo.get(count + 1));
                    newZoo.remove(count + 1);
                    count = 0;
                    continue;
                }else if(checkBoth(newZoo.get(count - 1), newZoo.get(count), newZoo.get(count + 1)) == 3){
                    res.add(newZoo.get(count)+" eats "+newZoo.get(count - 1));
                    newZoo.remove(count - 1);
                    count = 0;
                    continue;
                }
            }
            count++;
        }
        StringBuilder remaining = new StringBuilder();
        for(int i = 0; i < newZoo.size(); i++){
            if(i == newZoo.size() - 1)
                remaining.append(newZoo.get(i));
            else{
                remaining.append(newZoo.get(i)).append(",");
            }
        }
        res.add(remaining.toString());
        String[] finalRes = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    public static int checkBoth(String left, String middle, String right){
        int leftInt = 0;
        int rightInt = 0;
        if(middle == null)
            return 0;
        switch(middle){
            case "antelope":
                if(left.equals("grass"))
                    leftInt++;
                if(right.equals("grass"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "bug":
                if(left.equals("leaves"))
                    leftInt++;
                if(right.equals("leaves"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "big-fish":
                if(left.equals("little-fish"))
                    leftInt++;
                if(right.equals("little-fish"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "bear":
                if(left.equals("big-fish") || left.equals("bug") || left.equals("chicken")
                        || left.equals("cow") || left.equals("leaves") || left.equals("sheep"))
                    leftInt++;
                if(right.equals("big-fish") || right.equals("bug") || right.equals("chicken")
                        || right.equals("cow") || right.equals("leaves") || right.equals("sheep"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "chicken":
                if(left.equals("bug"))
                    leftInt++;
                if(right.equals("bug"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "cow":
                if(left.equals("grass"))
                    leftInt++;
                if(right.equals("grass"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "fox":
                if(left.equals("chicken") || left.equals("sheep"))
                    leftInt++;
                if(right.equals("chicken") || right.equals("sheep"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "giraffe":
                if(left.equals("leaves"))
                    leftInt++;
                if(right.equals("leaves"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "lion":
                if(left.equals("antelope") || left.equals("cow"))
                    leftInt++;
                if(right.equals("antelope") || right.equals("cow"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "panda":
                if(left.equals("leaves"))
                    leftInt++;
                if(right.equals("leaves"))
                    rightInt+=2;
                return leftInt + rightInt;
            case "sheep":
                if(left.equals("grass"))
                    leftInt++;
                if(right.equals("grass"))
                    rightInt+=2;
                return leftInt + rightInt;
        }
        return 0;
    }

    public static int checkSingle(String left, String middle, String right){
        if(middle == null)
            return 0;
        if(left != null && right == null){
            switch(middle){
                case "antelope":
                    if(left.equals("grass"))
                        return 1;
                    break;
                case "bug":
                    if(left.equals("leaves"))
                        return 1;
                    break;
                case "big-fish":
                    if(left.equals("little-fish"))
                        return 1;
                    break;
                case "bear":
                    if(left.equals("big-fish") || left.equals("bug") || left.equals("chicken")
                            || left.equals("cow") || left.equals("leaves") || left.equals("sheep"))
                        return 1;
                    break;
                case "chicken":
                    if(left.equals("bug"))
                        return 1;
                    break;
                case "cow":
                    if(left.equals("grass"))
                        return 1;
                    break;
                case "fox":
                    if(left.equals("chicken") || left.equals("sheep"))
                        return 1;
                    break;
                case "giraffe":
                    if(left.equals("leaves"))
                        return 1;
                    break;
                case "lion":
                    if(left.equals("antelope") || left.equals("cow"))
                        return 1;
                    break;
                case "panda":
                    if(left.equals("leaves"))
                        return 1;
                    break;
                case "sheep":
                    if(left.equals("grass"))
                        return 1;
                    break;
            }
        }
        else if(left == null && right != null){
            switch(middle){
                case "antelope":
                    if(right.equals("grass"))
                        return 2;
                    break;
                case "bug":
                    if(right.equals("leaves"))
                        return 2;
                    break;
                case "big-fish":
                    if(right.equals("little-fish"))
                        return 2;
                    break;
                case "bear":
                    if(right.equals("big-fish") || right.equals("bug") || right.equals("chicken")
                            || right.equals("cow") || right.equals("leaves") || right.equals("sheep"))
                        return 2;
                    break;
                case "chicken":
                    if(right.equals("bug"))
                        return 2;
                    break;
                case "cow":
                    if(right.equals("grass"))
                        return 2;
                    break;
                case "fox":
                    if(right.equals("chicken") || right.equals("sheep"))
                        return 2;
                    break;
                case "giraffe":
                    if(right.equals("leaves"))
                        return 2;
                    break;
                case "lion":
                    if(right.equals("antelope") || right.equals("cow"))
                        return 2;
                    break;
                case "panda":
                    if(right.equals("leaves"))
                        return 2;
                    break;
                case "sheep":
                    if(right.equals("grass"))
                        return 2;
                    break;
            }
        }
        return 0;
    }
}

/*Other Solutions*/
/*
import java.util.*;
public class Dinglemouse {
    private static Map<String, List<String>> whoEats = new HashMap<>();
    private static void initWhoEats() {
        whoEats.put("antelope", Arrays.asList("grass"));
        whoEats.put("big-fish", Arrays.asList("little-fish"));
        whoEats.put("bug", Arrays.asList("leaves"));
        whoEats.put("bear", Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep"));
        whoEats.put("chicken", Arrays.asList("bug"));
        whoEats.put("cow", Arrays.asList("grass"));
        whoEats.put("fox", Arrays.asList("chicken", "sheep"));
        whoEats.put("giraffe", Arrays.asList("leaves"));
        whoEats.put("lion", Arrays.asList("antelope", "cow"));
        whoEats.put("panda", Arrays.asList("leaves"));
        whoEats.put("sheep", Arrays.asList("grass"));
    }

    public static String[] whoEatsWho(final String zoo) {
        initWhoEats();
        List<String> result = new ArrayList<>();
        result.add(zoo);
        List<String> animals = new ArrayList<>(Arrays.asList(zoo.split(",")));
        int i = 0;
        while (i < animals.size()) {
            if (i != 0)
                if (canEat(animals.get(i), animals.get(i - 1))) {
                    result.add(animals.get(i) + " eats " + animals.get(i - 1));
                    animals.remove(i - 1);
                    i = 0;
                    continue;
                }

            if (i < animals.size() - 1)
                if (canEat(animals.get(i), animals.get(i + 1))) {
                    result.add(animals.get(i) + " eats " + animals.get(i + 1));
                    animals.remove(i + 1);
                    i = 0;
                    continue;
                }

            i++;
        }
        result.add(String.join(",", animals));
        return result.toArray(new String[result.size()]);
    }
    private static boolean canEat(String animal, String animal1) {
        if (whoEats.containsKey(animal))
            if (whoEats.get(animal).indexOf(animal1) != -1)
                return true;
        return false;
    }
}
*/

/*
import java.util.*;
public class Dinglemouse {
  public static String[] s = {"antelope eats grass",
                "big-fish eats little-fish",
                "bug eats leaves",
                "bear eats big-fish",
                "bear eats bug",
                "bear eats chicken",
                "bear eats cow",
                "bear eats leaves",
                "bear eats sheep",
                "chicken eats bug",
                "cow eats grass",
                "fox eats chicken",
                "fox eats sheep",
                "giraffe eats leaves",
                "lion eats antelope",
                "lion eats cow",
                "panda eats leaves",
                "sheep eats grass"};
  public static List<String> zooList = Arrays.asList(s);

  public static String[] whoEatsWho(final String zoo) {
        List<String> rList = new ArrayList<String>();
        rList.add(zoo);
        List<String> iList = new ArrayList<String>(Arrays.asList(zoo.split(",")));
        int index = 0;
        while(iList.size()>1 && index < iList.size()){
            int n = check(iList,index,index-1);
            if(n!=-1){
                iList.remove(index-1);
                index=0;
                rList.add(zooList.get(n));
                continue;
            }
            n = check(iList,index,index+1);
            if(n!=-1){
                iList.remove(index+1);
                index=0;
                rList.add(zooList.get(n));
                continue;
            }
           index++;
        }
       rList.add(String.join(",", iList));
       return  rList.toArray(new String[0]);
  }
      public static int check(List<String> iList, int i, int n){
        if(n<0 || n>iList.size()-1)
         return -1;
        return zooList.indexOf(iList.get(i) + " eats " + iList.get(n));
    }
}
*/

/*
import java.util.*;
public class Dinglemouse {
  private static final Set<String> thisEatsThat = new HashSet<String>() {{
    add("antelope eats grass");
    add("big-fish eats little-fish");
    add("bug eats leaves");
    add("bear eats big-fish");
    add("bear eats bug");
    add("bear eats chicken");
    add("bear eats cow");
    add("bear eats leaves");
    add("bear eats sheep");
    add("chicken eats bug");
    add("cow eats grass");
    add("fox eats chicken");
    add("fox eats sheep");
    add("giraffe eats leaves");
    add("lion eats antelope");
    add("lion eats cow");
    add("panda eats leaves");
    add("sheep eats grass");
  }};

  public static String[] whoEatsWho(final String zoo) {
    final String things[] = zoo.split(",");
    final List<String> output = new ArrayList<>();
    final List<String> remaining = new ArrayList(Arrays.asList(things));
    output.add(zoo);
    boolean done = false;
    while (!done) {
      done = true;
      for (int i = 0; i < remaining.size(); i++) {
        final String me = remaining.get(i);

        // Can I eat the whatever is to the LEFT of me
        if (i - 1 >= 0) {
          final String eats = String.format("%s eats %s", me, remaining.get(i-1));
          if (thisEatsThat.contains(eats)) {
            output.add(eats);
            remaining.remove(i-1);
            done = false;
            break;
          }
        }

        // Can I eat whatever is to RIGHT of me?
        if (i + 1 < remaining.size()) {
          final String eats = String.format("%s eats %s", me, remaining.get(i+1));
          if (thisEatsThat.contains(eats)) {
            output.add(eats);
            remaining.remove(i+1);
            done = false;
            break;
          }
        }
      }
    }
    output.add(String.join(",",remaining));
    final String[] ret = output.toArray(new String[0]);
    return ret;
  }
}
*/

/*import java.util.*;
public class Dinglemouse {
  private static Set<String> emptySet = Collections.EMPTY_SET;
  private static Map<String,Set<String>> eaters = new HashMap<String,Set<String>>();
  static { eaters.put("antelope", new HashSet<String>(Arrays.asList("grass")));
           eaters.put("big-fish", new HashSet<String>(Arrays.asList("little-fish")));
           eaters.put("bug",      new HashSet<String>(Arrays.asList("leaves")));
           eaters.put("bear",     new HashSet<String>(Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep")));
           eaters.put("chicken",  new HashSet<String>(Arrays.asList("bug")));
           eaters.put("cow",      new HashSet<String>(Arrays.asList("grass")));
           eaters.put("fox",      new HashSet<String>(Arrays.asList("chicken", "sheep")));
           eaters.put("giraffe",  new HashSet<String>(Arrays.asList("leaves")));
           eaters.put("lion",     new HashSet<String>(Arrays.asList("antelope", "cow")));
           eaters.put("panda",    new HashSet<String>(Arrays.asList("leaves")));
           eaters.put("sheep",    new HashSet<String>(Arrays.asList("grass")));
  }

  public static String[] whoEatsWho(final String zoo) {
      List<String> zooLst = new ArrayList<String>(Arrays.asList(zoo.split(","))),
                   ansLst = new ArrayList<String>(Arrays.asList(zoo));

      for (int n=0 ; n < zooLst.size() ; n++) {
          while (n > 0 && eaters.getOrDefault(zooLst.get(n), emptySet).contains(zooLst.get(n-1)))
              ansLst.add( String.format("%s eats %s", zooLst.get(n--), zooLst.remove(n--)));

          while (n >= 0 && n != zooLst.size()-1 && eaters.getOrDefault(zooLst.get(n), emptySet).contains(zooLst.get(n+1)))
              ansLst.add( String.format("%s eats %s", zooLst.get(n), zooLst.remove(n+1)));
      }
      ansLst.add(String.join(",", zooLst));
      return ansLst.toArray(new String[0]);
  }
}
*/