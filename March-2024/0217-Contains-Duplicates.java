/*
0217 - Contains-Duplicates - Easy
Completed Date : March 28th, 2024
Reviewed Date: [Date], ...
Link: [https://leetcode.com/problems/contains-duplicate/description/]
 

My Pseudocode/Approach/Explanation: 

To do this, my first thought is to use an HashSet
If the value is in not in there, add the value
If the value is in there, return false
 */


 // My attempt:
import java.util.HashSet;
import java.util.Set;

class Solution {
   public boolean containDup(int[] arr) {
      Set<Integer> unique = new HashSet<>();
      for (int i = 0; i < arr.length; i++) {
         if (unique.contains(arr[i])) {
            return true;
         } else {
            unique.add(arr[i]);
         }
      }
      return false;
   }
 }



/*
 Learning Source: [Link]
 [Notes here]
*/


 // Code:



/*
 # Reflections/Key Notes 

- Why was my initial approach wrong?
   Approach was correct
- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   N/A
- What is the high level learned new approach? 
   N/A
- What is the runtime of this approach?
   O(n) because we are iterating through the given arr exactly once in the worse case
   and accessing an item in the HashSet and or using contains() only require O(1)
- What is the space complexity of this approach?
   O(n); HashSet takes n spaces where n is the item in arr[]
- Most difficult part of this approach?
   N/A


 */


