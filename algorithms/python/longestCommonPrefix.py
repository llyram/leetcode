class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        count = 0
        br = False
        for i in range(len(min(strs, key=len))):
            for word in strs:
                if word[i] != strs[0][i]:
                    br = True
                    break
            if br:
                break
            count += 1
        
        return strs[0][0:count]
        