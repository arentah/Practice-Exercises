/*
* Abstract method that extends a lot of functionality to subclasses.
*/

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public abstract class ConfigAccountingSettings {

    /*Global variables*/
    private Locale locale;
    private BigDecimal baseTaxRate;
    private BigDecimal importTaxRate;
    private NumberFormat numberFormat;
    private Currency currency;

    /*Primary constructor*/
    protected ConfigAccountingSettings(){
        locale = Locale.US;
        currency = Currency.getInstance(locale);
        baseTaxRate = new BigDecimal(".10");
        importTaxRate = new BigDecimal(".05");
    }

    protected ConfigAccountingSettings(Locale locale, String baseRate, String importRate){
        this.locale = locale;
        this.currency = Currency.getInstance(locale);
        this.numberFormat = NumberFormat.getInstance(locale);
        baseTaxRate = new BigDecimal(baseRate);
        importTaxRate = new BigDecimal(importRate);
    }

    /*Abstract class*/
    abstract StringBuilder customOutputDisplay(StringBuilder output);

    /*Setter Methods*/
    protected void setNumberFormat(Locale locale){
        if(locale == null) throw new IllegalArgumentException("Please enter a valid ISO 639 alpha-2 or alpha-3 language code.");
        else this.numberFormat = NumberFormat.getInstance(locale);
    }

    protected void setCurrency(Currency currency){
        if(currency == null) throw new IllegalArgumentException("Please enter a valid ISO 4217 Currency Code.");
        else this.currency = currency;
    }

    protected void setLocale(Locale locale){
        if(locale == null) throw new IllegalArgumentException("Please enter a valid ISO 639 alpha-2 or alpha-3 language code.");
        else this.locale = locale;
    }

    protected void setBaseTaxRate(BigDecimal baseTaxRate) {
        if(baseTaxRate == null) throw new IllegalArgumentException("Please enter a valid base tax rate.");
        else this.baseTaxRate = baseTaxRate;
    }

    protected void setImportTaxRate(BigDecimal importTaxRate) {
        if(importTaxRate == null) throw new IllegalArgumentException("Please enter a valid import tax rate.");
        else this.importTaxRate = importTaxRate;
    }

    /*Getter Methods*/
    protected Locale getLocale() { return locale; }

    protected BigDecimal getBaseTaxRate() { return baseTaxRate; }

    protected BigDecimal getImportTaxRate() { return importTaxRate; }

    protected Currency getCurrency() { return currency; }

    protected NumberFormat getNumberFormat() { return numberFormat; }
}
