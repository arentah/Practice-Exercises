import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public abstract class ConfigTaxSettings {

    private Currency currency;
    private Locale locale;
    private BigDecimal baseTaxRate;
    private BigDecimal importTaxRate;

    protected ConfigTaxSettings(){
        locale = Locale.US;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(".10");
        importTaxRate = new BigDecimal(".05");
    }

    protected ConfigTaxSettings(Locale locale, String baseRate, String importRate){
        this.locale = locale;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(baseRate);
        importTaxRate = new BigDecimal(importRate);
    }

    abstract void setNumberFormatDisplay(Locale locale);

    protected void setLocale(Locale locale){
        this.locale = locale;
        currency = Currency.getInstance(locale);
    }

    protected void setBaseTaxRate(BigDecimal baseTaxRate){
        this.baseTaxRate = baseTaxRate;
    }

    protected void setImportTaxRate(BigDecimal importTaxRate){
        this.importTaxRate = importTaxRate;
    }

    protected Locale getLocale(){
        return this.locale;
    }

    protected BigDecimal getBaseTaxRate() {
        return baseTaxRate;
    }

    protected BigDecimal getImportTaxRate() {
        return importTaxRate;
    }
}
