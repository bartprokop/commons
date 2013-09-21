package name.prokop.bart.commons.crc;

public class Luhn {

    /**
     * Calculates Luhn digit for specified number code
     *
     * @param s number code to be used to generate Luhn digits. All digits are
     * used for calculation from 0 to length()-1.
     * @return Luhn number as String. In fact it is String[1] containing single
     * decimal digit
     */
    public static String generateLuhnDigit(String s) {
        int digit = calcLuhn(s, true) % 10;
        if (digit != 0) {
            digit = 10 - digit;
        }
        return "" + digit;
    }

    /**
     * Checks if given string is passes Luhn test. We assume that last digit
     * contains Luhn digit.
     *
     * @param s number code to be tested
     * @return true if Luhn test was passed, false otherwise
     */
    public static boolean isValidLuhnNumber(String s) {
        return calcLuhn(s, false) % 10 == 0;
    }

    /**
     * performs necessary calculation to calculate Luhn digit
     *
     * @param numberCode
     * @param even - if rightmost position is treated as odd or even. It is nice
     * hack to use the same function for both generating and validating Luhn
     * digit
     * @return Luhn digit
     */
    private static int calcLuhn(String numberCode, boolean even) {
        int luhnSum = 0;
        for (int i = numberCode.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numberCode.substring(i, i + 1));
            if (even) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            luhnSum += n;
            even = !even;
        }

        return luhnSum;
    }
}
