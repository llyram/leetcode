class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        nums1.extend(nums2)
        nums1.sort()
                
                
        mid = len(nums1)//2
        if len(nums1) % 2 == 0:
            median = (nums1[mid - 1] + nums1[mid]) / 2.0
        else:
            median = nums1[mid]
        
        return median
                