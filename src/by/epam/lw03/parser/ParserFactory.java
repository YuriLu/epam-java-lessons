package by.epam.lw03.parser;

import by.epam.lw03.text.Factory;
import by.epam.lw03.text.document.Code;
import by.epam.lw03.text.document.DocumentPart;
import by.epam.lw03.text.document.DocumentPartFactory;
import by.epam.lw03.text.paragraph.Paragraph;
import by.epam.lw03.text.paragraph.ParagraphPart;
import by.epam.lw03.text.paragraph.ParagraphPartFactory;
import by.epam.lw03.text.paragraph.Sentence;
import by.epam.lw03.text.sentence.*;

import java.util.ResourceBundle;

/**
 */
public class ParserFactory {
    private ResourceBundle bundle = ResourceBundle.getBundle("main");

    public Parser<DocumentPart> documentParser() {
        String codePattern = bundle.getString("lw03.codePattern");
        String paragraphPattern = bundle.getString("lw03.paragraphPattern");

        Factory<DocumentPart> factory = new DocumentPartFactory();
        RegExpChain<DocumentPart> chain = new RegExpChain<DocumentPart>(codePattern, Code.class, factory);
        chain.createNext(paragraphPattern, Paragraph.class);

        return new Parser<DocumentPart>(chain);
    }

    public Parser<ParagraphPart> paragraphParser() {
        String sentencePattern = bundle.getString("lw03.sentencePattern");

        Factory<ParagraphPart> factory = new ParagraphPartFactory();
        RegExpChain<ParagraphPart> chain = new RegExpChain<ParagraphPart>(sentencePattern, Sentence.class, factory);

        return new Parser<ParagraphPart>(chain);
    }

    public Parser<SentencePart> sentenceParser() {
        String whitespace = bundle.getString("lw03.whitespacePattern");
        String punctuation = bundle.getString("lw03.punctuationPattern");
        String word = bundle.getString("lw03.wordPattern");

        Factory<SentencePart> factory = new SentenceFactory();
        RegExpChain<SentencePart> chain = new RegExpChain<SentencePart>(word, Word.class, factory);
        chain.createNext(punctuation, Punctuation.class)
                .createNext(whitespace, Whitespace.class);

        return new Parser<SentencePart>(chain);
    }

}
