import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculateTax extends ConfigTaxSettings {

    private Item[] itemArray;
    private BigDecimal totalCost = new BigDecimal("0.00");
    private BigDecimal totalSalesTax = new BigDecimal("0.00");
    private NumberFormat numberFormat;

    CalculateTax() {
    }

    public CalculateTax(Item[] itemArray) {
        super();
        this.itemArray = itemArray;
    }

    public String calculateTotalSale() {
        BigDecimal taxOnItem;
        final String spacer = " ";
        StringBuilder output = new StringBuilder();

        for (Item item : itemArray) {
            if (item.getItemType() == ItemType.BOOKS || item.getItemType() == ItemType.FOOD
                    || item.getItemType() == ItemType.MEDICAL) {
                if (item.getImported()) {
                    taxOnItem = item.getPrice().multiply(super.getImportTaxRate());
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice().add(taxOnItem)).append("\n");
                } else {
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice()).append("\n");
                }
            } else {
                if (item.getImported()) {
                    taxOnItem = item.getPrice().multiply(super.getBaseTaxRate().add(getImportTaxRate()));
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    totalSalesTax = totalSalesTax.add(taxOnItem);
                    totalCost = totalCost.add(item.getPrice());
                    output.append(item.getQuantity()).append(spacer).append(item.getItemName()).append(spacer)
                            .append(item.getPrice().add(taxOnItem)).append("\n");
                } else {
                    taxOnItem = item.getPrice().multiply(super.getBaseTaxRate());
                    taxOnItem = taxOnItem.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
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

    @Override
    void setNumberFormatDisplay(Locale locale) {
        numberFormat = NumberFormat.getInstance(locale);
    }
}
