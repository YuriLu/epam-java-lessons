package by.epam.lw03.text.sentence;

/**
 */
public class Punctuation implements SentencePart {

    private String text;

    public Punctuation(String text) {
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

        return ((Punctuation) obj).text.equals(text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
