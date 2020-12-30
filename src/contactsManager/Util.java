package contactsManager;

import java.util.Scanner;

public class Util {


    public class Input {
        private Scanner sc;

        public Input() {
            this.sc = new Scanner(System.in);
        }

        public String getString() {
            return this.sc.nextLine();
        }

        public String getString(String prompt) {
            System.out.println(prompt);
            return getString();
        }

        public boolean yesNo() {
            return yesNo("Please enter yes or no.");
        }

        public boolean yesNo(String prompt) {
            System.out.println(prompt);
            String input = this.sc.next();
            return (input.trim().toLowerCase().equals("y") || input.trim().toLowerCase().equals("yes"));
        }

        public int getInt() {
            try {
                return Integer.valueOf(getString());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an int");
                return getInt();
            }
        }

        public int getInt(int min, int max, String prompt) {
            int input;
            do {
                System.out.println(prompt);
                input = this.sc.nextInt();
            } while (input < min || input > max);
            return input;
        }


        public double getDouble() {
            System.out.println("Please enter an double");
            try {
                return Double.valueOf(getString());
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number!");
                return getDouble();
            }
        }

        public double getDouble(double min, double max) {
            double userDouble = getDouble();
            if (userDouble >= min && userDouble <= max) {
                System.out.println("You are within range");
                return userDouble;
            } else {
                System.out.println("you are not within range");
                return getDouble(min, max);
            }


        }

    }
}

