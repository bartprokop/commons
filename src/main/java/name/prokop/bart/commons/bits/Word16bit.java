package name.prokop.bart.commons.bits;

/**
 *
 * @author Bartłomiej P. Prokop
 */
public class Word16bit {

    private byte high, low;

    public Word16bit() {
    }

    public Word16bit(byte high, byte low) {
        this.high = high;
        this.low = low;
    }

    public byte getHigh() {
        return high;
    }

    public int getHighAsInt() {
        return IntegerBits.promote(high);
    }

    public void setHigh(byte high) {
        this.high = high;
    }

    public byte getLow() {
        return low;
    }

    public int getLowAsInt() {
        return IntegerBits.promote(low);
    }

    public void setLow(byte low) {
        this.low = low;
    }
}
