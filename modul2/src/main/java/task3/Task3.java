package task3;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.String.format;

public class Task3 {
    public Edge e;

    public void floid(int[][] weights, int n, int from, int to) throws IOException {
        int result;
        double[][] dist = new double[n][n];
        for (double[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int[] w : weights)
            dist[w[0] - 1][w[1] - 1] = w[2];

        int[][] next = new int[n][n];
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++)
                if (i != j)
                    next[i][j] = j + 1;
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
        result = (int) dist[from - 1][to - 1];
        printResult("C:\\alevel-java-nix\\modul2\\src\\main\\java\\task3\\output.txt", result);
    }

    void printResult(String fileName, int res) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        PrintWriter writer = new PrintWriter(fw);
        writer.println(res);
        writer.close();
    }

    public Map<String, List<Edge>> fromFile(String filename) throws FileNotFoundException {//"C:/alevel-java-nix/modul2/src/main/java/task3/input.txt"
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int index = 0;
        int n = Integer.parseInt(sc.nextLine());
        ArrayList city = new ArrayList<String>();
        Map<String, List<Edge>> map = new LinkedHashMap<>();
        while (index < n) {
            String s = sc.nextLine();
            city.add(s);
            int size = Integer.parseInt(sc.nextLine());
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String str = sc.nextLine();
                String[] strs = str.trim().split("\\s");
                int to = Integer.parseInt(strs[0]);
                int weight = Integer.parseInt(strs[1]);
                edges.add(new Edge(city.size(), to, weight));
            }
            map.put((String) city.get(index), (List<Edge>) edges);
            index++;
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        Edge e;
        Task3 c = new Task3();
        Map<String, List<Edge>> map = new LinkedHashMap<>();
        int[][] weights = {{1, 2, 1}, {1, 3, 3}, {2, 4, 4}, {2, 3, 1}, {3, 4, 1}};
        int numVertices = 4;
        c.floid(weights, numVertices, 1, 4);
        c.floid(weights, numVertices, 2, 4);

        map = c.fromFile("C:/alevel-java-nix/modul2/src/main/java/task3/input.txt");
        //   System.out.println(map.entrySet());

    }

}


