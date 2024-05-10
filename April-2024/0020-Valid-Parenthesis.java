/*
[0020] - [Valid Parentheis] - [Easy]
 Completed Date :[04-07-2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/valid-parentheses/]
 

 My Pseudocode/Approach/Explanation: 
 Patterns can be nested
 so {} is valid
 but so is {[]}

 Use a stack
 push the current char onto the index if its a opening char, 
 pop the last char out if its a closing char
 if the opening char doesn't match the closing char, return false


 
 */

 // My Code: 

 import java.util.Stack;


 class Solution {
   public boolean isValid(String s) {
   Stack<Character> openStack = new Stack<>();

   for (int i = 0; i < s.length(); i++) {
       char currChar = s.charAt(i);
       if (currChar == '(' || currChar == '[' || currChar== '{') {
               openStack.push(currChar);
       } else if (currChar == ']' || currChar == '}' || currChar== ')') {
           if (openStack.empty()) return false;
           char lastChar = openStack.pop();

           if (currChar == ']' && lastChar != '[') return false;
           else if (currChar == '}' && lastChar != '{') return false;
           else if (currChar == ')' && lastChar != '(') return false;
       }


   }

   if (openStack.empty()) {
       return true;
   } else {return false;}
   
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
N/A
- What is the high level learned new approach? 
N/A
- What is the runtime of this approach?
N/A
- What is the space complexity of this approach?
N/A
- Most difficult part of this approach?
N/A

 */


