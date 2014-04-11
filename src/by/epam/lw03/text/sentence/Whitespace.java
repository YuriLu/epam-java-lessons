package by.epam.lw03.text.sentence;

/**
 */
public class Whitespace implements SentencePart {
    private String text;

    public Whitespace(String text) {
        this.text = text;
    }

    @Override
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

        return ((Whitespace) obj).text.equals(text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
