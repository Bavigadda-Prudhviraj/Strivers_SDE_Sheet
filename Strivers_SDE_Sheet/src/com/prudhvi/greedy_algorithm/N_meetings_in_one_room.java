package com.prudhvi.greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

public class N_meetings_in_one_room {

	public static void main(String[] args) {
		int n = 6;
		int[]	start = {1,3,0,5,8,5};
		int[]	end =  {2,4,6,7,9,9};
		
		int maxMettings = maxMeetings(start, end, n);
		System.out.println(maxMettings);

	}
	/*
	The code efficiently solves the activity selection problem by sorting meetings based on end times and then iteratively selecting non-overlapping meetings. 
	It has a time complexity of O(N log N), where N is the number of meetings, due to the sorting step.
	
	Time Complexity:
		The time complexity is dominated by the sorting step, making it O(N log N), where N is the number of meetings.
	Space Complexity:
		The space complexity is O(N), where N is the number of meetings. The additional space is used to store the list of meetings.
	 */
	public static int maxMeetings(int start[], int end[], int n) {
		//Create a list meetings to store pairs of start and end times for each meeting.
	    List<int[]> meetings = new ArrayList<>();

	    // Create a list of meetings with their start and end times
	    for (int i = 0; i < start.length; i++) {
	        meetings.add(new int[]{start[i], end[i]});
	    }

	    // Sort the meetings based on their end times in ascending order
	    meetings.sort((a, b) -> Integer.compare(a[1], b[1]));

	    int maxNonOverlappingMeetings = 1;  // Initialize the maximum non-overlapping meetings count to 1
	    int lastMeetingEnd = meetings.get(0)[1];  // Initialize the end time of the first meeting

	    // Iterate through the sorted meetings
	    for (int i = 1; i < start.length; i++) {
	        // If the start time of the current meeting is greater than the end time of the last meeting
	        if (meetings.get(i)[0] > lastMeetingEnd) {
	            maxNonOverlappingMeetings++;  // Increment the count of non-overlapping meetings
	            lastMeetingEnd = meetings.get(i)[1];  // Update the end time of the last meeting
	        }
	    }

	    return maxNonOverlappingMeetings;  // Return the maximum number of non-overlapping meetings
	}


}
