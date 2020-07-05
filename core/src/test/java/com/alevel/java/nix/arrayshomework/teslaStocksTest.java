package com.alevel.java.nix.arrayshomework;

import com.alevel.java.nix.arrayshomework.TeslaStocks;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;

import static org.junit.jupiter.api.Assertions.*;

class teslaStocksTest {

    @Test
    void getTheDay() {
        double[] mas = {12.3, 7.8, 6.0, 14, 12.3, 105.5, 34.5};

        TeslaStocks t = new TeslaStocks(mas);
        String ans = t.getTheDay();
        assertEquals("День покупки " + 3 + " День продажи " + 6 + " Разница в цене " + 99.5, ans);
        System.out.println(ans);
        TeslaStocks t1 = new TeslaStocks();
        String ans1 = t1.getTheDay();
        assertEquals("День покупки " + 1 + " День продажи " + 7 + " Разница в цене " + 6.0, ans1);
    }
}