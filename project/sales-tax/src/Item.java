import java.math.BigDecimal;

class Item {

    private String itemName;
    private int quantity;
    private BigDecimal price;
    private boolean imported;
    private String itemType;

    public Item( int quantity, String itemName, BigDecimal price, boolean imported, String itemType){
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.imported = imported;
        this.itemType = itemType;
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

    public String getItemType(){
        return itemType;
    }

}
