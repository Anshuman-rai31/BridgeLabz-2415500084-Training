package wrapperclass;

import java.util.ArrayList;

public class CheckDigitOrAlphabet {
    public static void main(String[] args) {
        ArrayList<Character> chars = new ArrayList<>();
        chars.add('A');
        chars.add('3');
        chars.add('b');
        chars.add('9');

        for (Character ch : chars) {
            if (Character.isDigit(ch))
                System.out.println(ch + " is a digit");
            else if (Character.isLetter(ch))
                System.out.println(ch + " is an alphabet");
            else
                System.out.println(ch + " is neither digit nor alphabet");
        }
    }

}
