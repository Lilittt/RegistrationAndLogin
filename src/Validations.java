import java.util.regex.Pattern;

public class Validations {
    private static String path = "C:\\Users\\Lilit\\Desktop\\database.txt";

    public static String getPath() {
        return path;
    }

    public static boolean isValidPassword(String password) {
        int digits = 0;
        int uppercaseLetters = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                ++uppercaseLetters;
            if (Character.isDigit(password.charAt(i)))
                ++digits;
        }
        if (uppercaseLetters >= 2 && digits >= 3 && password.length() > 8)
            return true;
        else
            return false;
    }

    public static boolean isValidFullName(String fullName) {
        String[] split = fullName.split(" ");
        if (fullName.contains(" ") && split.length == 2
                && Character.isUpperCase(split[0].charAt(0))
                && Character.isUpperCase(split[1].charAt(0))) {
            return true;
        }
        return false;
    }

    public static boolean isValidUsername(String username) {
        if (username.length() <= 10)
            return false;

        String[] file = FileService.readArray(path);
        String[] splitted;
        for (int i = 0; i < file.length; i++) {
            splitted = file[i].split(",");
            if (splitted[1].equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        if (VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches())
            return true;
        else
            return false;
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
