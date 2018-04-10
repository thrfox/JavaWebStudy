package com.study.Method;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[] {11,10,55,78,100,111,45,56,79,90,345,1000};
        System.out.println(Arrays.toString(getSort(nums)));
    }

    public static int[] getSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                }
            }
        }
        return nums;
    }
}
