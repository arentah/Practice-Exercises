/*My Solution*/
public class Mean_And_Concatenate {
    public static void main(String[] args){
        char [] test = {'u', '6', 'd', '1', 'i', 'w', '6', 's', 't', '4', 'a',
                '6', 'g', '1', '2', 'w', '8', 'o', '2', '0'};
        Object[] obj = mean(test);
        for(Object tmp : obj)
            System.out.println(tmp);
    }

    public static Object[] mean(char[] lst)
    {
        double mean = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lst.length; i++) {
            String str = ""+lst[i];
            try{
                int tmp = Integer.parseInt(str);
                mean += tmp;
                count++;

            }catch (NumberFormatException e){
                result.append(str);
            }
        }
        mean /= count;
        return new Object[]{mean, result.toString()};
    }
}

/*Other Solutions*/
/*
public class Kata
{
    public static Object[] mean(char[] lst)
    {
      double mean = 0;
        String string = "";

        for(char character : lst)
        {
            if(Character.isDigit(character))
                mean += Character.digit(character, 10);
            else
                string += character;
        }
        mean /= 10d;

        Object[] oggetto = {mean,string};

        return oggetto;
    }
}
*/

/*
public class Kata {
  public static Object[] mean(char[] lst) {
    StringBuilder sb = new StringBuilder(10);
    int sum = 0;
    for (Character c : lst)
      if (c-'0'>=0 && c-'0'<10)
        sum += c-'0';
      else
        sb.append(c);
    return new Object[]{sum/10.0, sb.toString()};
  }
}
*/