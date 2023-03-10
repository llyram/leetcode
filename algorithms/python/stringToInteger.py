class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        flag = True       
        mynum=[]
        for i in range(len(s)):
            if s[i].isdigit() or ((s[i] == '-' or s[i] == '+') and flag):
                flag = False
                mynum.append(s[i])
            elif flag:
                return 0
            else:
                break
        myint = 0
        try:
            myint = int(''.join(mynum))
        except ValueError:
            pass
        min_int = -(2**31)
        max_int = 2**31 - 1
        
        if myint < min_int:
            return min_int
        elif myint > max_int:
            return max_int
        else:
            return myint