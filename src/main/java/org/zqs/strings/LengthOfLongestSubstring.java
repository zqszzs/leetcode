package org.zqs.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int size = lengthOfLongestSubstring("dvdf");
        System.out.println(size);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> list = new HashSet<Character>(s.length());
        int left =0, right = 0, size = 0;
        while (right < s.length()) {
            char a = s.charAt(right);
            if (list.contains(a)) {
                if (size < list.size()) {
                    size = list.size();
                }
                list.clear();
                left++;
                right = left;
            } else {
                list.add(a);
                right++;
            }
        }
        size = list.size() > size ? list.size() : size;
        return size;
    }
}
