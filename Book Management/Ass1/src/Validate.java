
import java.util.Scanner;

public class Validate {
    static Scanner sc = new Scanner(System.in);
    public static int checkInputLimited(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter " + min + " to " + max + "!");
            }
        }
    }
    
    //check user input string
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }  
    
    //check user input int
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException n) {
                System.err.println("Please input number!");
                System.out.print("Enter again: ");   
            }
        }
    }
}
