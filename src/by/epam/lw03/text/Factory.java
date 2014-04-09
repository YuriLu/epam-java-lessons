package by.epam.lw03.text;

import by.epam.lw03.parser.ParseException;

/**
 */
public interface Factory<T> {

    public T factory(String type, String text) throws ParseException;

}
