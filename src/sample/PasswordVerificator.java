package sample;

public class PasswordVerificator {
    public boolean userPassword(String password) {
        boolean validPassword = false;
        /*
        index number of numbers and index of uppercase
        letters and lower case
         */
        int indexNB = 0;
        int indexUC = 0;
        int indexL = 0;
        char[] pass = password.toCharArray();
        for (char c : pass) {
            if (Character.isDigit(c)) indexNB++;
            if (Character.isUpperCase(c)) indexUC++;
            if (Character.isLowerCase(c)) indexL++;
        }
        if (indexNB != 0 && indexUC != 0 && indexL != 0) validPassword = true;
        return validPassword;
    }
}