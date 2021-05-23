import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;

    public User(String fullName, String username, String email, String password) {
        RegistrationAndLoginService.createUser();
    }

    @Override
    public String toString() {
        return "{" +
                "fullname='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (Validations.isValidFullName(fullName))
            this.fullName = fullName;
    }

    public User(String fullName) {
        this.setFullName(fullName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (Validations.isValidUsername(username))
            this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Validations.isValidEmail(email))
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (Validations.isValidPassword(password))
            this.password = Validations.MD5(password);
    }
}