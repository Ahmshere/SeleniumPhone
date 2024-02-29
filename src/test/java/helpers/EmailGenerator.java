package helpers;

public class EmailGenerator {

    public static String generateEmail(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Lengths must be positive integers");
        }

        StringBuilder email = new StringBuilder();

        // Генерируем часть перед символом '@'
        for (int i = 0; i < a; i++) {
            email.append(randomChar());
        }
        email.append("@");

        // Генерируем часть между символом '@' и символом '.'
        for (int i = 0; i < b; i++) {
            email.append(randomChar());
        }
        email.append(".");

        // Генерируем часть после символа '.'
        for (int i = 0; i < c; i++) {
            email.append(randomChar());
        }

        return email.toString();
    }

    private static char randomChar() {
        // Генерация случайной буквы в диапазоне от 'a' до 'z'
        return (char) ('a' + Math.random() * ('z' - 'a' + 1));
    }

    public static void main(String[] args) {
        System.out.println("Generated string : "+ generateEmail(5,5,3));
    }
}
