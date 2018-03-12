import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTaxUnitTest {
    @Test
    void calculateSale() {
        Item[] it = new Item[10];
        it[0] = new Item(1,"book",new BigDecimal("19.87"),false, ItemType.BOOKS);
        it[1] = new Item(1,"CD",new BigDecimal("13.99"),true, ItemType.MISC);
        it[2] = new Item(1,"chocolate bar",new BigDecimal("1.01"),true, ItemType.FOOD);
        it[3] = new Item(1,"video game",new BigDecimal("64.99"),false, ItemType.MISC);
        it[4] = new Item(1,"bicycle",new BigDecimal("250.32"),false, ItemType.MISC);
        it[5] = new Item(1,"apple juice",new BigDecimal("2.00"),true, ItemType.FOOD);
        it[6] = new Item(1,"Tylenol",new BigDecimal("5.84"),false, ItemType.MEDICAL);
        it[7] = new Item(1,"television",new BigDecimal("399.99"),false, ItemType.MISC);
        it[8] = new Item(1,"tissue paper",new BigDecimal("1.99"),true, ItemType.MISC);
        it[9] = new Item(1,"children's story book",new BigDecimal("2.99"),false, ItemType.BOOKS);
        CalculateTax unitTest = new CalculateTax(it);

        BigDecimal[] result = unitTest.calculateSale();
        char[] res1 = result[0].toString().toCharArray();
        char[] res2 = result[1].toString().toCharArray();
        assertArrayEquals("74.15".toCharArray(), res1);
        assertArrayEquals("837.14".toCharArray(), res2);
    }
}