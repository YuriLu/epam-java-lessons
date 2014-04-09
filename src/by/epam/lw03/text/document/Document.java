package by.epam.lw03.text.document;

import by.epam.lw03.text.paragraph.Paragraph;
import by.epam.lw03.text.paragraph.Sentence;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Document {

    private List<DocumentPart> parts;

    public Document(List<DocumentPart> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        String result = "";

        for (DocumentPart part : parts) {
            result += part;
        }

        return result;
    }

    public List<Paragraph> getParagraphs() {
        List<Paragraph> list = new LinkedList<Paragraph>();

        for (DocumentPart part : parts) {
            if (part instanceof Paragraph) {
                list.add((Paragraph) part);
            }
        }

        return list;
    }

    public List<Sentence> getSentences() {
        List<Sentence> list = new LinkedList<Sentence>();

        for (Paragraph paragraph : getParagraphs()) {
            list.addAll(paragraph.getSentences());
        }

        return list;
    }
}
