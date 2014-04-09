package by.epam.lw03.text.document;

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
}
