class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[i+j] = nums1[i];
                i++;
            } else {
                arr[i+j] = nums2[j];
                j++;
            }
        }

        if (i < nums1.length) {
            for(int k=i+j; k < arr.length; k++, i++) {
                arr[k] = nums1[i];
            }
        } else {
            for(int k=i+j; k < arr.length; k++, j++) {
                arr[k] = nums2[j];
            }
        }

        if (arr.length % 2 == 0) {
            return (double)(arr[arr.length/2 - 1] + arr[arr.length/2]) / 2;
        } 

        return arr[arr.length/2];
    }
}