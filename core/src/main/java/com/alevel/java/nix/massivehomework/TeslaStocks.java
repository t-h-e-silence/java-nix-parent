package com.alevel.java.nix.massivehomework;

public class TeslaStocks {

    static double[] mas = new double[7];

    TeslaStocks() {
        mas = new double[]{1, 2, 3, 4, 5, 6, 7};
    }

    TeslaStocks(double[] mas) {
        this.mas = mas;
    }

    public String getTheDay() {
        double temp = 0;
        int buy = 0, sale = 0;
        for (int i = 0, length = mas.length; i < length; i++) {
            double min = 0, max = 0, range = 0;
            for (int j = 0, nlength = mas.length; j < length; j++) {
                if (max < mas[j]) {
                    max = mas[j];
                }
                if (i < j) {
                    range = mas[j] - mas[i];
                    if (temp < range) {
                        temp = range;
                        buy = i + 1;
                        sale = j + 1;
                    }
                }
            }
        }
        return "День покупки " + buy + " День продажи " + sale + " Разница в цене " + temp;
    }

}
