package by.epam.lw03.text;

/**
 */
public interface Factory<T> {

    public T factory(String type, String text) throws Exception;

}
