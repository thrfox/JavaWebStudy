package com.study.Method;

import java.util.Arrays;

public class HalfPickMethod {
    //二分
    public static void main(String[] args) {
        int[] nums = {16,2,6,4,5,3,7,8,1};
        Arrays.sort(nums);
        int picknum = 66;
        //System.out.println(halfPick1(nums,0,nums.length-1,picknum));

        System.out.println(halfPick2(nums,picknum));
    }

    public static int halfPick1(int[] nums,int start,int end,int picknum){

        if (nums == null){
            return -1;
        }
        if (start <= end){
            //中间位置
            int middle = (start+end) / 2;
            //中间值
            int middleVal = nums[middle];
            if (middleVal == picknum){
                return middleVal;
            }else if(picknum < middleVal){
                //目标小于中间值，在中间值前面找
                return halfPick1(nums,start,middle - 1,picknum);
            }else {
                //目标大于中间值，在中间后面找
                return halfPick1(nums,middle + 1,end,picknum);
            }
        }else {
            return -1;
        }
    }

    public static int halfPick2(int[] nums,int picknum){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int middle = (start+end)/2;
            int middleVal = nums[middle];
            if (picknum < middleVal){
                //小于,则在middle的前面找
                end = middle - 1;
            }else if (picknum > middleVal){
                //大于,在middle的后面找
                start = middle + 1;
            }else {
                return middleVal;
            }
        }
        return -1;
    }


}
