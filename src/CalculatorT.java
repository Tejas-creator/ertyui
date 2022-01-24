import java.util.Scanner;

public class CalculatorT {
    public static void main(String[] args) {
        double start = 0.0;
        System.out.println(start);
        Scanner scaner = new Scanner(System.in);
        while (true) {
            String data = scaner.nextLine();
            if (data.isEmpty()) {
                System.out.println("Value can not be empty");
                continue;
            }

            if (data.equals("exit")) {
                System.exit(0);
            }

            String dataForSwitch = String.valueOf(data.charAt(0));
            int parsingToInt = Integer.parseInt(data.substring(1));
            switch (dataForSwitch) {
                case "+", "-", "/", ":", "*" -> {
                    switch (dataForSwitch) {
                        case "+" -> {
                            start = start + parsingToInt;
                            System.out.println(start);
                        }
                        case "-" -> {
                            start = start - parsingToInt;
                            System.out.println(start);
                        }
                        case "/", ":" -> {
                            start = start / parsingToInt;
                            System.out.println(start);
                        }
                        case "*" -> {
                            start = start * parsingToInt;
                            System.out.println(start);
                        }
                    }
                }
                default -> System.out.println("Place +,-,*,/ or : at the beginning of input");
            }
        }
    }
}

