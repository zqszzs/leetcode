package org.zqs.nums;

import java.util.Arrays;

public class HIndex274 {

    public static void main(String[] args) {

        int result = hIndex(new int [] {100,200});
        System.out.println(result);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {

        }

        return h;
    }
}
