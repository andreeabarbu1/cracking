import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/*
You should!!!
%% ask your interviewer if the string is an ASCII string or a Unicode String
%% No data structures
1. Compare every character of the string to every other character of the string.
This will take 0(n^2) time and 0(1) space.
2. If we are allowed to modify the input string, we could sort the string in
O(n log(n)) time and then linearly check the string for neighboring characters
that are identical. Careful, though: many sorting algorithms take up extra space.
 */

public class is_Unique {
    // ASCII
    public static boolean isUniqueASCII(String text) {
        if (text.length() > 128) {
            return false;
        }

        boolean[] characters = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            int asciiVal = text.charAt(i);
            if (!characters[asciiVal]) {
                characters[asciiVal] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique(String text) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            if (!characters.contains(text.charAt(i))) {
                characters.add(text.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "NotAllUnique";
        System.out.println(isUnique(string));

    }
}

/*
    HASH SET
    Amortize (average or usual case) time complexity for add, remove and
    look-up (contains method) operation takes O(1) time.
    Time complexity: O(n)

    DIFFERENCE BETWEEN UNICODE AND ASCII
    *character encodings
    ASCII uses seven bits to encode each character
    UNICODE uses a variable bit
 */