package com.alevel.java.nix.arrayshomework;

public class TeslaStocks {

    static double[] arr = new double[7];

    TeslaStocks() {
         arr= new double[]{1, 2, 3, 4, 5, 6, 7};
    }

    TeslaStocks(double[] arr) {
        this.arr = arr;
    }

    public String getTheDay() {
        double temp = 0;
        int buy = 0, sale = 0;
        for (int i = 0, j = 0, length = arr.length; i < length; i++) {
            double min = arr[i], max = arr[j], range = 0;
            if (min < max) {
                j = i;
            } else {
                    range = arr[i] - arr[j];
                    if (temp < range) {
                        temp = range;
                        sale = i + 1;
                         buy  = j + 1;
                }
            }
        }
                return "День покупки " + buy + " День продажи " + sale + " Разница в цене " + temp;
    }

}
