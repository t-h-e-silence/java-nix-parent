package finance;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    public Menu() {

    }
    private Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("src//main//resources//DBtoCSV.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }

    public void run(){
        String choice=null;
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("-------Menu-------");
            System.out.println("1) Add new Operation");
            System.out.println("2) Export to CSV");
            choice=scanner.nextLine();
            switch (choice){
                case "1":


                    break;
                case "2":
                    DBtoCSV export=new DBtoCSV();
                    Properties prop=loadProperties();
                    String url = prop.getProperty("url");
                        export.dbToCSV(prop, url);
                break;
                default:
                    break;
            }

        }
    }

}
