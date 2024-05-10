/*
[0022] - [Generate Parentheses - [Medium]
 Completed Date :[May 10th, 2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/generate-parentheses/submissions/]
 

 My Pseudocode/Approach/Explanation: 
   Could not come up with an approach with stack
 
 */

 // My Code: 



/*
 Learning Source: [https://leetcode.com/problems/generate-parentheses/solutions/2542620/python-java-w-explanation-faster-than-96-w-proof-easy-to-understand/]
   
   Key point is to use recursion: 
      We only want to add a closing parenthesis when there are less closing then opening. 
      Therefore, the recursion conditions for adding opening and closing parenthesis are different. 

      1. Check if the lenght of the string we are recursively adding is double the length of n 
         -> implies that the string is completed if true
      2. Check if left < n
         -> implies that we have not add all possible ( if true, so recurse again
      3. Check if right < left
         -> implies that we have not add all possible ) if true, so recurse again
            
*/


 // Revised Code:

 import java.util.List;
 import java.util.ArrayList;
 import java.lang.StringBuilder;

 class Solution {
   public List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      recurse(ans, 0, 0, new StringBuilder(), n);
      return ans;
   }

   public void recurse(List<String> list, int opening, int closing, StringBuilder currString, int n)  {
      if (opening >= n && closing >= n) {
         list.add(currString.toString());
         return;
      }

      if (opening < n) {
         recurse(list, opening + 1, closing, currString.append('('), n);
      }

      if (closing < opening) {
         recurse(list, opening, closing + 1, currString.append(')'), n);
      }
   }
}

class Solution2 {
   public List<String> generateParenthesis(int n) {
     List<String> ans = new ArrayList<>();
     recurse(ans, 0, 0, "", n);
     return ans;
  }

  public void recurse(List<String> list, int opening, int closing, String currString, int n)  {
     if (currString.length() == n * 2) {
        list.add(currString);
        return;
     }

     if (opening < n) {
        recurse(list, opening + 1, closing, currString + '(', n);
     }

     if (closing < opening) {
        recurse(list, opening, closing + 1, currString + ')', n);
     }
  }
}


/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
   StringBuilder is mutable, which can be desirable in certain problems but it is not in this
   problem. The mutable nature of it allowed for aliasing and prevented the creation of multiple
   different string. Therefore, the immuatable nature of String is better for this case.

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?

- What is the high level learned new approach? 
   Backtracking and using different conditions for opening and closing brackets. 

- What is the runtime of this approach?
   O(n^2), recursion is called twice within each single recursive call
- What is the space complexity of this approach?
   ?

- Most difficult part of this approach?
   Recursively thinking about building the different combination of strings. 

 */


