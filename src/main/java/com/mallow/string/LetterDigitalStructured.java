package com.mallow.string;

/**
 * input a string , like "dfdd3432ds", which contains only letter and digital
 * move all letters to left and digits to right
 * <p>
 * traverse from both ends to the center, swap first left digital and first right letter
 * Created by lcy on 2017/1/23.
 */
public class LetterDigitalStructured {
    public static void main(String args[]) {
        System.out.println(structDigitalAndLetter("fgdgrt65df48rtr"));
        System.out.println(structDigitalAndLetter("fdgfd4545"));
        System.out.println(structDigitalAndLetter("5665fdv"));
        System.out.println(structDigitalAndLetter("trgrr4f654"));
    }

    public static String structDigitalAndLetter(String input) {
        char[] inputChars = input.toCharArray();
        int i = 0;
        int j = inputChars.length - 1;
        while (i < j) {
            while (isLetter(inputChars[i])) {
                i++;
            }
            while (isDigital(inputChars[j])) {
                j--;
            }
            if (i < j) {
                char temp = inputChars[i];
                inputChars[i] = inputChars[j];
                inputChars[j] = temp;
            }
        }
        String output = String.valueOf(inputChars);
        return output;
    }

    public static boolean isDigital(char x) {
        if (x >= '0' && x <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLetter(char x) {
        if (x >= 'a' && x <= 'z') {
            return true;
        }
        if (x >= 'A' && x <= 'Z') {
            return true;
        }
        return false;
    }
}
