/*
[0347] - [Top K Frequent Elements] - [Medium]
 Completed Date :[March 30, 2024]
 Reviewed Date: [], ...
 Link: [https://leetcode.com/problems/top-k-frequent-elements/]
 

 My Pseudocode/Approach/Explanation: 
Use a hashmap to count the occurences of each number, sort, and then 
take the top kth element. However, this approach runs in (nlogn) time,
and can be acheived in O(n) time.  
 */

 // My Code: 

 import java.util.HashMap;
 import java.util.Map;
 import java.util.List;
 import java.util.ArrayList;

 class Solution {
   public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();

       for (int i : nums) {
           if (map.containsKey(i)) {
               map.put(i, map.get(i) + 1);
           } else {
               map.put(i, 1);
           }
       }

       List<Integer> list = new ArrayList<>(map.keySet());
       list.sort((a,b) -> map.get(b) - map.get(a));

       int res[] = new int[k];
       for (int i = 0; i < k; i++) {
           res[i] = list.get(i);
       }

       return res;
   }
}



/*
 Learning Source: [https://leetcode.com/problems/top-k-frequent-elements/]
*/


 // Revised Code:
 class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
 
        for (int i : nums) {
            if (map.containsKey(i)) {map.put(i, map.get(i) + 1);} 
            else {map.put(i, 1);}
        }


        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList<>();
 
        for (Integer i : map.keySet()) {
                bucket[map.get(i)].add(i);
        }

        int[] result = new int[k];
        int index = 0;
    
        for (int i = bucket.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < bucket[i].size(); j++) {
                if (index == k) return result;
                result[index++] = bucket[i].get(j);
            }
    }
 
    return result;
    }
 }



/*
 # Reflections/Key Notes 

Reflection and key notes goes here
- Why was my initial approach wrong?
  Initial approach was not the most optimal since it introduces the 
  time complexcity needed for sorting. 

- What new syntax/library did I learn? Why should I use these 
   new libraries and syntax?
   Learned a new way of manipulating arrays and arraylist. Did not know
   that you can have an array where elements are unfixed structures like
   the arraylist. 

- What is the high level learned new approach? 
 Using Bucket Sort instead of using the built in sort method (quicksort, insertion sort,
 mergesort). Bucket sort divides an array's element into several buckets, and placing
 each element of the input array into its corresponding buckets. 

 Here, in our revised approach, every bucket contains an arraylist that will hold
 all the elements that had a frequency of the bucket's index. For instance, if 
 an element appeared once, then it will be added to the bucket at bucket[1]. 

 However, since the problem statement says that our answer are gauranteed to be 
 unique, it means that the amount of frequencies of element must be unique. For example,
 [1, 1, 1, 2, 2, 2, 4, 3, 3, 3] would not be a valid input since it means that
 the output could be [1,2], [2, 3] or [1, 3]. Therefore, we can assume that
 only one element will be put into each individual bucket, which is why
 the inner array of j will actually only ever add 1 element to result. 


- What is the runtime of this approach?
  This runtime of the revised approach is O(n), where n is the number of 
  elements in the given input. 


- What is the space complexity of this approach?
 The space complexity of this approach is O(n)

- Most difficult part of this approach?
 Understanding how to manipulate bucket sort and understanding that the frequencies of
 the element are the key traits to divide the bucket into. 

 */


