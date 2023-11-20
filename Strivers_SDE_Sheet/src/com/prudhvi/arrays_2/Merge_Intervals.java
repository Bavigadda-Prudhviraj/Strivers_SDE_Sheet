package com.prudhvi.arrays_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {

	public static void main(String[] args) {
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		int[][] mergedIntervals=merge(intervals);
		System.out.println(Arrays.deepToString(mergedIntervals));

	}
	/*
	The merge method takes an array of intervals where each interval is represented as an array [start, end]. 
	It merges overlapping intervals and returns a new array of non-overlapping intervals.
	
	Time Complexity:
		The time complexity is O(n log n) due to the sorting step, where n is the number of intervals. 
		The subsequent linear pass through the sorted intervals is O(n).
	
	Space Complexity:
		The space complexity is O(n) for the result list. 
		The sorting and other variables use constant space.
	 */
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }
        // Sort intervals based on start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // List to store merged intervals
        List<int[]> mergeList = new ArrayList<>();
        // Initialize start and end with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];
        // Merge overlapping intervals
        for (int i = 1; i < n; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            // Overlapping intervals, update the end
            if (end >= currentStart) {
                end = Math.max(end, currentEnd);
            } 
            // Non-overlapping interval, add the merged interval and update start and end
            else {
            	// Add the merged interval to the result list
                mergeList.add(new int[]{start, end});
                // Update start and end for the next interval
                start = currentStart;
                end = currentEnd;
            }
        }
        // Add the last merged interval
        mergeList.add(new int[]{start, end});
        int[][] mergeArr = new int[mergeList.size()][2];
        // Convert List to 2D array
        for (int i = 0; i < mergeList.size(); i++) {
            mergeArr[i] = mergeList.get(i);
        }
        return mergeArr;
    }

}
