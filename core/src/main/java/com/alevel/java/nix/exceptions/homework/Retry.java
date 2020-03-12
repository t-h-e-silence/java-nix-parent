package com.alevel.java.nix.exceptions.homework;

import com.alevel.java.nix.exceptions.ArithmeticProgression;
import com.alevel.java.nix.exceptions.ProgressionConfigurationException;
import com.alevel.java.nix.leetcodepractice.LongestCommonPrefix;
import com.alevel.java.nix.tictachomework.TicTacToe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Retry implements Block {
    public Logger log = LoggerFactory.getLogger(Retry.class);
    int times;
    int already = 0;
    int n;
    int init;
    int step;
    int res;

    public Retry(int times) {
        this.times = times;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getCalc() {
        return res;
    }


    public void run() throws Exception {
        while (already < times) {
            try {
                already++;
                ArithmeticProgression a = new ArithmeticProgression(init, step);
                res = a.calculate(n);
                log.info("Operation is done, n: " + n);
            } catch (ProgressionConfigurationException p) {
                if (n <= 0) {
                    n++;
                }
                log.warn("Wrong parametrs! ");
                Thread.sleep(sleepTime(1000, already));
            }
        }

    }

    public static long sleepTime(long millis, int already) throws InterruptedException {
        return millis * already;
    }
}

