package by.epam.lw05;

import by.epam.lw05.entity.Tariff;
import by.epam.lw05.service.DatabaseReader;
import by.epam.lw05.service.XMLReader;
import by.epam.lw05.service.XMLWriter;
import by.epam.lw05.thread.ThreadPool;
import by.epam.lw05.thread.Workload;

import java.util.List;

/**
 */
public class Main {

    /**
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(2);
        pool.addWorkload(new Workload() {
            @Override
            public void run() throws Exception {
                List<Tariff> list = XMLReader.readXML("src/by/epam/lw05/file.xml");

                for (Tariff tariff : list) {
                    System.out.println(tariff);
                }
            }
        });

        pool.addWorkload(new Workload() {
            @Override
            public void run() throws Exception {
                List<Tariff> list = DatabaseReader.read();
                XMLWriter.write("src/by/epam/lw05/output.xml", list);
            }
        });

        pool.waitAndStop();
        System.out.println("Complete");
    }
}
