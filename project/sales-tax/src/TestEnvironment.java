import java.math.BigDecimal;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

// GOAL
// ========================================
// Object-oriented class that performs the calculation of tax (sales & import) and displays an output
// of the items purchased with their respective price, the total amount of sales tax paid, and the total cost

// SPECIFICATIONS
// ========================================
// Code must be configurable, i.e. the user must be able to change tax rates, change currencies, add new taxes, etc
// Round up to the nearest .05 cents for tax calculations
// Include all source documents

// CLASSES/ENUMS
// ========================================
// CalculateTax class to handle object creation
// Item class to represent the items being sold
// ConfigTaxSettings abstract class? or interface? to handle configurable options
// BigDecimal class to handle tax calculations
// NumberFormat class for displaying, or StringBuilder, or maybe write your own class
// ItemType enum to specify and limit the set of possible item types

// UNIT TESTING
// ========================================
// Test methods with various types of input to ensure functionality, reliability, Maintainability, and Usability

public class TestEnvironment {
    public static void main(String[] args){

        Item[] it = new Item[3];
        it[0] = new Item(1,"book",new BigDecimal("12.49"),false, ItemType.BOOKS);
        it[1] = new Item(1,"CD",new BigDecimal("14.99"),false, ItemType.MISC);
        it[2] = new Item(1,"chocolate bar",new BigDecimal(".85"),false, ItemType.FOOD);
        CalculateTax cal = new CalculateTax(it);
        System.out.println(cal.calculateTotalSale());

        System.out.println();
        Item[] it2 = new Item[2];
        it2[0] = new Item(1, "box of chocolates", new BigDecimal("10.00"), true, ItemType.FOOD);
        it2[1] = new Item(1, "bottle of perfume", new BigDecimal("47.50"), true, ItemType.MISC);
        cal = new CalculateTax(it2);
        System.out.println(cal.calculateTotalSale());

        System.out.println();
        Item[] it3 = new Item[4];
        it3[0] = new Item(1, "imported bottle of perfume", new BigDecimal("27.99"), true, ItemType.MISC);
        it3[1] = new Item(1, "bottle of perfume", new BigDecimal("18.99"), false, ItemType.MISC);
        it3[2] = new Item(1, "packet of headache pills", new BigDecimal("9.75"), false, ItemType.MEDICAL);
        it3[3] = new Item(1, "imported box of chocolates", new BigDecimal("11.25"), true, ItemType.FOOD);
        cal = new CalculateTax(it3);
        System.out.println(cal.calculateTotalSale());

    }

}
