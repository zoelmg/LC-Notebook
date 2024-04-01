/*
[0128] - [Longest Consecutiev Sequence] - [Medium]
 Completed Date :[March 31 2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/longest-consecutive-sequence/description/]
 

 My Pseudocode/Approach/Explanation: 
Any built-in sort would not fit the time constraint of O(n) since it defaults to O(nlogn)
Use a HashSet to record all the numbers, and iterate through the numbers.
For each number, check if the number is the beginning sequence by asking if the Set 
contains i - 1. If it does, start a while loop to keep incrementing sequence count until
the set no longer contains the next consecutive sequence. Compare the current count to the
overall count and return the max. 
 */

 // My Code: 

 import java.util.Set;
 import java.util.HashSet;

 class Solution {
   public int longestConsecutive(int[] nums) {
       if (nums.length == 0) {
           return 0;
       }
       
       Set<Integer> hash = new HashSet<>();
       for (int i : nums) hash.add(i);
       int count = 1;

       for (int i = 0; i < nums.length; i++) {
           int curr = nums[i];
           if (!hash.contains(curr - 1)) {
               int newCount = 1;
               int next = curr + 1;
               while (hash.contains(next)) {
                   newCount++;
                   next = next + 1;
               }
               
               if (newCount > count) {
                   count = newCount;
               }
           }
       }

       return count;
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
   Thinking in terms of HashMap instead of an HashSet.
- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   Using a HashSet for O(1) lookup time. 
- What is the high level learned new approach? 
- What is the runtime of this approach?
   The runtime of this approach is O(n). Although there is a second while loop
   nested inside of the for-loop, the reason why it is not O(n^2) time is because
   the while loop only execute when the condition that this number is the first sequence
   is met. Therefore, we are not iterating through the rest of the array again with each
   number that we are currently on. 
- What is the space complexity of this approach?
   The space complexity for this approach is O(n). We uses a Hashset that contains n element 
   from the input.
- Most difficult part of this approach?

 */


