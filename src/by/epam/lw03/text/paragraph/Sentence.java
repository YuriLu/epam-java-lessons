package by.epam.lw03.text.paragraph;

import by.epam.lw03.parser.ParseException;
import by.epam.lw03.parser.ParserFactory;
import by.epam.lw03.text.sentence.SentencePart;
import by.epam.lw03.text.sentence.Word;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Sentence extends ParagraphPart {
    public final static String ID = "sentence";
    List<SentencePart> parts;

    public Sentence(String text) throws ParseException {
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

    public List<Word> getWords() {
        List<Word> list = new LinkedList<Word>();

        for (SentencePart part : parts) {
            if (part instanceof Word) {
                list.add((Word) part);
            }
        }

        return list;
    }

    public List<SentencePart> getParts() {
        return parts;
    }
}
