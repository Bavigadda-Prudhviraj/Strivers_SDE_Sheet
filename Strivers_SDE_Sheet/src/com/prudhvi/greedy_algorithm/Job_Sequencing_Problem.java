package com.prudhvi.greedy_algorithm;

import java.util.Arrays;

public class Job_Sequencing_Problem {
	/*
	
	This method is an implementation of the Job Scheduling problem, where the goal is to maximize the total profit by scheduling jobs with given deadlines and profits. 
	Each job takes one unit of time to complete, and only one job can be scheduled at a time.
	
	Time Complexity:
		The time complexity is O(n * max_deadline), where n is the number of jobs and max_deadline is the maximum deadline among all jobs. 
		The dominant factor is the nested loop, where each job is considered for each time slot within its deadline.

	Space Complexity:
		The space complexity is O(max_deadline) for the result array, where max_deadline is the maximum deadline among all jobs. 
		The space required is proportional to the maximum deadline.
	 */
	public int[] JobScheduling(Job arr[], int n) {
	    // Sort the jobs based on profit in descending order
	    Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

	    int maxi = 0;

	    // Find the maximum deadline among all jobs
	    for (int i = 0; i < n; i++) {
	        if (arr[i].deadline > maxi) 
	            maxi = arr[i].deadline;
	    }

	    int result[] = new int[maxi + 1];

	    // Initialize an array to store the job schedule, initially set to -1 for each slot
	    for (int i = 1; i <= maxi; i++) 
	        result[i] = -1;

	    int countJobs = 0, jobProfit = 0;

	    // Iterate through each job
	    for (int i = 0; i < n; i++) {
	        // Iterate through time slots from the job's deadline to 1
	        for (int j = arr[i].deadline; j > 0; j--) {
	            // If the current slot is available, schedule the job and update counts
	            if (result[j] == -1) {
	                result[j] = i;
	                countJobs++;
	                jobProfit += arr[i].profit;
	                break;
	            }
	        }
	    }

	    // Create the result array containing the count of scheduled jobs and total profit
	    int ans[] = new int[2];
	    ans[0] = countJobs;
	    ans[1] = jobProfit;
	    return ans;
	}

    
}
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
