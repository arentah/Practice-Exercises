import java.math.BigDecimal;

public class Item {

    private String item;
    private int quantity;
    private BigDecimal price;

    public Item(String item, int quantity, BigDecimal price){
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

}
