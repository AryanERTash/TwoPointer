import java.util.*;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0, max = 0, n = s.length();
		Set<Character> visited = new HashSet<>();

		while (right < n) {
			char curr = s.charAt(right);

			if (!visited.contains(curr)) {
				visited.add(curr);
				max = Math.max(max, right - left + 1);
			} else {
				while (s.charAt(left) != curr) {
					visited.remove(s.charAt(left++));
				}

				left++;
			}

			right++;
		}

		return max;

	}
}