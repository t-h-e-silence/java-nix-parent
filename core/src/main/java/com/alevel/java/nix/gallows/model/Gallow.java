package com.alevel.java.nix.gallows.model;

import com.alevel.java.nix.gallows.view.TurnResultView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Gallow implements GallowInt {
    private TurnResultView cachedView = createView();
    private TurnResult previousTurnResult = TurnResult.CONTINUE;
    private String word;
    private String buff = null;
    public int attempt = 10;



    public Gallow() throws IOException {
        this.word = readFromFile();
        this.buff = initEmpty();
    }

    public int getAttempt() {
        return attempt;
    }
    public String getBuff() {
        return buff;
    }

    public String getWord() {
        return word;
    }

    public String readFromFile() throws IOException {
        String filename = "C://alevel-java-nix//core//resources//words.csv";
        List<String> words;
        words = Files.lines(Paths.get(filename))
                .flatMap(String::lines)
                .collect(Collectors.toList());
        return word = words.get(randomNum(words.size()));
    }


    public String initEmpty() {
        char[] buffer = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            buffer[i] = ' ';
        }
        return buff = String.valueOf(buffer);
    }


    private int randomNum(int size) {
        return (int) (Math.random() * (size - 1));
    }

    public TurnResult isWin() {
        if (buff.equals(word) && attempt > 0) {
            return TurnResult.YOU_WON;
        }
        if (attempt <= 0 && buff.equals(word) || attempt <= 0) {
            return TurnResult.YOU_LOSE;
        }
        return TurnResult.CONTINUE;
    }


    public void reset() throws IOException {
        buff = initEmpty();
        word = readFromFile();
        attempt = 10;
        previousTurnResult = TurnResult.CONTINUE;
        cachedView = createView();
    }

    public TurnResultView view() {
        return cachedView;
    }

    private TurnResultView createView() {
        var nl = System.lineSeparator();
        var view = new StringBuilder();
        if (buff != null) {
            for (int i = 0; i < buff.length(); i++) {
                view.append(buff.charAt(i));
            }
            view.append(nl);
            view.append("У вас осталось  ").append(attempt).append(" попыток");
        }

        return new TurnResultView(previousTurnResult, view.toString());
    }

    public TurnResultView symbol(char s) {
        boolean isRight = false;
        if (previousTurnResult != TurnResult.CONTINUE) {
            return cachedView;
        }
        if (buff.indexOf(s) != -1) {
            isRight = true;
        }
        isRight = false;
        char[] temp = buff.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == s) {
                temp[i] = s;
                isRight = true;
            }
        }
        if (!isRight) {
            attempt = attempt - 1;
        }
        buff = String.valueOf(temp);
        previousTurnResult = isWin();
        cachedView = createView();
        return cachedView;
    }

}
