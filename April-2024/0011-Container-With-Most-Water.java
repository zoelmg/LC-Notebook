/*
[0011] - [Containers with Most Water] - [Medium]
 Completed Date :[April 3rd 2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/container-with-most-water/description/]
 

 My Pseudocode/Approach/Explanation: 
 After an initial reading the question, there seems to be two important factors
 that we desire: 1) the maximum amount of water from each indices while 2) the beginning
 and ending needs to encompass most of the amount of water. 

 We can start with the left or right side, and shrink the container using a greedy rule
 to see can get a larger amount of water. 
 
 */

 // My Code: 
 // Version 1: 
 class Solution {
   public int maxArea(int[] height) {
       int totalSum = 0;
       int left = 0;
       int right = height.length - 1;

       while (left <= right) {
           int currSum = 0;
           int minHeight = Math.min(height[left], height[right]);

           for (int i = left; i <= right; i++) {
               if (height[i] >= minHeight) {
                   currSum+= minHeight;
               } else {
                   currSum+= height[i];
               }
           }

           //if (currSum)
       }
       return 0;
   }
}

//realized the above method won't work because I am simultaneously shrinking
// both the right and left side, which wipes out edge cases



/*
 Learning Source: [https://leetcode.com/problems/container-with-most-water/solutions/3701708/best-method-c-java-python-beginner-friendly/]
*/


 // Revised Code:
 class Solution2 {
   public int maxArea(int[] height) {
       int left = 0;
       int right = height.length - 1;
       int maxWater = 0;

       while (left < right) {
           int currWater = Math.min(height[left], height[right]) * (right - left);
           maxWater = Math.max(maxWater, currWater);

           if (height[left] < height[right]) {
               left++;
           } else {
               right--;
           }
       }
       return maxWater;
   }
}


/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
  I was shrinking both side at the same time, but I should only shrink
  if I know it might optimize the area further, which is why we have to 
  decide which side to move the pointer

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax? 
   N/A

- What is the high level learned new approach? 
   This is a greedy approach; we are trying to optimize the area, so 
   we are keeping the overall max or changing it to the curr max

- What is the runtime of this approach?
   O(n), the worse case is that left == right 

- What is the space complexity of this approach?
  O(1), no additional storing was needed

- Most difficult part of this approach?
  N/A

 */


