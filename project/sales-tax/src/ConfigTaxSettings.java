import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public abstract class ConfigTaxSettings {

    private Currency currency;
    private Locale locale;
    private BigDecimal baseTaxRate;
    private BigDecimal importTaxRate;


    public ConfigTaxSettings(){
        locale = Locale.US;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(".10");
        importTaxRate = new BigDecimal(".05");
    }

    public ConfigTaxSettings(Locale locale, String baseRate, String importRate){
        this.locale = locale;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(baseRate);
        importTaxRate = new BigDecimal(importRate);
    }

    public void setLocale(Locale locale){
        this.locale = locale;
        currency = Currency.getInstance(locale);
    }

    public BigDecimal getBaseTaxRate() {
        return baseTaxRate;
    }

    public BigDecimal getImportTaxRate() {
        return importTaxRate;
    }
}
