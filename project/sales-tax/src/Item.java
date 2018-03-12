import java.math.BigDecimal;

class Item {
    private String itemName;
    private int quantity;
    private BigDecimal price;
    private boolean imported;
    private ItemType itemType;

    Item( int quantity, String itemName, BigDecimal price, boolean imported, ItemType type ){
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.imported = imported;
        this.itemType = type;
    }

    String getItemName(){
        return itemName;
    }

    int getQuantity(){
        return quantity;
    }

    BigDecimal getPrice(){
        return price;
    }

    boolean getImported(){
        return imported;
    }

    ItemType getItemType(){return itemType;}

    void setItemName(String itemName){
        this.itemName = itemName;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    void setPrice(BigDecimal price){
        this.price = price;
    }

    void setImported(boolean imported){
        this.imported = imported;
    }

    void setItemType(ItemType itemType){
        this.itemType = itemType;
    }

}

enum ItemType {
    FOOD,
    BOOKS,
    MEDICAL,
    MISC
}

