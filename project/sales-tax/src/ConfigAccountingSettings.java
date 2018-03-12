import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public abstract class ConfigAccountingSettings {

    private Locale locale;
    private BigDecimal baseTaxRate;
    private BigDecimal importTaxRate;
    private NumberFormat numberFormat;
    private Currency currency;

    protected ConfigAccountingSettings(){
        locale = Locale.US;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(".10");
        importTaxRate = new BigDecimal(".05");
    }

    protected ConfigAccountingSettings(Locale locale, String baseRate, String importRate){
        this.locale = locale;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(baseRate);
        importTaxRate = new BigDecimal(importRate);
    }

    abstract String customOutputDisplay(StringBuilder output);

    protected void setNumberFormat(Locale locale){
        numberFormat = NumberFormat.getInstance(locale);
    }

    protected void setCurrency(Currency currency){
        this.currency = currency;
    }

    protected void setLocale(Locale locale){
        this.locale = locale;
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
