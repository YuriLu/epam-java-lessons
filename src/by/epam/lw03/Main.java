package by.epam.lw03;

import by.epam.lw03.bl.WordMatcher;
import by.epam.lw03.bl.WordShuffle;
import by.epam.lw03.parser.Parser;
import by.epam.lw03.parser.ParserFactory;
import by.epam.lw03.text.document.Document;
import by.epam.lw03.text.document.DocumentPart;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 */
public class Main {

    private static void buildTree(List<String> lines) {
        String text = "";

        for (String line : lines) {
            text += line + '\n';
        }

        ParserFactory factory = new ParserFactory();

        try {
            Parser<DocumentPart> documentParser = factory.documentParser();
            List<DocumentPart> parts = documentParser.parse(text);
            Document document = new Document(parts);


            WordMatcher matcher = new WordMatcher();
            WordShuffle shuffle = new WordShuffle();

            matcher.process(document);
            shuffle.process(document);

            System.out.println(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String path = "lw03.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            buildTree(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
