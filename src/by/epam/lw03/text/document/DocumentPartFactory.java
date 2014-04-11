package by.epam.lw03.text.document;

import by.epam.lw03.parser.ParseException;
import by.epam.lw03.text.Factory;
import by.epam.lw03.text.paragraph.Paragraph;

/**
 */
public class DocumentPartFactory implements Factory<DocumentPart> {

    @Override
    public DocumentPart factory(Class type, String text) throws ParseException {
        if (Code.class.equals(type)) {
            return new Code(text);
        }

        if (Paragraph.class.equals(type)) {
            return new Paragraph(text);
        }

        throw new ParseException("Cannot create document part");
    }

}
