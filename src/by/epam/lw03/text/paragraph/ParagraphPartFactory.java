package by.epam.lw03.text.paragraph;

import by.epam.lw03.text.Factory;

/**
 */
public class ParagraphPartFactory implements Factory<ParagraphPart> {
    @Override
    public ParagraphPart factory(String type, String text) throws Exception {
        if (Sentence.ID.equals(type)) {
            return new Sentence(text);
        }

        throw new Exception("Cannot create paragraph part");
    }
}
