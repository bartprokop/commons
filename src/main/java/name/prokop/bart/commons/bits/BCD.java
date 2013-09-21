package name.prokop.bart.commons.bits;

public class BCD {

    public static byte encodeAsBCD(int a, int b) {
        byte r = ByteBits.narrow(b);
        r += 16 * ByteBits.narrow(a);
        return r;
    }
}
