package by.epam.lw03.parser;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Parser<T> {

    private RegExpChain<T> chain;

    public Parser(RegExpChain<T> chain) {
        this.chain = chain;
    }

    public List<T> parse(String text) throws ParseException {
        Buffer buffer = new Buffer(text);
        List<T> list = new LinkedList<T>();

        while (!buffer.isEmpty()) {
            T textPart = chain.nextPart(buffer);
            list.add(textPart);
        }

        return list;
    }

}
