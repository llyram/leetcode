class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        
        result = 0
        
        for i in range(len(str(num)) - k + 1):   
                curr = int(str(num)[i:i+k]) 
                
                if curr != 0 and num % curr == 0:
                    print(i)
                    result += 1
        
        return result