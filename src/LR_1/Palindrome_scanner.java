package LR_1;

import java.util.Scanner;

public class Palindrome_scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите слово для проверки (или 'exit' чтобы выйти): ");

        while (true) {
            String word = scanner.nextLine();

            if (word.equals("exit")) {
                System.out.println("Выход из программы...");
                break;
            }

            if (isPalindrome(word)) {
                System.out.println(word + " -> это палиндром!");
            } else {
                System.out.println(word + " -> не палидром");
            }

            System.out.print("\nВведите новое слово (или 'exit' чтобы выйти): ");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        return s.equals(reversed);
    }
}
