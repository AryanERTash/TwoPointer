
class Solution {
	public int maxScore(int[] cardPoints, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += cardPoints[i];
		}

		int maxScore = sum;
		int right = cardPoints.length - 1;

		for (int i = 1; i <= k; i++) {

			sum -= cardPoints[k - i];
			sum += cardPoints[right--];

			maxScore = Math.max(maxScore, sum);

		}

		return maxScore;
	}
}