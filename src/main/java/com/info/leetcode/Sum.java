package com.info.leetcode;

/**
 * 递归求和案例
 * Created by M on 2018/8/18.
 */
public class Sum {

    public static int main(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;

        return arr[l] + sum(arr, l + 1);
    }
}