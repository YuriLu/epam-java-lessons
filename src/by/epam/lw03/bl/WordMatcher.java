package by.epam.lw03.bl;

import by.epam.lw03.text.document.Document;
import by.epam.lw03.text.paragraph.Sentence;
import by.epam.lw03.text.sentence.Word;

import java.util.List;

/**
 * 3. Найти такое слово в первом предложении, которого нет ни в одном
 * из остальных предложений.
 */
public class WordMatcher {

    public void process(Document document) {
        List<Sentence> sentences = document.getSentences();
        Sentence first = sentences.get(0);

        for (Word word : first.getWords()) {
            if (searchWord(word, sentences)) {
                System.out.println("WordMatcher: " + word);
            }
        }
    }

    private boolean searchWord(Word word, List<Sentence> sentences) {
        int index = 0;
        for (Sentence sentence : sentences) {
            if (index > 0) {
                for (Word currentWord : sentence.getWords()) {
                    if (currentWord.equals(word)) {
                        return false;
                    }
                }
            }
            index++;
        }

        return true;
    }

}
