package com.prudhvi.binary_search;

public class Single_Element_In_Sorted_Array {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));

	}

	/**
	 * Finds the single non-duplicate element in a sorted array where every other element appears twice.
	 *
	 * @param nums The sorted array with each element appearing twice except for one.
	 * @return The single non-duplicate element.
	 * @TimeComplexity The time complexity is O(log N) due to binary search.
	 * @SpaceComplexity The space complexity is O(1) as no extra space is used.
	 */
	public static int singleNonDuplicate(int[] nums) {
		// Base cases for arrays of size 1 or 2
		if (nums.length == 1 || nums[0] != nums[1])
			return nums[0];

		if (nums[nums.length - 1] != nums[nums.length - 2])
			return nums[nums.length - 1];

		// Binary search
		int low = 0;
		int high = nums.length - 1;
		int singleElement = -1;

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			// Check if the mid element is the single non-duplicate
			if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
				singleElement = nums[mid];
				break;
			}

			// Adjust mid based on the adjacent elements
			if (nums[mid] == nums[mid - 1]) {
				mid = mid - 1;
			}

			// Update the search space based on the parity of mid
			if (mid % 2 == 0) {
				low = mid + 2;
			} else {
				high = mid - 1;
			}
		}

		return singleElement;
	}


}
