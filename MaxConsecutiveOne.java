/*
 * Maximum length of subarray so that it contain atmost K zeroes
 * Leetcode: https://leetcode.com/problems/max-consecutive-ones-iii/
 */

class Solution {
	public int longestOnes(int[] nums, int k) {

		int left = 0, right = 0, n = nums.length, flips = 0, maxLen = 0;

		while (right < n) {
			if(nums[right] == 0)flips++;
			if(flips>k) {
				// ensures constant windoe size of maxLen for invalid window
				if(nums[left] == 0) {
					flips--;
				}
				left ++;
			}


			maxLen = Math.max(maxLen, right - left +1);
			right++;

		}

		return maxLen;

	}
}