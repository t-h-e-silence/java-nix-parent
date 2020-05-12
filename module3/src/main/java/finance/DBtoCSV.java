package finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.Properties;
public class DBtoCSV {
    private static final Logger logger = LoggerFactory.getLogger(DBtoCSV.class);

    public static void main(String[] args) throws SQLException {
        String csvFilePath = "operations.csv";
        Properties props = loadProperties();
        String url = props.getProperty("url");
        try (Connection connection = DriverManager.getConnection(url, props)) {
            int id=0;
            String sql = String.format("select operation_id as oi, cost as c, name as n, created_at as ca, account_id as ai from operations where  account_id = %d ", id);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            fileWriter.write("account_id, operation_id, cost, name, timestamp");

            while (result.next()) {
                Integer account_id = result.getInt("ai");
                Integer operation_id = result.getInt("oi");
                float cost = result.getFloat("c");
                Timestamp timestamp = result.getTimestamp("ca");
                String name = result.getString("n");

                String line = String.format("\"%s\",%s,%.1f,%s,%s",
                        account_id, operation_id, cost, timestamp, name);
                fileWriter.newLine();
                fileWriter.write(line);
            }
            statement.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Datababse error:");
            e.printStackTrace();

        }
    }


    private static Properties loadProperties () {
        Properties props = new Properties();
        try (InputStream input = DBtoCSV.class.getResourceAsStream("DBtoCSV.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}
