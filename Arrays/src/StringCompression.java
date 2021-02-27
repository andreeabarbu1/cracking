public class StringCompression {

    // time comlexity: O(p + k^2), where p is the size of the original string
    // and k is the number of character sequences
    // it's slow bcs string concatenation operates in O(n^2)
    public static String compress(char[] str) {
        String compressedStr = "";

        int currentNo = 1;
        char currentChar = str[0];
        compressedStr += currentChar;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == currentChar) {
                currentNo++;
            } else {
                compressedStr += currentNo;
                currentChar = str[i];
                currentNo = 1;
                compressedStr += currentChar;
            }
        }
        compressedStr += currentNo;

        return compressedStr.length() > str.length ? new String(str) : compressedStr;
    }

    // uses StringBuilder
    public static String compression(char[] str) {
        StringBuilder compressedStr = new StringBuilder("");

        // check in advance if the initial string is shorter, more optimal
        // in cases where we don't have a large number of repeating chars
        int finalLength = countCompression(str);
        if (finalLength >= str.length) {
            return new String(str);
        }

        int currentNo = 1;
        char currentChar = str[0];
        compressedStr.append(currentChar);

        for (int i = 0; i < str.length; i++) {
            if (str[i] == currentChar) {
                currentNo++;
            } else {
                compressedStr.append(currentNo);
                currentChar = str[i];
                currentNo = 1;
                compressedStr.append(currentChar);
            }
        }
        compressedStr.append(currentNo);

        return new String(compressedStr);
    }

    public static int countCompression(char[] str) {
        int compressedLength = 0;
        int consecutiveChars = 1;
        char currentChar = str[0];

        for (int i = 1; i < str.length; i++) {
            if (str[i] == currentChar) {
                consecutiveChars++;
            } else {
                consecutiveChars = 1;
                currentChar = str[i];
                compressedLength += 1 + String.valueOf(consecutiveChars).length();
            }
        }
        return compressedLength;
    }


    public static void main(String[] args) {
        char[] input = "aabcccccaaa".toCharArray();
        System.out.println(compression(input));
    }
}
