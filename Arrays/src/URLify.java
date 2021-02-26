public class URLify {
    private final char[] pattern =  "%20".toCharArray();

    public static char[] convertString(char[] str) {
        int size = str.length;
        char[] newStr = new char[size];
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (str[i] != ' ') {
                newStr[index++] = str[i];
            } else if (str[i + 1] == ' ') {
                break;
            }
            else {
                newStr[index++] = '%';
                newStr[index++] = '2';
                newStr[index++] = '0';
            }

        }
        return newStr;
    }

    public static char[] convertWhitespaces(char[] str, int size) {
        int noOfWhiteSpaces = 0;
        for (int i = 0; i < size; i++) {
            if (str[i] == ' ') {
                noOfWhiteSpaces++;
            }
        }
        int lastPosition = size + noOfWhiteSpaces * 2 - 1;
        //System.out.println(str.length + " " + lastPosition + " " + noOfWhiteSpaces);
        if (size < str.length) {
            str[size] = '\0';
        }
        for (int i = size - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                str[lastPosition--] = str[i];
            } else {
                str[lastPosition--] = '0';
                str[lastPosition--] = '2';
                str[lastPosition--] = '%';
            }
        }
        return str;
    }

    public static void main(String[] args) {
        char[] input = "Mr John Smith    ".toCharArray();
        int size = 13;
        System.out.println(convertString(input));
        System.out.println(convertWhitespaces(input, size));
    }
}
