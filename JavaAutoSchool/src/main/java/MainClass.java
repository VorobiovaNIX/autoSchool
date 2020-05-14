import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        printFirstMiddleAndLastCharacters("automation");
        printTillFirstDot("Напишите программу, которая выводит часть строки до первой встреченной точки. включая точку");
        countSpaces("Также предусмотрите вывод количества пробелов");
        replaceOldSubstringOnNewSubstring();

        String theLongestWord = returnsTheLongestWord("Вводится строка слов разделенных пробелами Найти самое длинное слово ");
        System.out.println(String.format("The longest word in sentence is \"%s\"", theLongestWord));
    }

    /*1 Дана строка. Вывести первый, последний и средний (если он есть) символы.
    Напишите программу, которая выводит часть строки до первой встреченной точки, включая точку.
     Также предусмотрите вывод количества пробелов.
     */
    private static void printFirstMiddleAndLastCharacters(String word) {
        if (word.isEmpty()) {
            System.out.println("The string is empty");
        } else {
            System.out.println("The first character is " + word.charAt(0));

            if (word.length() % 2 == 0) {
                System.out.println("There's no middle character");
            } else {
                int middleIndex = word.length() / 2 + 1;
                System.out.println("The middle character is " + word.charAt(middleIndex));
            }
            System.out.println("The last character is " + word.charAt(word.length() - 1));
        }
    }

    private static void printTillFirstDot(String sentence) {
        int indexOfFirstDot = sentence.indexOf(".");
        if (indexOfFirstDot == -1) {
            System.out.println("There is no coma in this sentence.");
        } else {
            String substring = sentence.substring(0, indexOfFirstDot + 1);
            System.out.println(substring);
        }
    }

    private static void countSpaces(String buffer) {
        int amountOfSpaces = 0;
        for (int i = 0; i < buffer.length() - 1; i++) {
            if (buffer.charAt(i) == ' ') {
                amountOfSpaces++;
            }
        }
        System.out.println("The amount of spaces is " + amountOfSpaces);
    }

    /*2 Найти в строке указанную подстроку и заменить ее на новую.
    Строку, ее подстроку для замены и новую подстроку вводит пользователь
     */
    private static void replaceOldSubstringOnNewSubstring() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Enter string: ");
        String enteredString = inputReader.nextLine();

        System.out.println("Enter existing substring that will be replaced: ");
        String substringToReplace = inputReader.next();

        System.out.println("Enter the substring you want to replace with: ");
        String replacement = inputReader.next();

        if (enteredString.contains(substringToReplace)) {
            String newString = enteredString.replace(substringToReplace, replacement);
            System.out.println(newString);
        } else System.out.println("There's no such substring in entered string");
    }

    /* 3. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
    Случай, когда самых длинных слов может быть несколько, не обрабатывать
     */
    private static String returnsTheLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String theLongestWord = words[0];

        for (int i = 1; i < words.length - 1; i++) {
            if (theLongestWord.length() < words[i].length()) {
                theLongestWord = words[i];
            }
        }
        return theLongestWord;
    }
}
