/*My Solution*/
public class Arithmetic {
    public static void main(String[] args){
    }
    public static int arithmetic(int a, int b, String operator) {
        switch(operator){
            case "add": return a + b;
            case "subtract": return a - b;
            case "multiply": return a * b;
            case "divide": return a / b;
        }
        return -1;
    }
}

/*Other Solutions*/
/*
class ArithmeticFunction {
  public static int arithmetic(int a, int b, String operator) {
    // your code here
    int result;
    switch(operator)
    {
    case "add":
    result=a+b;
    break;
    case "subtract":
    result=a-b;
    break;
    case "multiply":
    result=a*b;
    break;
    case "divide":
    result=a/b;
    break;
    default:
             throw new IllegalArgumentException("Invalid argument: " + operator);
     }
     return result;
  }
}
*/

/**/