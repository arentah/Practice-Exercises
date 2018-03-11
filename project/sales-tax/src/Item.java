import java.math.BigDecimal;

class Item {

    private String itemName;
    private int quantity;
    private BigDecimal price;
    private boolean imported;
    private String itemType;

    public Item(String itemName, int quantity, BigDecimal price, boolean imported, String itemType){
        this.itemName = itemName;
        this.quantity = quantity;
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
