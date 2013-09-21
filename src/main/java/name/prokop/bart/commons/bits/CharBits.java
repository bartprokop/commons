package name.prokop.bart.commons.bits;

public class CharBits {

    public static char narrow(int i) {
        i &= 0xFFFF;
        return (char) i;
    }

    /**
     * Promotes byte b to unsigned 16 bit value (0-255)
     *
     * @param b
     * @return
     */
    public static char promote(byte b) {
        return (char) (b & 0xff);
    }
}
