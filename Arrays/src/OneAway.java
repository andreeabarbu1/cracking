import java.awt.event.MouseAdapter;

/*
Three types of edits:
    * insert a character
    * remove a character
    * replace a character
 */
public class OneAway {

    public static boolean isCorrectEdited(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        boolean oneEdit = false;
        String shortStr = str1.length() < str2.length() ? str1 : str2;
        String longStr = str1.length() < str2.length() ? str2 : str1;
        int index1 = 0, index2 = 0;

        while (index1 < shortStr.length() && index2 < longStr.length()) {
            if (shortStr.charAt(index1) != longStr.charAt(index2)) {
                // first difference
                if (!oneEdit) {
                    oneEdit = true;
                } else {
                    return false;
                }

                // replacement
                if (shortStr.length() == longStr.length()) {
                    index1++; // On replace, move shorterpointer
                }

            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }

        return true;
    }

    public static void main(String[] args) {
        String input1 = "pale";
        String input2 = "ple";
        String input3 = "pales";
        String input4 = "bale";
        String input5 = "bake";

        System.out.println(isCorrectEdited(input1, input4));
    }
}
