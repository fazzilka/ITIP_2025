package LR_1;

public class Primas {
    public static void main(String[] args) {
        for (int n = 2; n <= 100; n++) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }

    // Проверка простого числа: перебираем делители от 2 до sqrt(n)
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
