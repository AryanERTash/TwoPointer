/*
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */

class Solution {
	public int characterReplacement(String s, int k) {

		int left = 0, right = 0, maxLen = 0, maxFreq = 0, n = s.length();
		int hash[] = new int[26];

		while (right < n) {

			char ch = s.charAt(right);
			maxFreq = Math.max(maxFreq, ++hash[ch - 'A']);

			if ((right - left + 1) - maxFreq > k) {
				hash[s.charAt(left++) - 'A']--;
			}

			if ((right - left + 1) - maxFreq <= k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}

			right++;

		}

		return maxLen;

	}
}