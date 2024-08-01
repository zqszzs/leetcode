package org.zqs.strings;

public class StrStr28 {
    public static void main(String[] args) {
        int result = strStr("ssssadbutsad", "sad");
        System.out.println(result);
    }

    /**
     * 滑动窗口
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int needLength = needle.length();
        for (int i = 0; i <= haystack.length() - 1; i++) {
            if (i + needLength > haystack.length()) {
                return -1;
            }
            String subStr = haystack.substring(i, needLength + i);
            if (subStr.equals(needle)) {
                return i;
            }
        }

        return -1;
    }

}
