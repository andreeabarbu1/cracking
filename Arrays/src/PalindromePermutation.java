public class PalindromePermutation {

    // O(n)
    public static boolean checkPalindrome(String input) {
        char[] str = input.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        //java.util.Arrays.sort(str);
        System.out.println(str);

        char[] characters = new char[128]; // assumption - ASCII
        for (int i = 0; i < 128; i++) {
            characters[i] = 0;
        }

        for (int i = 0; i < input.length(); i++) {
            int value = Character.getNumericValue(input.charAt(i));
            if (value != -1) {
                characters[value]++;
            }
        }

        int size = str.length;
        int oneOddChar = 0;
        System.out.println(size + " " + new String(str));

        // a-z; 97-122
        for (int i = 97; i <= 122; i++) {
            if (characters[i] % 2 != 0 && oneOddChar == 0 && size % 2 != 0) {
                oneOddChar++;
                System.out.println(i);
                continue;
            } else if (characters[i] % 2 != 0) {
                System.out.println(i);
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "tactcoa";
        String input2 = "Tact Coa";

        System.out.println(checkPalindrome(input2));
    }
}

/*
Bit implementation
 */