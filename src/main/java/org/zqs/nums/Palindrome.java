package org.zqs.nums;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(123));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String numStr = String.valueOf(x);
        int l = 0, r = numStr.length() - 1;
        while (l < r) {
            if (numStr.charAt(l) != numStr.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    /**
     * 整数反转思路
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        int value = 0;
        int temp = x;
        while (temp!=0){
            value = value*10;
            value+=(temp%10);
            temp/=10;
        }
        return value==x;
    }
}
