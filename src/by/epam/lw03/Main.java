package by.epam.lw03;

import by.epam.lw03.bl.WordMatcher;
import by.epam.lw03.bl.WordShuffle;
import by.epam.lw03.parser.ParseException;
import by.epam.lw03.parser.Parser;
import by.epam.lw03.parser.ParserFactory;
import by.epam.lw03.text.document.Document;
import by.epam.lw03.text.document.DocumentPart;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 */
public class Main {

    private static String process(List<String> lines) throws ParseException {
        String text = "";

        for (String line : lines) {
            text += line + '\n';
        }

        ParserFactory factory = new ParserFactory();

        Parser<DocumentPart> documentParser = factory.documentParser();
        List<DocumentPart> parts = documentParser.parse(text);
        Document document = new Document(parts);


        WordMatcher matcher = new WordMatcher();
        WordShuffle shuffle = new WordShuffle();

        matcher.process(document);
        shuffle.process(document);

        return document.toString();
    }

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String path = "lw03.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            String result = process(lines);
            PrintWriter writer = new PrintWriter("lw03.res.txt");
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
