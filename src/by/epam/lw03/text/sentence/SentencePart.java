package by.epam.lw03.text.sentence;

/**
 */
public class SentencePart {

    protected String text;

    public SentencePart(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
