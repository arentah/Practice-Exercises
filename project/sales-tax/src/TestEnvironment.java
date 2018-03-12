import java.math.BigDecimal;

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
