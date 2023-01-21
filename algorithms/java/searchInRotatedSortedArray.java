class Solution {
    public int search(int[] nums, int target) {
        int min = minIndex(nums);
        int leftTarget = binarySearch(nums, 0, min - 1, target);
        int rightTarget = binarySearch(nums, min, nums.length-1, target);

        if(leftTarget != -1) {
            return leftTarget;
        } else if (rightTarget != -1) {
            return rightTarget;
        } else {
            return -1;
        }

    }

    public int minIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + nums.length) % nums.length;
            int next = (mid + 1) % nums.length;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid - 1;
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        // System.out.println(left + " " + right);
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}