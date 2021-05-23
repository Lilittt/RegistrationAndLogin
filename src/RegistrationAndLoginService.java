import java.util.Scanner;
import java.util.StringJoiner;

public class RegistrationAndLoginService {

    public static User createUser() {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter full name: ");
        String fullName = s.nextLine();

        while (!Validations.isValidFullName(fullName)) {
            System.out.println("Enter valid full name!!");
            String fName = s.nextLine();
            fullName = fName;
        }

        System.out.println("Enter username: ");
        String username = s.next();

        while (!Validations.isValidUsername(username)) {
            System.out.println("Entered username isn't available, please enter another one!!");
            String uName = s.next();
            username = uName;
        }

        System.out.println("Enter e-mail: ");
        String email = s.next();

        while (!Validations.isValidEmail(email)) {
            System.out.println("Input a valid e-mail");
            String eMail = s.next();
            email = eMail;
        }

        System.out.println("Enter password: ");
        String password = s.next();

        while (!Validations.isValidPassword(password)) {
            System.out.println("Enter a valid password");
            String nextPassword = s.next();
            password = nextPassword;
        }

        User user = new User(fullName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(Validations.MD5(password));

        StringJoiner sj = new StringJoiner(",");
        String str = sj.add(fullName).add(username).add(email).add(Validations.MD5(password)).toString();

        FileService.write(Validations.getPath(), str + "\n");
        System.out.println("You have successfully registered.");
        return user;
    }

    public static void Login() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter username");
        String username = s.next();

        System.out.println("Enter password");
        String password = Validations.MD5(s.next());

        String[] file = FileService.readArray(Validations.getPath());

        String[] splitted;
        boolean isLoggedIn = false;
        for (int i = 0; i < file.length; i++) {
            splitted = file[i].split(",");
            if (splitted[1].equals(username) && splitted[3].equals(password)) {
                isLoggedIn = true;
                break;
            }
        }
        if (isLoggedIn)
            System.out.println("You have successfully logged in.");
        else
            System.out.println("Invalid login information.");
    }
}