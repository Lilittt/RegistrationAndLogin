import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        List<String> strings = FileService.readList(Validations.getPath());
        List<User> users = Converter.StringToUser(strings);

        Scanner s = new Scanner(System.in);
        boolean isMenuActive = true;

        while (isMenuActive) {
            System.out.println("1. Registration");
            System.out.println("2. Login");

            int taskNumber = s.nextInt();

            switch (taskNumber) {
                case 1:
                    System.out.println(RegistrationAndLoginService.createUser());
                    break;
                case 2:
                    RegistrationAndLoginService.Login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("Invalid task number!");
            }
        }
    }
}