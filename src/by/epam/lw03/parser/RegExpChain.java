package by.epam.lw03.parser;

import by.epam.lw03.text.Factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class RegExpChain<T> {

    private Pattern pattern;
    private Class type;
    private RegExpChain<T> next;
    private Factory<T> factory;

    public RegExpChain(String expression, Class type, Factory<T> factory) {
        this.pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        this.type = type;
        this.factory = factory;
    }

    public T nextPart(Buffer buffer) throws ParseException {
        Matcher m = pattern.matcher(buffer.getText());
        if (m.find()) {
            String match = m.group();
            buffer.skip(match.length());
            return factory.factory(type, match);
        } else {
            if (next != null) {
                return next.nextPart(buffer);
            } else {
                throw new ParseException("Cannot parse anymore");
            }
        }
    }

    public RegExpChain createNext(String expression, Class type) {
        return next = new RegExpChain<T>(expression, type, factory);
    }
}
