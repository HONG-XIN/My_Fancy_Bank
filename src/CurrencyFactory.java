/**
 * factory design pattern to initialize a class with given string
 */
public class CurrencyFactory implements CurrencyAbbrs {
    public Currency getCurrency(String currencyType) {
        if (currencyType == null) {
            return null;
        }
        if (currencyType.equals(CurrencyCNY)) {
            return new CurrencyCNY();
        } else if (currencyType.equals(CurrencyEUR)) {
            return new CurrencyEUR();
        } else if (currencyType.equals(CurrencyUSD)) {
            return new CurrencyUSD();
        }
        return null;
    }
}
