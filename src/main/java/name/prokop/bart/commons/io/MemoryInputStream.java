package name.prokop.bart.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import name.prokop.bart.commons.bits.IntegerBits;

public class MemoryInputStream extends InputStream implements Serializable {

    private final byte[] source;
    private int pos = 0;

    public MemoryInputStream(final byte[] source) {
        this.source = source;
    }

    @Override
    public synchronized int read() throws IOException {
        if (pos == source.length) {
            return -1;
        }
        return IntegerBits.promote(source[pos++]);
    }

}
