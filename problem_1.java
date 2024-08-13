import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserInputValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validate Username
        String username = "";
        while (true) {
            System.out.print("Enter Username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username should not be empty.");
            } else if (username.length() > 50) {
                System.out.println("Username should not exceed 50 characters.");
            } else if (!username.matches("[a-zA-Z0-9]+")) {
                System.out.println("Username should be alphanumeric.");
            } else {
                break;
            }
        }

        // Validate Password
        String password = "";
        while (true) {
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters long.");
            } else if (!password.matches(".*[!@#$%^&*()].*")) {
                System.out.println("Password must contain at least one special symbol.");
            } else if (!password.matches(".*[0-9].*")) {
                System.out.println("Password must contain at least one number.");
            } else if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")) {
                System.out.println("Password must contain both uppercase and lowercase characters.");
            } else if (password.matches(".*(12345678|password).*")) {
                System.out.println("Password is too common.");
            } else {
                break;
            }
        }

        // Validate Email
        String email = "";
        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Email is not valid.");
            } else {
                break;
            }
        }

        System.out.println("All inputs are valid!");
        scanner.close();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
