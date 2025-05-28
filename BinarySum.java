/*
 * leetcode: https://leetcode.com/problems/binary-subarrays-with-sum/
 */

class Solution {

	public static int atMostSum(int[] nums, int goal) {
		int left = 0, right = 0, n = nums.length, count = 0, sum = 0;

		while (right < n) {
			sum += nums[right];

			while (sum > goal)
				sum -= nums[left++];

			count += (right - left + 1);
			right++;
		}

		return count;
	}

	public int numSubarraysWithSum(int[] nums, int goal) {
		if (goal == 0)
			return atMostSum(nums, goal);
		return atMostSum(nums, goal) - atMostSum(nums, goal - 1);

	}
}