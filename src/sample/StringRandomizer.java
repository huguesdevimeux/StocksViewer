package sample;

public class StringRandomizer {
    public static String generateString(int stringLength) {
        StringBuilder generatedString = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "1234567890" +
                "!@#$%^&*()_-+{}/?,.";
        for (int i = 0; i < stringLength; i++) {
            int index = (int) (alphabet.length() * Math.random());
            generatedString.append(alphabet.charAt(index));
        }
        return generatedString.toString();
    }
}
