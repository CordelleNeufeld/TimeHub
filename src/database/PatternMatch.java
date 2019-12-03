package database;

public class PatternMatch {

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