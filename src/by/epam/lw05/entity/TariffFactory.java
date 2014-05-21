package by.epam.lw05.entity;

import org.w3c.dom.Element;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 */
public class TariffFactory {

    public static Tariff factory(Element node) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Tariff tariff = new Tariff();

        tariff.setID(Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent()));
        tariff.setPrice(Integer.parseInt(node.getElementsByTagName("price").item(0).getTextContent()));
        tariff.setTitle(node.getElementsByTagName("title").item(0).getTextContent());
        tariff.setType(node.getElementsByTagName("type").item(0).getTextContent());
        tariff.setActive("true".equals(node.getElementsByTagName("active").item(0).getTextContent()));

        try {
            tariff.setStarted(simpleDateFormat.parse(node.getElementsByTagName("started").item(0).getTextContent()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return tariff;
    }

    public static Tariff factory(ResultSet resultSet) {
        Tariff tariff = new Tariff();

        try {
            tariff.setID(resultSet.getInt(1));
            tariff.setTitle(resultSet.getString(2));
            tariff.setType(resultSet.getString(3));
            tariff.setStarted(resultSet.getDate(4));
            tariff.setActive(resultSet.getBoolean(5));
            tariff.setPrice(resultSet.getInt(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tariff;
    }

}
