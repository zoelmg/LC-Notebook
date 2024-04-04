/*
[0074] - [Search 2D Matrix] - [Medium]
 Completed Date :[04/03/2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/search-a-2d-matrix/description/]
 

 My Pseudocode/Approach/Explanation: 
 The runtime needs to be O(log(m*n))
 This is a 2d Binary search question
Since each of the row is in increasing order and the first number
of each row is greater than the previous row. Then I think performing two different
binary search, first for the first column, then again for one row would yield O(log(m*n))

For the first search, c1 <= target <= c2
 
 */

 // My Code: 
 class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
       int columnSt = 0;
       int columnEnd = matrix.length - 1;
       int middleColumn = -1;

       while (columnSt <= columnEnd) {
           middleColumn = (columnSt + columnEnd) / 2;
           if (matrix[columnSt][0] == target || matrix[columnEnd][0] == target) {
               return true;
           } else if (matrix[middleColumn][0] > target) {
               columnEnd = middleColumn - 1;
           } else if (matrix[middleColumn][0] < target) {
               columnSt = middleColumn + 1;
           }
       }

       int[] row = matrix[middleColumn];
       int left = 0;
       int right = row.length - 1;

      while (left <= right) {
          int middle = (left + right)/2;
          if (row[middle] == target) {
              return true;
          } else if (row[middle] > target) {
              right = middle - 1;
          } else if (row[middle] < target) {
              left = middle + 1;
          }
      }

       return false;
   }
}




/*
 Learning Source: 
 [https://leetcode.com/problems/search-a-2d-matrix/solutions/3874071/100-binary-search-video-simple-solution/]
*/


 // Revised Code:

 class Solution2 {
   public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length;
       int n = matrix[0].length;
       int left = 0;
       int right = m * n - 1;

       while (left <= right) {
           int mid = left + (right - left) / 2;
           int mid_val = matrix[mid/n][mid % n];

           if (mid_val == target) 
               return true;
           else if (mid_val < target)
               left = mid + 1;
           else
               right = mid - 1;
       }

       return false;
   }
}



/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
   My initial approach is wrong because I treated the rows and columns as two entities, 
   however, since the rows are ordered, technically, we can just treat the entire matrix as a 
   huge 1D array. Therefore, we just have to make sure when we are retrieving the matrix, we are
   correctly delegating the rows and column numbers. For instance, 
   1 2   3 4
   5 6   7 8
   9 10 11 12

   If our target is 7, then the matrix is [1][2] 
   n is the amount of columns
   so 7/4 = 1
   and 7%4 = 2
   So mid_val = matrix[mid/n][mid%n]
              = matrix[1][2]

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?

   N/A

- What is the high level learned new approach? 
   Treat 2D as 1D if the matrix is ordered

- What is the runtime of this approach?
 O(log(m*n)) because we are iterating over log of the entire size of the matrix

- What is the space complexity of this approach?
O(1), no additional storing needed

- Most difficult part of this approach?
Understanding dividing the matrix to get row and column. 

 */


