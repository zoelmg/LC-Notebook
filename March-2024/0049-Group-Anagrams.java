/*
[0049] - [Group Anagram] - [Medium]
 Completed Date :[March 29, 2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/group-anagrams/description/]
 
 My Pseudocode/Approach/Explanation: 

 Given a list of strings, return a list of list of strings, with each list being
 a unique anagram type and the strings that are of that type.

 Split each of the anagrams into chars[] and sort the array, then create a hashmap
 of <char[], list> with the chars being the type of anagram and the list
 being the strings. If the chars[] exist in the hashmap already, simply add 
 the string to the list. If not, create a new key with the chars[]
 
 */

 // My Code: 
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

 class Solution{
   public List<List<String>> groupAnagrams(List<String> input) {
      Map<char[], List<String>> result = new HashMap<>();

      for (String str : input) {
         char[] strArr = str.toCharArray();
         Arrays.sort(strArr);
         if (result.containsKey(strArr)) {
            result.get(strArr).add(str);
         } else {
            result.put(strArr, new ArrayList<>());
         }
      }

      return new ArrayList<>(result.values());
   }
 }



/*
 Learning Source: [N/A]
 [N/A]
*/


 // Revised Code: N/A



/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
    N/A

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   You can use ArrayList<>(initialize value) to initialize, also
   HashMap.value() gets the entire collection of values 

- What is the high level learned new approach? 
   N/A

- What is the runtime of this approach?
 Learned Runtime:
   O(n*k*log(k)):
      N is the number of strings in the input
      K is the maximum length of string in the input
      
      The for loop is iterating n times, and for each
      iteration, k*log(k) time is needed to sort the chars

- What is the space complexity of this approach?
      O(n), storing n elements from hashmap
      
- Most difficult part of this approach?
      N/A

 */


