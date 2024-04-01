/*
0001 - Two Sum - Easy
 Completed Date : March 28 2024
 Reviewed Date: [Date], ...
 Link: https://leetcode.com/problems/two-sum/description/
 

 My Pseudocode/Approach/Explanation: 
The first thing that I have thought of using bruteforce to iterate through 
the array twice, with the outerloop holding on one integer and the inner loop
being added onto the inner integer. Break once we find and return two sums

However, there exist a more efficient ways to do this. Using a HashMap
with the Key being the original number and the value being the difference that the value
need in order to sum up the desire integer. 
 
 */

 // My Code: 
import java.util.HashMap;

class Solution{
   public int[] twoSum(int[] arr, int n) {
      HashMap<Integer, Integer> diff = new HashMap<>();
      for (int i : arr) {
         if (diff.containsKey(n - i)) {
            return new int[] {i, n - i};
         } else {
            diff.put(i, n - i);
         }
      }

      return new int[0];
   }
}



/*
 Learning Source: [N/A]
 [N/A]
*/


 // Revised Code:

 class Solution2 {
   public int[] twoSum(int[] arr, int n) {
      HashMap<Integer, Integer> diff = new HashMap<>();
      for (int i  = 0; i < n; i++) {
         if (diff.containsKey(n - arr[i])) {
            return new int[] {n - arr[i], i};
         } else {
            diff.put(arr[i], i);
         }
      }

      return new int[0];
   }
}



/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
   The approach was right but it was not what teh questions were asking for
   The question asked for the INDEX of the two sums and not the numbers themselves.
   Also, if they were only asking for the numbers, then use a Set instead of HashMap

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   Fill an array with {} 

- What is the high level learned new approach? 
   N/A

- What is the runtime of this approach?
   The runtime of this approach is O(n) as we are iterating through the 
   the array once

- What is the space complexity of this approach?
   The space complexity of this approach is also O(n) since we are storing n
   elements into the HashMap
   
- Most difficult part of this approach?
   N/A

 */


