public class StringRotation {

    // O(n), n - length of the longer string s1
    public static boolean isSubstring(String s1, String s2) {
        int currentIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(currentIndex)) {
                currentIndex++;
            } else {
                currentIndex = 0;
            }
            if (currentIndex == s2.length()) {
                return true;
            }
        }
        return false;
    }

    // check if s2 is a rotation of s1 using only one call to isSubstring()
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String s1s1 = s1 + s1; // inital string

        return isSubstring(s1s1, s2);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }
}

/*
    s1 = xy = waterbottle
    x = wat
    y = erbottle
    s2 = yx = erbottlewat

    s1s1 = xyxy
    s2 will always be a substring of s1s1, if s2 is a rotation of s1.
 */