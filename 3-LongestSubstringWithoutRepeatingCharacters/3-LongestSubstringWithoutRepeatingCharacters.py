# Last updated: 08/04/2025, 18:14:28
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start=0
        end=0

        hash_set = set()
        maxLength=0

        while(end<len(s)):
            if s[end] in hash_set:
                hash_set.remove(s[start])
                start+=1
            else:
                hash_set.add(s[end])
                maxLength=max(maxLength,end-start+1)
                end+=1

        
        return maxLength

        