package com.prudhvi.greedy_algorithm;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;;
public class Maximum_Activities {

	public static void main(String[] args) {
	List<Integer> start = new ArrayList<>(Arrays.asList(1,6,2,4));	
	List<Integer> end   = new ArrayList<>(Arrays.asList(2,7,5,8 ));		
	
	int maxActivities = maximumActivities(start, end);
	System.out.println(maxActivities);

	}
	/*
	This method calculates the maximum number of non-overlapping activities that can be performed given their start and end times. 
	It uses a greedy approach, sorting the activities by their end times and then selecting activities that do not overlap.
	
	Time Complexity:
		The time complexity of this algorithm is dominated by the sorting step, which is O(N log N), where N is the number of activities.

	Space Complexity:
		 The space complexity is O(N) due to the additional space required to store the Activities objects. The space complexity is linear with respect to the number of activities.
	 */
	public static int maximumActivities(List<Integer> start, List<Integer> end) {
	    int n = start.size();

	    // Create a list of Activities objects with start and end times
	    List<Activities> activities = IntStream.range(0, n)
	            .mapToObj(i -> new Activities(start.get(i), end.get(i)))
	            .collect(Collectors.toList());

	    //The activities are sorted first based on end times in ascending order and then based on start times.
	    activities.sort(Comparator.comparing((Activities a) -> a.end).thenComparing(a -> a.start));

	    int maxActivities = 1;  // Initialize the maximum number of activities to 1
	    int lastActivityEndTime = activities.get(0).end;  // Initialize the end time of the first activity

	    // Iterate through the sorted activities
	    for (int i = 1; i < n; i++) {
	        // If the start time of the current activity is greater than or equal to the end time
	        // of the last activity, it can be performed without overlapping
	        if (activities.get(i).start >= lastActivityEndTime) {
	            lastActivityEndTime = activities.get(i).end;  // Update the end time of the last activity
	            maxActivities++;  // Increment the count of non-overlapping activities
	        }
	    }

	    return maxActivities;  // Return the maximum number of non-overlapping activities
	}

	


}
//Class representing an activity with start and end times
	class Activities {
	    int start;
	    int end;

	    Activities(int start, int end) {
	        this.start = start;
	        this.end = end;
	    }
	}