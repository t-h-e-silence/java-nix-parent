package level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSymbolsTest {

    @Test
    void lengthOfUniq() {
        IntSymbols i1=new IntSymbols();
        int res=i1.lengthOfUniq();
        assertEquals(4,res);
    }
}