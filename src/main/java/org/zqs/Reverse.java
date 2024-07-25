package org.zqs;

import org.omg.CORBA.INTERNAL;

public class Reverse {

    public static void main(String[] args) {
        int result = reverse(112345789);
        System.out.println(result);
    }

//    public static int reverse(int x) {
//        String numStr = String.valueOf(x);
//
//        if (numStr.length() < 2) {
//            return x;
//        }
//
//        boolean lessThen0 = false;
//        if (numStr.startsWith("-")) {
//            numStr = numStr.substring(1);
//            lessThen0 = true;
//        }
//        char [] charArray = numStr.toCharArray();
//        int l = 0, r = numStr.length() - 1;
//        while (l < r) {
//            char a = charArray[l];
//            char b = charArray[r];
//            charArray[l] = b;
//            charArray[r] = a;
//            l++;
//            r--;
//        }
//
//        l = 0;
//        for (char c : charArray) {
//            if (c == '0') {
//                l++;
//            } else {
//                break;
//            }
//        }
//
//        numStr = new String(charArray, l, charArray.length - l);
//        if (lessThen0) {
//            numStr = "-" + numStr;
//        }
//        return Integer.parseInt(numStr);
//    }


    /**
     * max_int =  2147483647
     * min_int = -2147483648
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
//            //判断是否 大于 最大32位整数
//            if (res>214748364 || (res==214748364 && tmp>7)) {
//                return 0;
//            }
//            //判断是否 小于 最小32位整数
//            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
//                return 0;
//            }
            /**
             * 其实判断条件可以简化的，因为x本身会被int限制，当x为正数并且位数和Integer.MAX_VALUE的位数相等时首位最大只能为2，所以逆转后不会出现res = Integer.MAX_VALUE / 10 && tmp > 2的情况，自然也不需要判断res==214748364 && tmp>7了，反之负数情况也一样
             **/
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}
