package level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsStrTest {

    @Test
    void isGood() {
       
        SymbolsStr s = new SymbolsStr();
        assertEquals(true, s.isGood());
       
        SymbolsStr s1 = new SymbolsStr("({{}})");
        assertEquals(true, s1.isGood());
        
        SymbolsStr s2 = new SymbolsStr("({{}(}))");
        assertEquals(false, s2.isGood());
        
        SymbolsStr s3 = new SymbolsStr("())))");
        assertEquals(false, s3.isGood());
        
        SymbolsStr s4 = new SymbolsStr("({)}");
        assertEquals(false, s4.isGood());
    }
}
