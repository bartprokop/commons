package name.prokop.bart.commons.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;


public class MemoryOutputStream extends OutputStream implements Serializable {

    private int size = 0;

    @Override
    public void write(int b) throws IOException {
        size++;
    }

    public int getSize() {
        return size;
    }

}
