/*
[0150] - [Evaluate Reverse Polish Notation] - [Medium]
 Completed Date :[May 7th 2024]
 Reviewed Date: [Date], ...
 Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 

 My Pseudocode/Approach/Explanation: 
   The first thing that comes to mind is to create a stack that will store the numbers to be 
   processed. Iterate through the array, if the curr element cannot be converted to an integer, 
   then push to stack; if it can be converted, then pop two off the stack and performs the element.

   The above approach is under the constraint and assumption that all tokens are either +, /, *, -
   or an integer

   Division is floored
 
 */

// My Code: 
import java.util.Stack;

class Solution {
   public int evalRPN(String[] tokens) {
      Stack<Integer> numbers = new Stack<>();

      for (String token : tokens) {
         int num;
         try {
            num = Integer.parseInt(token);

         } catch (NumberFormatException e) {
            num = -300;
         }

         if (num != -300) {
            numbers.push(num);
         } else {
            switch (token) {
               case "*":
                  num = numbers.pop() * numbers.pop();
                  numbers.push(num);
                  break;
               case "+":
                  num = numbers.pop() + numbers.pop();
                  numbers.push(num);
                  break;
               case "-":
                  int subtrahead = numbers.pop();
                  int minuend = numbers.pop();
                  num = minuend - subtrahead;
                  numbers.push(num);
                  break;
               case "/":
                  int divisor = numbers.pop();
                  int dividend = numbers.pop();
                  num = (int) Math.floor(dividend / divisor);
                  numbers.push(num);
                  break;
               default:
            }
         }
      }

      return numbers.pop();
   }
}

/*
 * Learning Source: [Link]
 * [Notes here]
 */

// Revised Code:
class Solution2 {
   public int evalRPN(String[] tokens) {
      Stack<Integer> numbers = new Stack<>();

      for (String token : tokens) {
         int num;
         switch (token) {
            case "*":
               num = numbers.pop() * numbers.pop();
               numbers.push(num);
               break;
            case "+":
               num = numbers.pop() + numbers.pop();
               numbers.push(num);
               break;
            case "-":
               int subtrahead = numbers.pop();
               int minuend = numbers.pop();
               num = minuend - subtrahead;
               numbers.push(num);
               break;
            case "/":
               int divisor = numbers.pop();
               int dividend = numbers.pop();
               num = (int) Math.floor(dividend / divisor);
               numbers.push(num);
               break;
            default:
               numbers.push(Integer.parseInt(token));
         }
      }

      return numbers.pop();
   }
}

/*
 * # Reflections/Key Notes
 * 
 * Reflection and key notes goes here
 * - Why was my initial approach wrong?
 *    Takes too much time complexity trying and catching. 
 *    The problem statement already said that it was going to be one of the operator
 *    or a number, so just treat the number as the default case instead of catching. 
 * 
 * - What new syntax/library did I learn? Why should I use these
 * new libraries and syntax?
 *    N/A
 * - What is the high level learned new approach?
 *    N/A
 * - What is the runtime of this approach?
 *    O(n), iterating through the array once
 * 
 * - What is the space complexity of this approach?
 *    O(n), the stack could be as big as the array
 * 
 * - Most difficult part of this approach?
 *    N/A
 * 
 */
