package by.epam.lw03.text.paragraph;

import by.epam.lw03.parser.ParseException;
import by.epam.lw03.text.Factory;

/**
 */
public class ParagraphPartFactory implements Factory<ParagraphPart> {
    @Override
    public ParagraphPart factory(Class type, String text) throws ParseException {
        if (Sentence.class.equals(type)) {
            return new Sentence(text);
        }

        throw new ParseException("Cannot create paragraph part");
    }
}
