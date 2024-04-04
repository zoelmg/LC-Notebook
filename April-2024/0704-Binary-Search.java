/*
[0704] - [Binary Search] - [Easy]
 Completed Date :[04/03/2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/binary-search/description/]
 

 My Pseudocode/Approach/Explanation: 
 Attempted Binary Search

 
 */

 // My Code: 

 class Solution {
   public int search(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;

       while (left <= right) {
           int middle = (left + right)/2;
           if (nums[middle] == target) {
               return middle;
           } else if (nums[middle] > target) {
               right = middle - 1;
           } else if (nums[middle] < target) {
               left = middle + 1;
           }
       }

       return -1;
       
   }
}



/*
 Learning Source: [Link]
 [Notes here]
*/


 // Revised Code:



/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
N/A
- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   When dividing by half, should - 1 for right and plus one for left
- What is the high level learned new approach? 
N/A
- What is the runtime of this approach?
O(logn)
- What is the space complexity of this approach?
O(1)
- Most difficult part of this approach?
N/A

 */


