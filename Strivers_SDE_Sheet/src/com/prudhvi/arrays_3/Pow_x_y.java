package com.prudhvi.arrays_3;

public class Pow_x_y {

	public static void main(String[] args) {
		double a=2;
		int b=6;
		double aPowerB=myPow(a, b);
		System.out.println(aPowerB);

	}
	/*
	Method Overview:
		-The method uses an iterative approach to calculate the power of A raised to the integer power B efficiently.
		-It utilizes the fact that any power B can be expressed as a sum of powers of 2 (binary representation of B).
		-If the current power is even, the code squares the base A and divides the power by 2.
		-If the current power is odd, the code multiplies the result by the current base A and decreases the power by 1 to make it even.
		-The loop continues until the power becomes 0.
		-The result is inverted if the original power B was negative.

	Time Complexity:
		The time complexity of this algorithm is O(log B) because the loop runs until the power becomes 0, and in each iteration, the power is reduced by half.
	Space Complexity:
		The space complexity is O(1) as the algorithm uses a constant amount of extra space regardless of the input.
	 */
	public static double myPow(double A, int B) {
		 // Initialize the result variable to 1.0.
		double aPowerB=1;
		// Get the absolute value of B, handling cases where B is negative.
		long power=0<B?-(long)B:B;
		// Iterate until the power becomes 0.
		while(power>0) {
			//// If the current power is even, square the base A and divide the power by 2.
			if(power%2==0) {
				A = A * A;
				power = power/2;
			}
			// If the current power is odd, multiply the result by the current base A
            // and decrease the power by 1 to make it even.
			else {
				aPowerB = aPowerB * A;
				power=power-1;
			}
			
		}
		// If the original power B was negative, invert the result to handle cases where
	    // the power is a fraction.
		aPowerB=B<0?1/aPowerB:aPowerB;
		// Return the final result of A raised to the power of B.
		return aPowerB;
		
	}

}
