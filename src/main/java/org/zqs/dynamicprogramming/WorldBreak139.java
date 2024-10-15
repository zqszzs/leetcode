package org.zqs.dynamicprogramming;

import java.util.*;

public class WorldBreak139 {

    public static void main(String[] args) {

        boolean result = wordBreak("leetcode", new ArrayList() {{
            add("leet");
            add("code");
        }});

        System.out.println(result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
