package com.vineeth;

public class BinarySearch {
	public int[] arr;
	public int target;
	
	public BinarySearch(int[] arr, int target){
		this.arr=arr;
		this.target=target;
	}
	
	public void search(){  
		int high = this.arr.length-1;
		int low = 0;
		int mid = (high-low)/2;
		
		while(low<=high){
			if(this.target==arr[mid]){
				System.out.println("Target is found at index: "+ mid);
				break;
			}else if(target<arr[mid]){
				high = mid-1;
			}else{
				low = mid+1;
			}
			mid=low+(high-low)/2;
		}
	}
	
}
