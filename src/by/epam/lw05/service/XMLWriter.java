package by.epam.lw05.service;

import by.epam.lw05.entity.Tariff;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * by.epam.lw05.service
 * <p/>
 * Version 1.0
 * <p/>
 * Copyright Evgeny Shpilevsky
 */
public class XMLWriter {

    public static void write(String path, List<Tariff> list) throws WriteException {
        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element rootElement = document.createElement("tariffs");
            document.appendChild(rootElement);

            for (Tariff tariff : list) {
                Element tariffElement = document.createElement("tariff");
                rootElement.appendChild(tariffElement);

                Element id = document.createElement("id");
                id.appendChild(document.createTextNode(String.valueOf(tariff.getID())));
                tariffElement.appendChild(id);

                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(tariff.getTitle()));
                tariffElement.appendChild(title);

                Element type = document.createElement("type");
                type.appendChild(document.createTextNode(tariff.getType()));
                tariffElement.appendChild(type);

                Element active = document.createElement("active");
                active.appendChild(document.createTextNode(String.valueOf(tariff.isActive())));
                tariffElement.appendChild(active);

                Element started = document.createElement("started");
                started.appendChild(document.createTextNode(tariff.getStarted().toString()));
                tariffElement.appendChild(started);

                Element price = document.createElement("price");
                price.appendChild(document.createTextNode(String.valueOf(tariff.getPrice())));
                tariffElement.appendChild(price);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);
        } catch (Exception e) {
            throw new WriteException("cannot write xml", e);
        }

    }

}
