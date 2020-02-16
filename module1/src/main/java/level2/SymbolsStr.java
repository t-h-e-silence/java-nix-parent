package level2;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class SymbolsStr {
    String str;

    SymbolsStr(String s) {
        str = s;
    }

    SymbolsStr() {
        str = "{({[]})}";
    }

    public boolean isGood() {
        boolean istrue=false;
        ArrayList<Character> open = new ArrayList<>();
        ArrayList<Character> close = new ArrayList<>();
        char[] symbols = str.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if ((symbols[i] == '{') || (symbols[i] == '(') || (symbols[i] == '[')) {
                open.add(symbols[i]);
            } else {
                close.add(symbols[i]);
            }
        }
        if(open.size()!=close.size()) {
            return false;
        }  else
      for(int i=0; i<open.size();i++) {
            if((open.get(i)=='{' && close.get((close.size()-1-i))!='}') || (open.get(i)=='[' && close.get((close.size()-1-i))!=']') ||
                    (open.get(i)=='(' && close.get((close.size()-1-i))!=')')){
                return false;
            }
        }return true;
    }
}