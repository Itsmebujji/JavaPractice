package com.vineeth;

import java.util.Arrays;
import java.util.Random;

public class ArraysQS {
	
	public int arraySum(int[] arr){
		int sum =0;
		for(int val: arr){
			sum+=val;
		}
		System.out.println(sum);
		return sum;
	}
	
	public void sameElements(int[] arr1, int[] arr2){
		if(arr1.length!=arr2.length){
			System.out.println("Element are not same");
		}
		boolean[] match = new boolean[arr2.length];
	    for (int i = 0; i < arr1.length; i++) {
	        boolean found = false;  // Reset for each element!
	        for (int j = 0; j < arr2.length; j++) {
	            if (arr1[i] == arr2[j] && !match[j]) {
	                match[j] = true;
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Arrays are NOT the same.");
	            return;
	        }
	    }
	    System.out.println("Arrays are the same.");
		
	}
	
	
	public void secondLargest(int[] arr) {
		int high = 0;
		int second = 0;
		for(int i=0;i<arr.length;i++){
			if(high<arr[i]){
				second = high;
				high = arr[i];
			}else{
				if(second<arr[i]){
					second = arr[i];
				}
			}
		}
		System.out.println(second);
	}
	
	
	public void arrSuffle(int[] arr){
		Random rd = new Random();
		int temp = 0;
		for(int i=arr.length-1;i>0;i--){
			 temp = rd.nextInt(i+1);
			 int n = arr[i];
			 arr[i] = arr[temp];
			 arr[temp] = n;
			 
		}
		for(int val : arr){
			System.out.print(val+" ");
		}
	}
	
	public void smallHigh(int[] arr){
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<arr.length;i++){   // 0 1, 34,23, 65,98
			if(max<arr[i]){
				max=arr[i];
			}else{
				if(min>arr[i]){
					min=arr[i];
				}
			}
		}
		System.out.println("Max: "+max+" & Min: "+min);
	}
	
	public void closestZeroPair(int[] arr){
		
		if(arr.length<2){
			return;
		}
		
		Arrays.sort(arr);
		 int left = 0;
	        int right = arr.length - 1;
	        int minSum = Integer.MAX_VALUE;
	        int element1 = arr[left];
	        int element2 = arr[right];

	        while (left < right) {
	            int sum = arr[left] + arr[right];

	            if (Math.abs(sum) < Math.abs(minSum) || 
	               (Math.abs(sum) == Math.abs(minSum) && sum > minSum)) {
	                minSum = sum;
	                element1 = arr[left];
	                element2 = arr[right];
	            }

	            if (sum < 0) {
	                left++;
	            } else {
	                right--;
	            }
	        }
	        
	        System.out.println("The two elements whose sum is closest to zero are: " + element1 + " and " + element2);
	        System.out.println("Their sum is: " + minSum);
	}
	
	public void permutations(char[] arr, int left, int right){
		if(left==right){
			System.out.println(new String(arr));
		}else{
			for(int i=left;i<=right;i++){
				swap(arr,left,i);
				permutations(arr,left+1,right);
				swap(arr,left,i);
			}
		}
	}
	
	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
	}
	
	public static void main(String[] args) {
		ArraysQS ar = new ArraysQS();
		char[] arr  = "ABC".toCharArray();
		ar.permutations(arr, 0, arr.length-1);
	}
}
