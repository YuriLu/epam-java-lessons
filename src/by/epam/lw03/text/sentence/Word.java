package by.epam.lw03.text.sentence;

/**
 */
public class Word extends SentencePart {
    public static final String ID = "word";

    public Word(String text) {
        super(text);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Word)) {
            return super.equals(obj);
        }

        return ((Word) obj).text.equals(text);
    }
}
