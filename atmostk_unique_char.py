# https://www.naukri.com/code360/problems/distinct-characters_2221410


def kDistinctChars(k, str):

    left = right = maxLen = 0
    n = len(str)
    freq_map = {}

    while right < n:
        freq_map.setdefault(str[right], 0)
        
        freq_map[str[right]]+=1

        if len(freq_map) > k:
            #this reduces time complexity to N ensuring window of only max length or greater is allowed
            freq_map[str[left]] -= 1
            if freq_map[str[left]] == 0:
                del freq_map[str[left]]
            left += 1
        if len(freq_map) <= k:
            maxLen = max(maxLen, right - left + 1)
        right += 1
    return maxLen
