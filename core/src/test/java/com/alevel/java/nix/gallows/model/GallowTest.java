package com.alevel.java.nix.gallows.model;

import com.alevel.java.nix.gallows.view.TurnResultView;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;

import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GallowTest {

   Gallow gallow=new Gallow();
    GallowTest() throws IOException {
    }



    @Test
    void getAttempt() throws IOException {
        assertEquals(10, gallow.getAttempt());
        gallow.symbol('r');
        assertEquals(9, gallow.getAttempt());
        gallow.symbol('о');
        assertEquals(9, gallow.getAttempt());
        for (int i=0; i< 9;i++) {
            gallow.symbol('r');
        }
        assertEquals(0, gallow.getAttempt());
        gallow.symbol('u');
        assertEquals(0, gallow.getAttempt());
    }
    @Test
    void getBuff() {
        assertEquals(gallow.getWord().length(), gallow.getBuff().length());
        gallow.symbol('о');
        assertEquals(" о о   ", gallow.getBuff());
    }

    @Test
    void getWord() {
        assertNotNull(gallow.getWord());
        assertEquals("шоколад", gallow.getWord());
    }

    @Test
    void initEmpty() {
        gallow.initEmpty();
        assertEquals("       ", gallow.getBuff());
        assertEquals(gallow.getWord().length(), gallow.getBuff().length());
    }

    @Test
    void symbol() {
        var nl = System.lineSeparator();
        String view = new String(gallow.getBuff() + nl + "У вас осталось 9 попыток");
        TurnResultView res = new TurnResultView(TurnResult.CONTINUE, view);
        assertEquals(String.valueOf(res), String.valueOf(gallow.symbol('s')));
        gallow.symbol('о');
        gallow.symbol('ш');
        gallow.symbol('к');
        gallow.symbol('л');
        gallow.symbol('а');
        gallow.symbol('д');
        String view1 = new String(gallow.getBuff() + nl + "У вас осталось 9 попыток");
        TurnResultView res1 = new TurnResultView(TurnResult.YOU_WON, view1);
        assertEquals(String.valueOf(res1), String.valueOf(gallow.view()));
    }
    @Test
    void isWin(){
        System.out.println(gallow.getBuff());
        assertEquals(TurnResult.CONTINUE, gallow.isWin());
        gallow.symbol('о');
        gallow.symbol('ш');
        gallow.symbol('к');
        gallow.symbol('л');
        gallow.symbol('а');
        gallow.symbol('д');
        assertEquals(TurnResult.YOU_WON, gallow.isWin());
     //   gallow.re;
        for (int i=0; i<= 10;i++) {
            gallow.symbol('r');
        }
        assertEquals(TurnResult.YOU_LOSE, gallow.isWin());

    }

    }
