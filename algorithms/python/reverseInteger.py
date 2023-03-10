class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        negative = ""
        if x < 0:
            negative = "-";
        ret = int(negative + str(abs(x))[::-1])
        if abs(ret) > 2**31:
            ret = 0
        return ret
        