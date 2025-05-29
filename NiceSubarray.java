/*
 * Leetcode: https://leetcode.com/problems/count-number-of-nice-subarrays
 */

class Solution {

	public static int atmostKOdd(int[] nums, int k) {
		if (k < 0)
			return 0;
		int left = 0, right = 0, n = nums.length, count = 0, sum = 0;
		while (right < n) {

			sum += (nums[right] & 1);

			while (sum > k)
				sum -= (nums[left++] & 1);
			count += (right++ - left + 1);

		}
		return count;

	}

	public int numberOfSubarrays(int[] nums, int k) {
		return atmostKOdd(nums, k) - atmostKOdd(nums, k - 1);
	}
}