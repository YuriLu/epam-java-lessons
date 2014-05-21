package by.epam.lw05.service;

import by.epam.lw05.entity.Tariff;
import by.epam.lw05.entity.TariffFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 */
public class DatabaseReader {

    public static List<Tariff> read() {
        List<Tariff> list = new LinkedList<Tariff>();

        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epam-web", properties);
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("select * from tariffs");

            while (resultSet.next()) {
                list.add(TariffFactory.factory(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
