public class PhoneNumberUS extends PhoneNumber {
    // private static final variables
    private static final String COUNTRYCODE = "1";

    // constructor
    public PhoneNumberUS(String areaCode, String phoneNumber) {
        super(COUNTRYCODE, areaCode, phoneNumber);
    }

    // override function
    /**
     * must between 200 and 999
     */
    @Override
    public void checkAreaCode(String areaCode) {
        try {
            int areaCodeInt = Integer.parseInt(areaCode);
            if (areaCodeInt<200 || areaCodeInt>999) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            String alert = String.format("area code \"%s\" is not valid.", areaCode);
            throw new IllegalArgumentException(alert);
        }
    }

    /**
     * must between 0 and 9999999
     */
    @Override
    public void checkPhoneNumber(String phoneNumber) {
        try {
            if (phoneNumber.length() != 7)
                throw new NumberFormatException();
            int phoneNumberInt = Integer.parseInt(phoneNumber);
            if (phoneNumberInt<0 || phoneNumberInt>9999999) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            String alert = String.format("phone number \"%s\" is not valid.", phoneNumber);
            throw new IllegalArgumentException(alert);
        }
    }

    @Override
    public String toString() {
        String phoneNumberFormat = "+%s (%s)%s-%s";
        String phoneNumber = String.format(phoneNumberFormat, COUNTRYCODE, getAreaCode(),
                getPhoneNumber().substring(0, 3), getPhoneNumber().substring(3));
        return phoneNumber;
    }
}
