package b19.string_regex.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String NAMECLASS_REGEX = "^[CAP]{1}\\d{4}[GHIKLM]";

    public ValidateClass() {
        pattern = Pattern.compile(NAMECLASS_REGEX);
    }
    public boolean validate(String regex){
        matcher=pattern.matcher(regex);
        return matcher.matches();
    }
    private static ValidateClass validateClass;
    public static final String[] validName = new String[] { "C2345H", "A3476M", "P7668G" };
    public static final String[] invalidName = new String[] { "J3456A", "DF334T", "GFHDXG" };
    public static void main(String[] args) {
        validateClass = new ValidateClass();
        for (String name : validName) {
            boolean isvalid = validateClass.validate(name);
            System.out.println("Name class is " + name + " is valid: " + isvalid);
        }
        for (String name : invalidName) {
            boolean isvalid = validateClass.validate(name);
            System.out.println("Name class is " + name + " is valid: " + isvalid);
        }
    }
}
