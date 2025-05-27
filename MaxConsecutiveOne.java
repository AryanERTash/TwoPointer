class Solution {
	public int longestOnes(int[] nums, int k) {

		int left = 0, right = 0, n = nums.length, flips = 0, maxLen = 0;

		while (right < n) {
			if (nums[right] == 0 && flips < k) {
				flips++;
			} else if (nums[right] == 0 && flips == k) {
				while (nums[left] == 1) {
					left++;
				}
				left++;
			}

			maxLen = Math.max(maxLen, right - left + 1);
			right++;

		}

		return maxLen;

	}
}