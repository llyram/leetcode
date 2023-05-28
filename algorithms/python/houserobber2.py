class Solution:
    def rob(self, nums: List[int]) -> int:

        def houserobber(nums):
            rob1, rob2 = 0, 0
            for i in range(len(nums)):
                temp = max(rob1 + nums[i], rob2)
                rob1 = rob2
                rob2 = temp
            
            return rob2
        
        return max(nums[0], houserobber(nums[1:]), houserobber(nums[:-1]))
        
