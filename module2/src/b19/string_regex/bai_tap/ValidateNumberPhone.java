package b19.string_regex.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumberPhone {
    private static Pattern pattern;
    private static Matcher matcher;
    private final String NAME_NUMBER="^\\(?[0-9]{2}\\)?([0-9]{10})";
    public ValidateNumberPhone() {
        pattern=Pattern.compile(NAME_NUMBER);
    }
    public boolean validate(String regex){
        matcher=pattern.matcher(regex);
        return matcher.matches();
    }
    private static ValidateNumberPhone validateNumberPhone;
    public static String[] phoneNumberTrue = new String[]{"(84)0934159980", "(11)0235467345"};
    public static String[] phoneNumberFalse = new String[]{"0934159980", "(115)0235467345"};
    public static void main(String[] args) {
        validateNumberPhone = new ValidateNumberPhone();
        for (String number : phoneNumberTrue
        ) {
            boolean isNumber = validateNumberPhone.validate(number);
            System.out.println("so dien thoai: " + number + " la: " + isNumber);
        }
        for (String number : phoneNumberFalse
        ) {
            boolean isNumber = validateNumberPhone.validate(number);
            System.out.println("so dien thoai: " + number + " la: " + isNumber);
        }
    }
}
