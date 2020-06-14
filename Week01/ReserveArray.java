package com.yzy.week1;

import java.util.Arrays;

public class ReserveArray {

  public static void main(String[] args) {
    new ReserveArray().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
  }

  public void rotate(int[] nums, int k) {
    //使用三次翻转
    k %= nums.length;
    reserve(nums, 0, nums.length - 1);
    reserve(nums, 0, k - 1);
    reserve(nums, k, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }

  public void reserve(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}
