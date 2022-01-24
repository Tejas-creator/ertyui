import java.util.Scanner;

public class Calculator {
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
            if ("+-/:*".contains(dataForSwitch)) {
                int parsingToInt;
                try {
                    parsingToInt = Integer.parseInt(data.substring(1));
                }
                catch (NumberFormatException e){
                    System.out.println("You can not add words");
                    continue;
                }
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
            } else {
                System.out.println("Place +,-,*,/ or : at the beginning of input");
            }
        }
    }
}
