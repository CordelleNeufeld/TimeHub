package database;

import java.util.regex.Pattern;

public class PatternMatch {

    public static final Pattern alphaNumericPattern = Pattern.compile("^[a-zA-Z0-9 ]*$");
    public static final Pattern alphaNumericPeriodPattern = Pattern.compile("^[a-zA-Z .]*$");

    public static String escapeSpecialCharacters(String string) {
        final String[] specialCharacters = {"\\", "'", "\""};

        for (String specialCharacter : specialCharacters) {
            if (string.contains(specialCharacter)) {
                string = string.replace(specialCharacter, "\\" + specialCharacter);
            }
        }
        return string;
    }
}