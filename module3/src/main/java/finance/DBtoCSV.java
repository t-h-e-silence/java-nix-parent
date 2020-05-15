package finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBtoCSV {

    private static final Logger logger = LoggerFactory.getLogger(DBtoCSV.class);

    public DBtoCSV() {
    }

   public  void dbToCSV(Properties props, String url, int id) {
        String csvFilePath = "DBtoCSV.csv";
        try (Connection connection = DriverManager.getConnection(url, props)) {
            logger.info("Start creating .csv file\n");
            String sql = String.format("select operations.operationid as oi, cost as c, name as n, created_at as ca, account_id as ai from operations where  account_id = %d ", id);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath))) {
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
                logger.info(".csv file successfully created\n");
            }
        } catch (Exception e) {
            logger.error("Error", e);
            e.printStackTrace();
        }
    }
}
