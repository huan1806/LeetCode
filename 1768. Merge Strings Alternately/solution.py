class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        len1 = len(word1)
        len2 = len(word2)
        ret = ""
        for i in range(0, max(len1, len2)):
            if i < len1:
                ret += word1[i]
            if i < len2:
                ret += word2[i]
        return ret