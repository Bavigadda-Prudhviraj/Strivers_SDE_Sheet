package com.prudhvi.binary_search;

public class Median_of_Two_Sorted_Arrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2}, nums2 = {3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

	/**
	 * Finds the median of two sorted arrays.
	 *
	 * @param arr1 The first sorted array.
	 * @param arr2 The second sorted array.
	 * @return The median of the combined sorted arrays.
	 * @TimeComplexity The time complexity is O(log(min(n1, n2))), where n1 and n2
	 *                 are the lengths of the two arrays.
	 * @SpaceComplexity The space complexity is O(1), as the function uses constant
	 *                  space.
	 */
	public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
		// Ensure arr1 is the smaller array
		if (arr2.length < arr1.length)
			return findMedianSortedArrays(arr2, arr1);

		int n1 = arr1.length;
		int n2 = arr2.length;
		int low = 0;
		int high = n1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			// Calculate the cuts for partitioning
			int firstCut = mid;
			int halfElements = (n1 + n2 + 1) / 2;
			int secondCut = halfElements - firstCut;

			// Get elements around the cuts
			int left1 = firstCut <= 0 ? Integer.MIN_VALUE : arr1[firstCut - 1];
			int left2 = secondCut <= 0 ? Integer.MIN_VALUE : arr2[secondCut - 1];
			int right1 = firstCut >= n1 ? Integer.MAX_VALUE : arr1[firstCut];
			int right2 = secondCut >= n2 ? Integer.MAX_VALUE : arr2[secondCut];

			// Check if the cuts are correct
			if (left1 <= right2 && left2 <= right1) {
				int evenOrOdd = (n1 + n2) % 2;

				// Calculate median for even and odd total elements
				if (evenOrOdd == 0) {
					double max = (double) (Math.max(left1, left2));
					double min = (double) (Math.min(right1, right2));

					return (double) ((max + min) / 2);
				} else {
					return (double) (Math.max(left1, left2));
				}
			} else if (left1 > right2) {
				// Adjust the partition in the first array
				high = mid - 1;
			} else {
				// Adjust the partition in the first array
				low = mid + 1;
			}
		}

		// Default return if arrays are not sorted or there are other issues
		return 0.0;
	}


}
