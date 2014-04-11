package by.epam.lw03.text.paragraph;

import by.epam.lw03.parser.ParseException;
import by.epam.lw03.parser.ParserFactory;
import by.epam.lw03.text.sentence.SentencePart;
import by.epam.lw03.text.sentence.Word;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Sentence implements ParagraphPart {
    private List<SentencePart> parts;

    public Sentence(String text) throws ParseException {
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

        return ((Sentence) obj).parts.equals(parts);
    }

    @Override
    public int hashCode() {
        return parts.hashCode();
    }

}
