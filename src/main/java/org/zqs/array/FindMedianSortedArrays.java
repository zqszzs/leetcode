package org.zqs.array;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int maxLength = 0, maxL= 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i;
            for (; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ; --l, ++r) {}
            if (maxLength < r - l - 1) {
                maxLength = r -l - 1;
                maxL = l + 1;
            }


            l = i - 1;
            r = i + 1;
            for (; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ; --l, ++r) {}
            if (maxLength < r - l - 1) {
                maxLength = r -l - 1;
                maxL = l + 1;
            }
        }

        return s.substring(maxL, maxL + maxLength);
    }
}
