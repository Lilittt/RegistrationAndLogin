import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<User> StringToUser(List<String> strings) {
        List<User> users = new ArrayList<>();
        String[] user;

        for (int i = 0; i < strings.size(); i++) {
            user = strings.get(i).split(",");

            User u = new User(user[0]);
            u.setUsername(user[1]);
            u.setEmail(user[2]);
            u.setPassword(user[3]);
            users.add(u);
        }
        return users;
    }
}