package task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FromFile {

    private final List<String> headers;

    private final Map<String, Integer> headerIndices;

    private final String[][] cells;

    private final int rows;

    private final int columns;

    public FromFile(List<String> headers, String[][] cells, int rows, int columns) {
        this.cells = cells;
        this.rows = rows;
        this.columns = columns;
        this.headers = Collections.unmodifiableList(headers);
        Map<String, Integer> headerIndices = new HashMap<>(headers.size());
        int index = 0;
        for (String header : headers) {
            headerIndices.put(header, index++);
        }
        this.headerIndices = headerIndices;
    }


    public int height() {
        return rows;
    }

    public int width() {
        return columns;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<String> getRow(int row) {
        return Collections.unmodifiableList(Arrays.asList(cells[row]));
    }

    public String get(int row, int col) {
        return cells[row][col];
    }

    public String get(int row, String col) {
        return cells[row][headerIndices.get(col)];
    }

    public static Optional<FromFile> fromFile(Path path) throws IOException {
        var lines = Files.readAllLines(path);
        return fromLines(lines);
    }

    public static Optional<FromFile> fromLines(List<String> lines) {
        if (lines == null || lines.isEmpty()) return Optional.empty();

        var iterator = lines.iterator();

        var headers = split(iterator.next());

        int columns = headers.size();

        int rows = lines.size() - 1;

        String[][] cells = new String[rows][];

        for (int row = 0; iterator.hasNext(); row++) {
            cells[row] = split(iterator.next(), columns);
        }

        return Optional.of(new FromFile(headers, cells, rows, columns));
    }


    private static List<String> split(String csvRow) {
        List<String> row = new ArrayList<>();
        for (int end = 0, start = 0, length = csvRow.length(); end < length; end++) {
            if (csvRow.charAt(end) == ',') {
                row.add(start == end ? "" : csvRow.substring(start, end));
                start = end + 1;
            }
        }
        return row;
    }

    private static String[] split(String csvRow, int limit) {
        String[] row = new String[limit];
        for (int count = 0, start = 0, end = 0, length = csvRow.length(); end < length && count < limit; end++) {
            if (csvRow.charAt(end) == ',') {
                row[count++] = start == end ? "" : csvRow.substring(start, end);
                start = end + 1;
            }
        }
        return row;
    }

    public static void main(String[] args) throws IOException {
     fromFile(Paths.get("C:/alevel-java-nix/modul2/src/main/java/task3/input.txt"));
    }
}
  /*  List<String> city;
    int n;
    int index=0;
    List<Integer> to;
    List<Integer> weight;


    public void fromf(String filename){

    }
    public static Optional<CsvTable> fromFile(Path path) throws IOException {
        var lines = Files.readAllLines(path);
        return fromLines(lines);
    }

    public static Optional<CsvTable> fromLines(List<String> lines) {
        if (lines == null || lines.isEmpty()) return Optional.empty();

        var iterator = lines.iterator();

        var headers = split(iterator.next());

        int columns = headers.size();

        int rows = lines.size() - 1;

        String[][] cells = new String[rows][];

        for (int row = 0; iterator.hasNext(); row++) {
            cells[row] = split(iterator.next(), columns);
        }

        return Optional.of(new CsvTable(headers, cells, rows, columns));
    }




























































    void readFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(" ");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                System.out.println(n);
            }
            if(scanner.hasNextLine()){
                city.add(scanner.nextLine());
                System.out.println(scanner.nextLine());
                index++;
                System.out.println(index);
            }
            if (scanner.hasNextInt()){
                for(int i=0; i< scanner.nextInt(); i++){

                }
            }

        }
        scanner.close();
    }

   public void writeToFile(String fileName, Object obj) throws IOException {
       PrintWriter out = new PrintWriter(new FileWriter(fileName));
           out.println(obj);
       out.close();
   }
}*/
