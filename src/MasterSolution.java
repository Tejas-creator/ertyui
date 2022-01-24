import java.util.Scanner;

public class MasterSolution {
    public static void main(String[] args) {
        double currentNumber = 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'end' to exit\n");

        do {
            System.out.println(currentNumber);
            String input = scanner.nextLine();
            if (input.length() < 2) {
                continue;
            }
            if (input.equals("end")) {
                System.exit(0);
            }
            char operation = input.charAt(0);
            int number;
            try {
                number = Integer.parseInt(input.substring(1));
            } catch (NumberFormatException ignore) {
                continue;
            }

            if (number < 0) {
                continue;
            } // --2

            switch (operation) {
                case '+' -> currentNumber += number;
                case '-' -> currentNumber -= number;
                case '*' -> currentNumber *= number;
                case '/' -> currentNumber /= number;
            }
        } while (true);
    }
}