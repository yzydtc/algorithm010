import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //两遍哈希表
        for (int i = 0;i < nums.length;i++) {
            map.put(nums[i],i);//第一遍，将数组中的值放入哈希表
        }
        for (int i =0;i < nums.length;i++) {
            int result = target - nums[i];//计算a=b-c
            if (map.containsKey(result) && map.get(result)!=i) {
                return new int[]{ i,map.get(result) };//第二遍判断b-c的值，在hash表中取数组下标
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end

