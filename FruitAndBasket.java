import java.util.Map;
import java.util.HashMap;

class Solution {
	public int totalFruit(int[] fruits) {

		int left = 0, right = 0, fruitCount = 0, n = fruits.length;
		Map<Integer, Integer> fruitFreqMap = new HashMap<>();

		while (right < n) {

			fruitFreqMap.put(fruits[right],
					fruitFreqMap.getOrDefault(fruits[right], 0) + 1);
			if (fruitFreqMap.size() > 2) {

				int leftFruit = fruits[left++];
				fruitFreqMap.put(leftFruit, fruitFreqMap.get(leftFruit) - 1);

				if (fruitFreqMap.get(leftFruit) == 0)
					fruitFreqMap.remove(leftFruit);
			}

			if (fruitFreqMap.size() <= 2)
				fruitCount = Math.max(fruitCount, right - left + 1);

			right++;

		}
		return fruitCount;

	}
}