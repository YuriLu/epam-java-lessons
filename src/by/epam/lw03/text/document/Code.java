package by.epam.lw03.text.document;

/**
 */
public class Code implements DocumentPart {

    private String text;

    public Code(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        return ((Code) obj).text.equals(text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }



}
