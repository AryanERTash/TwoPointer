import java.util.*;

class Solution {
	public static Map<Character, Integer> makeFreqMap(String t) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {

			char ch = t.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		}

		return map;

	}
	
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length())
			return "";

		int left = 0, right = 0, n = s.length(),
				minLength = Integer.MAX_VALUE, minStart = -1;

		Map<Character, Integer> freqMap = makeFreqMap(t);
		int tn = t.length(), uniques = freqMap.size(), uniqueCharCount = 0;

		while (right < n) {

			char curr = s.charAt(right);
			int f = freqMap.getOrDefault(curr, 0);
			if (f == 1) {
				++uniqueCharCount;
			}
			freqMap.put(curr, f - 1);

			while (uniqueCharCount == uniques) {

				curr = s.charAt(left);
				f = freqMap.get(curr) + 1;
				if (f > 0)
					uniqueCharCount--;
				freqMap.put(curr, f);

				int l = right - left + 1;

				if (l < minLength) {
					minLength = l;
					minStart = left;
				}

				left++;
			}

			right++;

		}

		return minStart == -1 ? "" : s.substring(minStart, minStart+minLength);

	}
}