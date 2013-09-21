package name.prokop.bart.commons.bits;

public class ByteBits {

    public static byte narrow(char c) {
        return (byte) (c & 0xFF);
    }

    public static byte narrow(int i) {
        i &= 0xFF;
        return (byte) i;
    }

    public static byte narrow(long i) {
        i &= 0xFF;
        return (byte) i;
    }

    /**
     * @param value
     * @param idx 0 for eight most right bits, 3 for most left bits
     * @return
     */
    public static byte extract(int value, int idx) {
        value = (value >> (8 * idx)) & 0xFF;
        return narrow(value);
    }

    public static byte extract(long value, int idx) {
        value = (value >> (8 * idx)) & 0xFF;
        return narrow(value);
    }
}
