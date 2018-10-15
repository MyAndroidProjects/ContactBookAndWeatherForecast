package com.study.riseof.contactbook;

import java.util.ArrayList;
import java.util.List;

public class AlphabetList {
  /*  private final int LETTERS_NUMBER=26;
    private final int LETTER_CODE_A=65;
    private final int LETTER_CODE_Z=90; */

    // тут вполне хватит обычного массива, но использовал List, чтобы было
    static List<Character> alphabet;
    static {
        alphabet = new ArrayList<Character>();
        for (char c='A'; c<='Z'; c++){
            alphabet.add(c);
        }
    }

    public AlphabetList(){
    }

    // ??? второй способ создания алфавита, какой лучше?
  /*  private void createAlphabet(){
        alphabet = new ArrayList<Character>(LETTERS_NUMBER);

        for (int i=LETTER_CODE_A;i<=LETTER_CODE_Z;i++){
            alphabet.add((char)i);
        }
        Log.d("mylog","создание алфавита "+Character.toString(alphabet.get(0)));
    }*/

    public static List<Character> getAlphabet(){
        return alphabet;
    }
}
