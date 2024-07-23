import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {

    public static void main(String[] args) {

        boolean result = isMatch("aa", "a");
        System.out.println(result);
    }

    public static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
