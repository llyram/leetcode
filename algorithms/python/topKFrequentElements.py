from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:        
        # return sorted(set(nums),key=nums.count,reverse=True)[:k]
        return [x for x,y in sorted(Counter(nums).items(), key = lambda kv:kv[1], reverse = True)][:k]