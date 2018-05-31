import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexContentTagExtractor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        String regex = "(<)(\\w+>)((?:\\w+\\s*)+)(?:\\1/\\2)";
//        Pattern p = Pattern.compile(regex);
        int testCases =1;//= Integer.parseInt(scanner.nextLine());
        while(testCases > 0){
            //String regex = "(<)((?:\\w+\\s*)+>)((?:\\w+\\s*)+)(?:\\1/\\2)";
            String regex = "(<)([^>]+>)([^>]*)(?:\\1/\\2)";
            Pattern p = Pattern.compile(regex);
            String line = scanner.nextLine();
            Matcher m = p.matcher(line);

            int count = 0;
            while(m.find()) {
                count++;
                if (!m.group(3).equals(""))
                    System.out.println(m.group(3));
            }

            m.reset();
            if(!m.find())
                System.out.println("None");
            else if(count == 1 && m.group(3).equals("")){
                System.out.println("None");
            }
            testCases--;
        }
        System.out.println("--------");
    }
}



//String regex = "(<)(\\w+>)(?:(?:\\s*\\w+\\s*)+||(?:(<)(\\w+>)(?:\\s*\\w+\\s*)(?:\\3/\\4)))(?:\\1/\\2)"; //"(<)(\\w+>)(?:\\s*\\w+\\s*)+(?:\\1/\\2)"
//System.out.println("char at: "+m.start()+", "+input.charAt(m.start())+" char at: "+(m.end()-1)+", "+input.charAt(m.end()-1));

//        String regex = "(?:\\w\\s*)+";
//        String in = "hello";
//        System.out.println(in.matches(regex));
//        Pattern pp = Pattern.compile(regex);
//        Matcher mm = pp.matcher(in);
//        while(mm.find()){
//            System.out.println("char at: "+mm.start()+", "+in.charAt(mm.start())+" char at: "+(mm.end()-1)+", "+in.charAt(mm.end()-1));
//        }


//        String regex = "(<)(\\w+>)(?:(?:\\s*\\w+\\s*)+||(?:(<)(\\w+>)(?:\\s*\\w+\\s*)(?:\\3/\\4)))(?:\\1/\\2)"; //"(<)(\\w+>)(?:\\s*\\w+\\s*)+(?:\\1/\\2)"
//        String input = "<e> hello world <f>fuck<g>jezdfdsdsafd</g></f></e><s>alio</s>"; //<h>hello sexy</h>
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(input);
//        while(m.find()){
//            StringBuilder output = new StringBuilder();
//            for(int i = m.start()+3; i < m.end()-4; i++){
//                output.append(input.charAt(i));
//            }
//            System.out.println(output);
//            //System.out.println("char at: "+m.start()+", "+input.charAt(m.start())+" char at: "+(m.end()-1)+", "+input.charAt(m.end()-1));
//        }
