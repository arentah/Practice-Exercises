import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

//import static java.lang.Integer.parseInt;

public class BigNumber_BigDecimal {

    enum make {TOYOTA, BMW, HONDA, SUBARU}

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String s[] = new String[n+2];
//        for(int i = 0; i<n ;i++){
//            s[i]=sc.next();
//        }
//        sc.close();
//
//        String s2[] = new String[s.length-2];
//        for(int i =0; i<n;i++){
//            s2[i] = s[i];
//        }
//        BigDecimal bg,bg2;
//        //System.out.println("original: "+Arrays.toString(s2));
//        for(int i = 0; i< n;i++){
//            for(int j=i; j< n;j++){
//
//                if(j == i)
//                    continue;
//                bg = new BigDecimal(s2[i]);
//                bg2 = new BigDecimal(s2[j]);
//                String output = bg2.max(bg).toString();
//                BigDecimal bg3 = new BigDecimal(output);
//
//                double bgs = java.lang.Double.parseDouble(bg.toString());
//                double bgs2 = java.lang.Double.parseDouble(bg2.toString());
//
//                boolean check ;//= bg.equals(bg2);
//
//                if(bgs != bgs2)
//                    check = false;
//                else
//                    check = true;
////                if(i == 3 && j ==7 ){
////                    System.out.println("i: "+s2[i]);
////                    System.out.println("j: "+s2[j]);
////                }
//                if(s2[j].equals(output) || (bg3.equals(bg2) && !check)){
//                    String temp = s2[i];
//                    s2[i] = s2[j];
//                    s2[j] = temp;
//                    //System.out.println(Arrays.toString(s2));
//                }
//
//            }
//        }
//
//        for(int i = 0; i<n;i++){
//            s[i] = s2[i];
//        }
//
//        for(int i =0;i<n;i++ ){
//            System.out.println(s[i]);
//        }

//        BigDecimal bg = new BigDecimal("0");
//        BigDecimal bg2 = new BigDecimal("000.000");
//
//        double bgs = java.lang.Double.parseDouble(bg.toString());
//        double bgs2 = java.lang.Double.parseDouble(bg2.toString());
//
//        System.out.println(bgs+" "+bgs2);
//
//
//        System.out.println(bg2.toString()+" and "+bg.toString());
//        boolean test2 = bg2.equals(bg);
//        System.out.println(test2);

        //System.out.println(bg+" "+bg2);

//        if(bg.toString() == bg2.toString())
//            System.out.println("same");
//
//       if(bg.max(bg2)==bg){
//           System.out.println(bg +" is smaller than" + bg2);
//       }
//        if(bg.equals(bg2)){
//            System.out.println(bg +" is equal to " + bg2);
//        }


//        double g = 5.33;
//        System.out.printf("%.4f\n", g);

//        int test[] = new int[]{1,2,3};
//
//        for(int i : test){
//            System.out.println(i);}
//
//        String[] fruits = new String[] { "Orange", "Apple", "Pear", "Strawberry" };
//
//        for (String i : fruits) {
//            System.out.println(i);
//        }

        String s = "hello";

        for(int i = 0,j=10; (i<s.length() && j>s.length()); i++,j--){
            out.println(i+" "+j);
        }

        int []array_test = new int[3];
        int []array_test2 = {1,2,3};
        int []array_test3 = new int[]{1,2,3};

        for(int x: array_test2){
            System.out.println(x);
        }

        for(make m: make.values()){
            System.out.println(m);
        }
        List list = new ArrayList();

        Iterable iterable;

        //Iterator<Object> itr = iterable.iterator();

//        for ( Iterator iter = list.iterator(); iter.hasNext(); )
//        {
//            String key = (String)iter.next();
//            out.println( key );
//        }

        BigNumber_BigDecimal test = new BigNumber_BigDecimal();
        test.someMethod("cow","dog","panther");

//        if(true)
//            throw new IOException("Connection failed!!");



        String tt = "";

        char a = 'a';
        char A = 'A';

        if(Character.toString(a).matches(Character.toString(A)))
            System.out.println("LOOKS OK");

        if(tt.equals("")){
            System.out.println("OKAY!!");
        }
    }

    public<T> LinkedList<T> sort(LinkedList<T> list){
        for (T t : list){
            System.out.println(t);
        }
        LinkedList<T> somelist = new LinkedList<T>();
        return somelist;
    }

    void someMethod(String... animals){

        for(int i = 0; i<animals.length; i++){
            System.out.println(animals[i]);
        }

        for(String s : animals){
            System.out.println(s);
        }

    }
}
