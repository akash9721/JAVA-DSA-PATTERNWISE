package com.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveAllZeroEnd {
	public static void main(String[] args) {
		List<Integer> number=List.of(1,0,-3,0,5,-2,0,8,0,-4);
		
		Map<Boolean, List<Integer>> allNum = number.stream().collect(Collectors.partitioningBy(e->e==0));
		allNum.get(false).forEach(s->System.out.print(s+" "));
		allNum.get(true).forEach(s->System.out.print(s+" "));
		
		
		System.out.println("\nusing second method");
		List<Integer> result = Stream.concat(number.stream().filter(x->x!=0), number.stream().filter(x->x==0)).collect(Collectors.toList());
		System.out.println(result);
	}

}




class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
           if(nums[i]!=0){
            arr[j++]=nums[i];
           }
        }
        for(int i=0;i<n;i++){
            nums[i]=arr[i];
        }
    }
}


#using 2 pointer

class Solution {
     public void moveZeroes(int[] nums) {
       // move all non zero to left
       int left=0;
       for(int right=0;right<nums.length;right++){
        if(nums[right]!=0){
            int temp=nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;
         }
       }
    }
}


Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

