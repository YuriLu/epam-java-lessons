package by.epam.lw03.bl;

import by.epam.lw03.text.document.Document;
import by.epam.lw03.text.paragraph.Sentence;
import by.epam.lw03.text.sentence.SentencePart;
import by.epam.lw03.text.sentence.Word;

import java.util.List;

/**
 * 4. В каждом предложении текста поменять местами первое слово с
 * последним, не изменяя длины предложения.
 */
public class WordShuffle {

    public void process(Document document) {
        List<Sentence> list = document.getSentences();

        for (Sentence sentence : list) {
            List<Word> words = sentence.getWords();
            if (words.size() > 2) {
                Word first = words.get(0);
                Word last = words.get(words.size() - 1);

                List<SentencePart> parts = sentence.getParts();

                int firstPosition = parts.indexOf(first);
                int lastPosition = parts.indexOf(last);

                parts.remove(lastPosition);
                parts.add(lastPosition, first);
                parts.remove(firstPosition);
                parts.add(firstPosition, last);

            }
        }
    }

}
