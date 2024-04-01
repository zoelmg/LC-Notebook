/*
[0036] - [Valid Sudoku] - [Medium]
 Completed Date :[March 31 2024]
 Reviewed Date: [Date], ...
 Link: [https://leetcode.com/problems/valid-sudoku/description/]
 

 My Pseudocode/Approach/Explanation: 
My initial thought is using an array of HashSets, with each row, column, and 3x3 represented 
with an HashSet. However, by iterating through the entirety of the matrix, it will likely
take O(n^2) times. Not sure if this is the most optimal way to do it. Also, the input is
char[][] instead of int[][]
 
 */

 // My Code: N/A



/*
 Learning Source: 
 [https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/]
*/


 // Revised Code: A MORE OPTIMAL WAY
 import java.util.HashSet;
 import java.util.Set;

 class Solution {
   public boolean isValidSudoku(char[][] board) {
       Set<String> seen = new HashSet<>();
       
       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               char number = board[i][j];
               if (number != '.' ) {
                   if (!seen.add(number + " in row " + i) ||
                       !seen.add(number + " in column " + j) ||
                       !seen.add(number + " in row " + i/3 + "-" + j/3)) {
                           return false;
                       }
               }
           }
       }
       return true;

   }
}



/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
My initial approach is too inflexible with the data type. Instead of doing extra work
to convert chars into integers, it would have been better to changed up the chars to gaurantee
it is unique in a certain way, since that is the entire point of using HashSet.

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   N/A
- What is the high level learned new approach? 

- What is the runtime of this approach?
O(1) since we know all the boards are 9x9
- What is the space complexity of this approach?
O(1), same as above. The runtime of the code doesn't changes as input changes since input is stagnant
- Most difficult part of this approach?


 */


