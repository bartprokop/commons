package name.prokop.bart.commons.bits;

public class IntegerBits {

    /**
     * Promotes byte b to unsigned 32 bit value (0-255)
     *
     * @param b
     * @return
     */
    public static int promote(byte b) {
        return (int) (b & 0xff);
    }

    public static int promote(char c) {
        return (int) (c & 0xffff);
    }

    public static int narrow(long i) {
        i &= 0xFFFFFFFF;
        return (int) i;
    }

    public static int build(byte[] a) {
        //System.out.println(ToString.byteArrayToString(a));
        int i = 0;
        if (a.length == 4) {
            i |= promote(a[0]) << 24;
            i |= promote(a[1]) << 16;
            i |= promote(a[2]) << 8;
            i |= promote(a[3]);
            return i;
        }
        if (a.length == 2) {
            i |= promote(a[0]) << 8;
            i |= promote(a[1]);
            return i;
        }
        throw new IllegalArgumentException("a.length should be either 4 or 2.");
    }

    public static int build(byte b3, byte b2, byte b1, byte b0) {
        int i = 0;
        i |= promote(b3) << 24;
        i |= promote(b2) << 16;
        i |= promote(b1) << 8;
        i |= promote(b0);
        return i;
    }
}
