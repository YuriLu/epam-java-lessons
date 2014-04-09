package by.epam.lw03.text.document;

/**
 */
public class Code extends DocumentPart {

    public final static String ID = "code";

    public Code(String text) {
        super(text);
    }

    public String toString() {
        return text;
    }

}
