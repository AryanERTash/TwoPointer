# https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
class Solution:
    @staticmethod
    def least_index(pos: dict) -> int:
        # return index of least elemnt
        # if -1 found return -1
        m = -1
        for key in pos:
            if pos[key] == -1:
                return -1

            m = pos[key] if m == -1 else min(m, pos[key])
        return m

    def numberOfSubstrings(self, s: str) -> int:
        substring_count = i = 0
        pos_map = {
            "a": -1,
            "b": -1,
            "c": -1,
        }

        for i in range(len(s)):
            ch = s[i]
            pos_map[ch] = i
            min_index: int = Solution.least_index(pos_map)

            if min_index != -1:
                substring_count += 1 + min_index
        return substring_count
