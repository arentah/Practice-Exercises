import java.math.BigDecimal;
import java.util.Locale;

public class CalculateTax extends ConfigTaxSettings{

    // GOAL
    // ========================================
    // Object-oriented class that performs the calculation of tax (sales & import) and displays an output
    // of the items purchased with their respective price, the total amount of sales tax paid, and the total cost

    // SPECIFICATIONS
    // ========================================
    // Code must be configurable, i.e. the user must be able to change tax rates, change currencies, add new taxes, etc
    // Round up to the nearest .05 cents for tax calculations
    // Include all source documents

    // CLASSES
    // ========================================
    // CalculateTax class to handle object creation
    // Item class to represent the items being sold
    // ConfigTaxSettings abstract class? or interface? to handle configurable options
    // BigDecimal class to handle tax calculations
    // NumberFormat class for displaying, or StringBuilder, or maybe write your own class

    // UNIT TESTING
    // ========================================
    // Test methods with various types of input to ensure functionality, reliability, Maintainability, Usability

    private Item[] itemArray;
    private StringBuilder output;
    private BigDecimal totalCost = new BigDecimal("0.00");
    private BigDecimal totalSalesTax = new BigDecimal("0.00");

    CalculateTax(){}

    public CalculateTax(Item[] itemArray){
        super();
        this.itemArray = itemArray;
    }

    public String calculateTotalSale(){

        output.append("Receipt").append("\n--------------------");

        for(Item item : itemArray){
            switch (item.getItemType()){
                case "food" :
                    if(item.getImported()){
                        totalSalesTax = totalSalesTax.add(item.getPrice().multiply(super.getImportTaxRate()));
                    }else{
                        totalCost = totalCost.add(item.getPrice());
                    }
                    break;
                case "medical" :
                    if(item.getImported()){
                        totalSalesTax = totalSalesTax.add(item.getPrice().multiply(super.getImportTaxRate()));
                    }else{
                        totalCost = totalCost.add(item.getPrice());
                    }
                    break;
                case "books" :
                    if(item.getImported()){
                        totalSalesTax = totalSalesTax.add(item.getPrice().multiply(super.getImportTaxRate()));
                    }else{
                        totalCost = totalCost.add(item.getPrice());
                    }
                    break;
                default :
                    if(item.getImported()){
                        totalSalesTax = totalSalesTax.add(item.getPrice().multiply(super.getBaseTaxRate()
                                .add(super.getImportTaxRate())));
                        totalCost = totalCost.add(item.getPrice());
                    }else{
                        totalSalesTax = totalSalesTax.add(item.getPrice().multiply(super.getBaseTaxRate()));
                        totalCost = totalCost.add(item.getPrice());
                    }
                    break;
            }
        }

        return output.toString();
    }
}
