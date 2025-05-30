import java.util.*;

class Solution {

	public static int atMostKDistinct(int[] nums, int k) {
		if (k == 0)
			return 0;
		int left = 0, right = 0, n = nums.length, count = 0;
		Map<Integer, Integer> intFreqMap = new HashMap<>();

		while (right < n) {

			intFreqMap.put(nums[right], intFreqMap.getOrDefault(nums[right], 0) + 1);

			while (intFreqMap.size() > k) {
				intFreqMap.put(nums[left], intFreqMap.get(nums[left]) - 1);
				if (intFreqMap.get(nums[left]) == 0)
					intFreqMap.remove(nums[left]);
				left++;

			}
			count += (right - left + 1);

			right++;

		}
		return count;
	}

	public int subarraysWithKDistinct(int[] nums, int k) {

		return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);

	}
}