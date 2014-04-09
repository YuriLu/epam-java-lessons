package by.epam.lw03.text.paragraph;

import by.epam.lw03.parser.ParserFactory;
import by.epam.lw03.text.sentence.SentencePart;

import java.util.List;

/**
 */
public class Sentence extends ParagraphPart {
    public final static String ID = "sentence";
    List<SentencePart> parts;

    public Sentence(String text) throws Exception {
        super(text);
        ParserFactory factory = new ParserFactory();
        parts = factory.sentenceParser().parse(text);
    }

    public String toString() {
        String result = "";

        for (SentencePart part : parts) {
            result += part;
        }

        return result;
    }
}
