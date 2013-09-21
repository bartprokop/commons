package name.prokop.bart.commons.crc;

import name.prokop.bart.commons.bits.ByteBits;
import name.prokop.bart.commons.bits.CharBits;
import name.prokop.bart.commons.bits.IntegerBits;
import name.prokop.bart.commons.bits.Word16bit;

/**
 *
 * @author bart
 */
public class Fletcher16 {

    public static Word16bit fletcher16(byte[] data) {
        Word16bit check = new Word16bit();

        char sum1 = 0xff, sum2 = 0xff;

        int len = data.length;
        int i = 0;

        while (len > 0) {
            int tlen = len > 21 ? 21 : len;
            len -= tlen;
            do {
                sum1 += CharBits.promote(data[i++]);
                sum2 += sum1;
            } while (--tlen > 0);
            sum1 = CharBits.narrow((sum1 & 0xff) + (IntegerBits.promote(sum1) >> 8));
            sum2 = CharBits.narrow((sum2 & 0xff) + (IntegerBits.promote(sum2) >> 8));
        }
        /* Second reduction step to reduce sums to 8 bits */
        sum1 = CharBits.narrow((sum1 & 0xff) + (IntegerBits.promote(sum1) >> 8));
        sum2 = CharBits.narrow((sum2 & 0xff) + (IntegerBits.promote(sum2) >> 8));
        check.setHigh(ByteBits.narrow(sum1));
        check.setLow(ByteBits.narrow(sum2));

        return check;
    }

    public static void main(String[] args) {
        Word16bit w = fletcher16("12345678900987654321qazswedxsdcvfgbvfgtrfghjklijuh".getBytes());
        System.out.println(w.getHighAsInt() + ":" + w.getLowAsInt());
    }
}
