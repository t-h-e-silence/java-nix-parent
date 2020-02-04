package com.alevel.java.nix.basicshomework;

public class BuzzFizz {
    int num;

    BuzzFizz(int num) {
        this.num = num;
    }

    BuzzFizz() {
        num = 1;
    }

    private char[] symbols(int num) {
        String nums = (String.valueOf(num));
        char[] number = nums.toCharArray();
        return number;
    }

    public void leftRight() {
        char[] number = symbols(num);

        for (int i = 0; i < number.length; i++) {
            if (number[i] != '0') {
                if ((number[i] % (2 * 3)) == 0) {
                    System.out.print("BuzzFizz" + "\n");
                } else if (number[i] % 2 == 0) {
                    System.out.print("Fizz" + "\n");
                } else if (number[i] % 3 == 0) {
                    System.out.print("Buzz" + "\n");
                } else if (number[i] % 2 != 0 || number[i] % 3 != 0 || number[i] % (2 * 3) != 0) {
                    System.out.print(number[i] + "\n");
                }
            } else {
                System.out.print(number[i] + "\n");
            }
        }
    }

    public void rightLeft() {
        char[] number = symbols(num);
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] != '0') {
                if ((number[i] % (2 * 3)) == 0) {
                    System.out.print("BuzzFizz" + "\n");
                } else if (number[i] % 2 == 0) {
                    System.out.print("Fizz" + "\n");
                } else if (number[i] % 3 == 0) {
                    System.out.print("Buzz" + "\n");
                } else if (number[i] % 2 != 0 || number[i] % 3 != 0 || number[i] % (2 * 3) != 0) {
                    System.out.print(number[i] + "\n");
                }
            } else {
                System.out.print(number[i] + "\n");
            }

        }
    }
}
