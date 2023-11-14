package com.prudhvi.arrays_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//question URL: https://leetcode.com/problems/pascals-triangle/description/
public class PascalsTriangle {

	public static void main(String[] args) {
		int numsRows=6;
		List<List<Integer>> pascalsTriangle=generate(numsRows);
		for (Iterator<List<Integer>> iterator = pascalsTriangle.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

	}
/*
	The time and space complexity of the code for generating Pascal's Triangle up to `numRows` can be analyzed as follows:
	1. **Time Complexity:**
		   - The time complexity is O(numRows^2).
		   - For each row from 1 to `numRows`, the `generate` method calls the `nThPascalsRow` method, which involves iterating through each column in the row. 
		     The inner loop has a maximum of `row - 1` iterations.
		   - Therefore, the time complexity is roughly proportional to the sum of the first `numRows` positive integers, which is O(numRows^2).
	
	2. **Space Complexity:**
		   - The space complexity is O(numRows^2).
		   - The space required to store Pascal's Triangle is proportional to the number of elements in the triangle. In this case, the number of elements is roughly (numRows^2)/2, and as we drop constant factors, the space complexity is O(numRows^2).
		   - The primary contributor to space complexity is the list of lists (`pascalsTriangle`) used to store the entire triangle.
	In summary, both the time and space complexity of the provided code are quadratic in terms of the number of rows (`numRows`).
 */
	public static List<List<Integer>> generate(int numRows) {
		//Initializes the list to store the rows of Pascal's Triangle.
        List<List<Integer>> pascalsTriangle=new ArrayList<>();
        // Iterates from the first row to the specified number of rows.
        for(int i=1;i<=numRows;i++){
        	//Initializes a list to store the elements of the current row.
            ArrayList<Integer> nthRow=new ArrayList<>();
            nThPascalsRow(i,nthRow);// Calls the helper function to populate the nth row.
            pascalsTriangle.add(nthRow);// Adds the nth row to the overall triangle.
        }
        return pascalsTriangle;//Returns the entire Pascal's Triangle.
    }
    public static void nThPascalsRow(int row,ArrayList<Integer> list){
        list.add(1);//Adds the first element of each row (always 1).
        int element=1;// Initializes the current element.
        // Iterates from the second element to the last in the current row.
        for(int col=1;col<row;col++){
            element=element*(row-col);//Updates the element by multiplying it by the remaining row positions.
            element=element/col;//Divides the element by the current column position.
            list.add(element);//Adds the calculated element to the row list.
        }
    } 

}
/*
	 we can expect 3 different type of formats in this question in the interview
		 1.print element when row and col is given:
		 2.print nTh row of the pascalRow:
		 3.print entire Pascal's triangle:
		 
	Type 1:when row and col is given
		   There is direct formula for this: NcR=n!/(r!*(n-r)!),but time complexity is huge
		   n=row-1
		   r=col-1
		   
		   row=5,col=2
		   (5*4*3*2*1)
		   ------------		here (n-r) factorial values will get cancled because is common denominator as will as numrator
		   (2*1)*(3*2*1)
		   
		   so we can reduce those iterations just doing r iterations in denominator and multiply r values from decreasing 1 r times
		   code
		   funciton nCr(row,col){
		   	res=1;
		   	for(int i=0;i<row;i++){
		   		res=res*(row-i);
		   		res=res/(i+1)
		   	}
		   }
	Type 2:when we have to print nTh row 
			public static void nThPascalsRow(int row,ArrayList<Integer> list){
        		list.add(1);
        		int element=1;
        		for(int col=1;col<row;col++){
            		element=element*(row-col);
            		element=element/col;
            		list.add(element);
        		}
    		} 
    Type 3:print entire triangle code is above
*/