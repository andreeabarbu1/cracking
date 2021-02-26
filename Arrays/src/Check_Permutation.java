
/*
is the comparison case sensitive?
whitespace is significant?
 */

public class Check_Permutation {
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    // O(n * logn)
    public static boolean checkAndSort(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        return sort(str1).equals(sort(str2));
    }

    // O(n)
    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] characters = new int[128]; // ASSUMPTION
        for (int i = 0; i < 128; i++) {
            characters[i] = 0;
        }

        for (int i = 0; i < str1.length(); i++) {
            int asciiValue = str1.charAt(i);
            characters[asciiValue]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int asciiValue = str2.charAt(i);
            characters[asciiValue]--;
            if (characters[asciiValue] < 0) {
                return false;
            }
        }

        for (int i = 0; i < 128; i++) {
            if (characters[i] != 0) {
                return false;
            }
        }
         return true;
    }

    public static void main(String[] args) {
        String str1 = "youtube";
        String str2 = "ebutouy";

        System.out.println(checkPermutation(str1, str2));
        System.out.println(checkAndSort(str1, str2));
    }
}

/*
Arrays.sort()
*works for both primitive and reference type of arrays
* O(logn * n) average time complexity

 */