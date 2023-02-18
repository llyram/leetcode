class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        l = len(arr)
        memo = []
        count = 0
        for i in range(len(arr)):
            s = arr[i]
            if s in memo:
                continue
            if s not in arr[i+1:]:
                count += 1
                if count == k:
                    return s
            else:
                memo.append(s)
        
        return ''