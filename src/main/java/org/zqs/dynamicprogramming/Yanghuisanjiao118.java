package org.zqs.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Yanghuisanjiao118 {

    public static void main(String[] args) {

        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows < 1) {
            return result;
        }
        List<Integer> firstRow = new ArrayList() {{
            add(1);
        }};
        result.add(firstRow);
        if (numRows < 2) {
            return result;
        }
        List<Integer> secondRow = new ArrayList() {{
            add(1);
            add(1);
        }};
        result.add(secondRow);
        if (numRows < 3) {
            return result;
        }

        int i = 1;
        while (++i < numRows) {
            List<Integer> lastRow = result.get(i-1);
            List<Integer> currentRow = new ArrayList<>();

            int slow = 0;
            int fast = slow + 1;
            while (fast < lastRow.size()) {
                int num1 = lastRow.get(slow);
                int num2 = lastRow.get(fast);
                currentRow.add(num1 + num2);

                slow++;
                fast++;
            }

            currentRow.add(0, 1);
            currentRow.add(1);
            result.add(currentRow);

        }

        return result;
    }
}
