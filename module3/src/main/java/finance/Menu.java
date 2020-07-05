package finance;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    public Menu() {

    }

    private Properties loadProperties() {
        String PATH_TO_PROPERTIES = "module3/src/main/resources/DBtoCSV.properties";
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            return prop;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public void run() {
        String choice = null;
        Scanner scanner = new Scanner(System.in);
        Properties prop = loadProperties();
        String url = prop.getProperty("url");
        while (true) {
            System.out.println("-------Menu-------");
            System.out.println("1) Add new Operation");
            System.out.println("2) Export to CSV");
            System.out.println("0) Exit");
            choice = scanner.nextLine();
            switch (choice) {

                case "1":
                    AddNewOperation adding = new AddNewOperation();

                    System.out.println(" Enter id of desired user: ");
                    int userId = scanner.nextInt();
                    adding.setUserId(userId);
                    adding.accountsList(userId);
                    System.out.println(" Enter id of desired account: ");
                    int accountId = scanner.nextInt();
                    adding.setAccountId(accountId);
                    System.out.println("Add new operation.");
                    System.out.println("Enter operation name: ");
                    String operationName = scanner.nextLine();
                    System.out.println("Enter operation cost: ");
                    Double cost = scanner.nextDouble();
                    System.out.println("If its income operation press 1 ");
                    String type = scanner.nextLine();
                    boolean profit = false;
                    if (type.equals("1")) {
                        profit = true;
                    }
                    System.out.println("Enter category name: ");
                    String category = scanner.nextLine();
                    adding.addOperation(accountId, operationName, profit, cost, category);
                    break;

                case "2":

                    DBtoCSV export = new DBtoCSV();
                    System.out.println(" Enter id of desired account: ");
                    int id = scanner.nextInt();
                    export.dbToCSV(prop, url, id);
                    break;

                case "0":
                    System.exit(0);
                default:
                    break;
            }

        }
    }

}
