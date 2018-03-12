import java.math.BigDecimal;

class Item {
    private String itemName;
    private int quantity;
    private BigDecimal price;
    private boolean imported;
    private ItemType itemType;

    Item( int quantity, String itemName, BigDecimal price, boolean imported, ItemType itemType ){

        if(itemName == null || itemName.isEmpty()) this.itemName = "MISSING ITEM NAME";
        else this.itemName = itemName;

        if(price == null) throw new IllegalArgumentException("Please enter a valid price for \""+ itemName+"\"");
        else this.price = price;

        if(itemType == null) throw new IllegalArgumentException("Please enter a valid item type for \""+ itemName+"\"");
        else this.itemType = itemType;

        this.quantity = quantity;
        this.imported = imported;
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
        if(itemName == null || itemName.isEmpty()) this.itemName = "MISSING ITEM NAME";
        else this.itemName = itemName;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    void setPrice(BigDecimal price){
        if(price == null) throw new IllegalArgumentException("Please enter a valid price for \""+ itemName+"\"");
        else this.price = price;
    }

    void setImported(boolean imported){
        this.imported = imported;
    }

    void setItemType(ItemType itemType){
        if(itemType == null) throw new IllegalArgumentException("Please enter a valid item type for \""+ itemName+"\"");
        else this.itemType = itemType;
    }
}

enum ItemType {
    FOOD,
    BOOKS,
    MEDICAL,
    MISC
}

