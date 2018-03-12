import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculateTax extends ConfigAccountingSettings {

    private Item[] itemArray;
    private BigDecimal totalCost = new BigDecimal("0.00");
    private BigDecimal totalSalesTax = new BigDecimal("0.00");
    private final String spacer = " ";
    private StringBuilder output = new StringBuilder();

    CalculateTax() {
    }

    public CalculateTax(Item[] itemArray) {
        super();
        this.itemArray = itemArray;
    }

    public BigDecimal[] calculateSale() {
        BigDecimal taxOnItem;

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

    public String calculate(){
        BigDecimal result[] = calculateSale();
        output = output.append("Sales Taxes: ").append(result[0]).append("\n");
        output = output.append("Total: ").append(result[1]);
        return output.toString();
    }

    private StringBuilder appendOutput(StringBuilder output, BigDecimal taxOnItem, Item item){
        return output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                .append(item.getPrice().add(taxOnItem)).append("\n");
    }

    @Override
    StringBuilder customOutputDisplay(StringBuilder output) {
        return null;
    }
}
