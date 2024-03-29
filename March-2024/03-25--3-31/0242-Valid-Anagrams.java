/*
0242 - Valid Anagram - Easy
Completed Date : March 28th, 2024
Reviewed Date: [Date], ...
Link: [https://leetcode.com/problems/valid-anagram/description/]
 

My Pseudocode/Approach/Explanation: 

This question is very similar to the last question, but there are some 
questions, does t needs to be exactly the length of s? If so, then
I would approach the problem by counting the occurences of letters in 
each strings to see if the number of occurences are the same. 
 */


// My Attempt:
import java.util.HashMap;

class Solution {
   public boolean validAnagram(String s, String t) {
      HashMap<Character, Integer> countS = new HashMap<>();
      HashMap<Character, Integer> countT = new HashMap<>();
      if (s.length() != t.length()) {
        return false;
      }

      for (int i = 0; i < s.length(); i++) {
        if (countS.containsKey(s.charAt(i))){
            countS.put(s.charAt(i), countS.get(s.charAt(i)) + 1);
        } else {
            countS.put(s.charAt(i), 1);
        }
      }

      for (int i = 0; i < s.length(); i++) {
        if (countT.containsKey(s.charAt(i))){
            countT.put(s.charAt(i), countT.get(s.charAt(i)) + 1);
        } else {
            countT.put(s.charAt(i), 1);
        }
      }
      
      //... not finished cuz too efficient
      return false;
      
   }
 }
 
 

 /*
  Learning Source: [https://leetcode.com/problems/valid-anagram/solutions/3687854/3-method-s-c-java-python-beginner-friendly/]
  The above source shows 2 ways of solving the problem
  1. Splitting the strings into chars in java and then sort; if they sorted are equal then 
  they are anagram of each other
  2. Using a HashTable, increment for each in first string and decrement for each
  in second string
 */
 
 
// Revised Code:

class SolutionRevised {
   public boolean validAnagram(String s, String t) {
      HashMap<Character, Integer> count = new HashMap<>();
      if (s.length() != t.length()) {
        return false;
      }

      for (int i = 0; i < s.length(); i++) {
        count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
      }

      for (int i = 0; i < t.length(); i++) {
        count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
      }

      for (Integer x : count.values()) {
        if (x != 0) {
            return false;
        }
      }

      return true;
   }
 }

 
 
 
 /*
  # Reflections/Key Notes 
 
 - Why was my initial approach wrong?
    My initial approach was in the correct direction but too much space complexity
    because I was treating the occurences of each character in the two strings as
    two different set; however, if you think about how the alphabet is the alphabet, 
    all we need to do is have one set of alphabet and decrement/increment accordingly. 

 - What new syntax/library did I learn? Why should I use these 
    new libraries and syntax?
    N/A

 - What is the high level learned new approach? 
    When having to count the same type of data set across multiple sources, try implementing
    one collective count first. 

 - What is the runtime of this approach?
    O(n) because we are iterating through the two strings once and the hashmap of n element once. 
    and accessing an item in the HashSet and or using contains() only require O(1)

 - What is the space complexity of this approach?
    O(n); HashMap takes n spaces where n is the unique letters that appeared in s and t
    
 - Most difficult part of this approach?
    N/A
 
 
  */
 
 
 