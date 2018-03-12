/*
* Primary concrete class that calculates the total sale, sales tax on each applicable item, and total
* sales taxes. The CalculateTax class extends and/or inherits from the abstract class ConfigAccountingSettings
* which provides some basic functionality and override-able abstract methods.
*/

import java.math.BigDecimal;

public class CalculateTax extends ConfigAccountingSettings {

    /*
    * Global variables
    */

    /*Item array created by user*/
    private Item[] itemArray;
    /*Initial total cost value*/
    private BigDecimal totalCost = new BigDecimal("0.00");
    /*Initial total sales tax value*/
    private BigDecimal totalSalesTax = new BigDecimal("0.00");
    /*Space value holder*/
    private final String spacer = " ";
    /*StringBuilder to hold the final output*/
    private StringBuilder output = new StringBuilder();

    /*Empty constructor*/
    CalculateTax() {
    }

    /*Primary constructor that calls its super method from ConfigAccountingSettings*/
    public CalculateTax(Item[] itemArray) {
        super();
        this.itemArray = itemArray;
    }

    /*Calculation method that calculates total cost and total sales taxes and returns the two
    * values in an array of type BigDecimal. */
    public BigDecimal[] calculateSale() {
        /*Local variables*/
        BigDecimal taxOnItem;

        /*For-Each loop that iterates through each item checking if the item is an exempt item
        * and calculating taxes due. Each item is displayed to the output as it iterates.Taxes
        * are rounded up to the nearest .05*/
        for (Item item : itemArray) {
            if (item.getItemType() == ItemType.BOOKS || item.getItemType() == ItemType.FOOD
                    || item.getItemType() == ItemType.MEDICAL) {
                if (item.getImported()) {
                    taxOnItem = item.getPrice().multiply(super.getImportTaxRate());
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP)
                            .divide(new BigDecimal("20")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output = appendOutput(output, taxOnItem, item);
                } else {
                    totalCost = totalCost.add(item.getPrice());
                    taxOnItem = new BigDecimal("0.00");
                    output = appendOutput(output, taxOnItem, item);
                }
            } else {
                if (item.getImported()) {
                    taxOnItem = item.getPrice().multiply(super.getBaseTaxRate().add(getImportTaxRate()));
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP)
                            .divide(new BigDecimal("20")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output = appendOutput(output, taxOnItem, item);
                } else {
                    taxOnItem = item.getPrice().multiply(super.getBaseTaxRate());
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP)
                            .divide(new BigDecimal("20")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output = appendOutput(output, taxOnItem, item);
                }
            }
        }
        totalCost = totalCost.add(totalSalesTax);
        return new BigDecimal[]{totalSalesTax, totalCost};
    }

    /*Method to output the final calculations to the receipt.*/
    public String outputCalculation(){
        BigDecimal result[] = calculateSale();
        output = output.append("Sales Taxes: ").append(result[0]).append("\n");
        output = output.append("Total: ").append(result[1]);
        return output.toString();
    }

    /*StringBuilder method to add each item to the final output string*/
    private StringBuilder appendOutput(StringBuilder output, BigDecimal taxOnItem, Item item){
        return output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                .append(item.getPrice().add(taxOnItem)).append("\n");
    }

    /*Unused overrided method from ConfigAccountingSettings*/
    @Override
    StringBuilder customOutputDisplay(StringBuilder output) {
        return null;
    }
}
