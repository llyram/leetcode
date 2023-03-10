class Solution:
    def maxArea(self, height: List[int]) -> int:
        begin = 0
        end = len(height) - 1 
        area = -1
        
        while begin < end:
            area = max(area, min(height[begin], height[end])*(end-begin))
            
            if height[begin] > height[end]:
                end -= 1
            else:
                begin += 1
        
        return area
        