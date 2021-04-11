class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs: return ""
        pre = min(strs, key = len)
        for i, c in enumerate(pre):
            for word in strs:
                if word[i] != c:
                    return pre[:i]
        return pre