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
        BigDecimal taxOnItem;
        final String spacer = " ";
        output = new StringBuilder();

        for(Item item : itemArray){
            if(item.getItemType().equals("food") || item.getItemType().equals("medical")
                    || item.getItemType().equals("book")){
                if(item.getImported()){
                    taxOnItem = item.getPrice().multiply(super.getImportTaxRate());
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice().add(taxOnItem)).append("\n");
                }else{
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice()).append("\n");
                }
            }else{
                if(item.getImported()){
                    taxOnItem = item.getPrice().multiply(super.getBaseTaxRate().add(getImportTaxRate()));
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice().add(taxOnItem)).append("\n");
                }else{
                    taxOnItem = item.getPrice().multiply(super.getBaseTaxRate());
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    System.out.println(taxOnItem);
                    totalSalesTax = totalSalesTax.add(taxOnItem); /*item.getPrice().multiply(super.getBaseTaxRate())*/
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice().add(taxOnItem)).append("\n");
                }
            }
        }

        output = output.append("Sales Taxes: ").append(totalSalesTax).append("\n");
        output = output.append("Total: ").append(totalCost.add(totalSalesTax));

        return output.toString();
    }
}
