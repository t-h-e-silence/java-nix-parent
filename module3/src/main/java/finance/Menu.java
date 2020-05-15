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
        try(  FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            return prop;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

        public void run(){
        String choice=null;
        Scanner scanner=new Scanner(System.in);
        Properties prop=loadProperties();
        String url = prop.getProperty("url");
        while(true){
            System.out.println("-------chande.Menu-------");
            System.out.println("1) Add new Operation");
            System.out.println("2) Export to CSV");
            System.out.println("0) Exit");
            choice=scanner.nextLine();
            switch (choice){
                case "1":


                    break;
                case "2":
                    DBtoCSV export=new DBtoCSV();
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
