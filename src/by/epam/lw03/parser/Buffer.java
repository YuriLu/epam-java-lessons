package by.epam.lw03.parser;

/**
 */
public class Buffer {

    private String buffer;

    public Buffer(String buffer) {
        this.buffer = buffer;
    }

    public String getText() {
        return buffer;
    }

    public void skip(int position) {
        buffer = buffer.substring(position);
    }

    public boolean isEmpty() {
        return buffer.length() == 0;
    }
}
