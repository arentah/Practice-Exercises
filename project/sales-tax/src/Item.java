import java.math.BigDecimal;

class Item {
    private String itemName;
    private int quantity;
    private BigDecimal price;
    private boolean imported;
    private ItemType type;

    public Item( int quantity, String itemName, BigDecimal price, boolean imported, ItemType type ){
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.imported = imported;
        this.type = type;
    }

    public String getItemName(){
        return itemName;
    }

    public int getQuantity(){
        return quantity;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public boolean getImported(){
        return imported;
    }

    public ItemType getItemType(){return type;}

}

enum ItemType {
    FOOD,
    BOOKS,
    MEDICAL,
    MISC
}

