package level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsStrTest {

    @Test
    void isGood() {
        //1
        SymbolsStr s = new SymbolsStr();
        assertEquals(true, s.isGood());
        //2
        SymbolsStr s1 = new SymbolsStr("({{}})");
        assertEquals(true, s1.isGood());
        //3
        SymbolsStr s3 = new SymbolsStr("())))");
        assertEquals(false, s3.isGood());
        //4
        SymbolsStr s2 = new SymbolsStr("({{}(}))");
        assertEquals(false, s2.isGood());
    }
}