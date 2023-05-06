class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

    
        keypad_dict = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        re = []

        def bfs(i, cur):
            if(i >= len(digits)):
                re.append(cur)
                return

            for c in keypad_dict[digits[i]]:
                bfs(i+1, cur+c)
        
        bfs(0, "")

        return re
