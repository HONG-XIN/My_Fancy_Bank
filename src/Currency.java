/**
 * one specific currency
 */
public class Currency {
    // instance variables with private access
    private String abbr;
    private String details;

    // constructors
    public Currency(String abbr, String details) {
        this.abbr    = abbr;
        this.details = details;
    }

    public Currency() {
        this("", "");
    }

    // accessor functions
    public String getAbbr() {
        return abbr;
    }

    public String getDetails() {
        return details;
    }

    // mutator functions
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // override function
    @Override
    public String toString() {
        String currency = abbr;
        currency += " " + details;
        return currency.trim();
    }
}
