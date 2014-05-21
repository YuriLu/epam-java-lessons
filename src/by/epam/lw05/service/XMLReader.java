package by.epam.lw05.service;

import by.epam.lw05.entity.Tariff;
import by.epam.lw05.entity.TariffFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class XMLReader {

    public static List<Tariff> readXML(String file) throws ReadException {
        System.out.println(file);

        File xmlFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("tariff");
            List<Tariff> list = new LinkedList<Tariff>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                list.add(TariffFactory.factory((Element) nodeList.item(i)));
            }

            return list;
        } catch (Exception e) {
            throw new ReadException("Cannot read", e);
        }

    }

}
