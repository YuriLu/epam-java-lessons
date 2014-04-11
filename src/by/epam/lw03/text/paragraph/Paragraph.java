package by.epam.lw03.text.paragraph;

import by.epam.lw03.parser.ParseException;
import by.epam.lw03.parser.ParserFactory;
import by.epam.lw03.text.document.DocumentPart;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Paragraph implements DocumentPart {

    private List<ParagraphPart> parts;

    public Paragraph(String text) throws ParseException {
        ParserFactory factory = new ParserFactory();
        parts = factory.paragraphParser().parse(text);
    }

    public String toString() {
        String result = "";

        for (ParagraphPart part : parts) {
            result += part;
        }

        return result;
    }

    public List<Sentence> getSentences() {
        List<Sentence> list = new LinkedList<Sentence>();

        for (ParagraphPart part : parts) {
            if (part instanceof Sentence) {
                list.add((Sentence) part);
            }
        }

        return list;
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

        return ((Paragraph) obj).parts.equals(parts);
    }

    @Override
    public int hashCode() {
        return parts.hashCode();
    }
}
