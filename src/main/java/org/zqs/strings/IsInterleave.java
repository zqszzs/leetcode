package org.zqs.strings;

// todo
public class IsInterleave {


    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean result = isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int a = 0, b = 0;
        for (int i = 0; i < s3.length(); i++) {
            char currentChar = s3.charAt(i);
            if (a < s1.length() && s1.charAt(a) == currentChar) {
                a++;
            } else if (b < s2.length() && s2.charAt(b) == currentChar) {
                b++;
            }
        }

        return a == s1.length() - 1 && b == s2.length() - 1;
    }
}
