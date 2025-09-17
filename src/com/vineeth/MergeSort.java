package com.vineeth;

public class MergeSort {
	public int[] mergeSortArr;
	
	
	public void mergeSort(int[] arr){
		sort(arr);
		for(int val : arr){
			System.out.print(val+" ");
		}
		
	}
	
	public void sort(int[] arr) {
		int length = arr.length; // 10, 20, 30, 40, 50, 60, 70, 80, 90, 100
		if(length<=1){
			return;
		}
		int leftSize = arr.length/2;
		int rightSize = length - leftSize;
		int[] leftArr = new int[leftSize];
		int[] rightArr = new int[rightSize];	
		int mid = arr.length/2;
		
		for(int i=0;i<leftSize;i++) {
			leftArr[i]=arr[i];
		}
		
		for(int i=mid; i<arr.length; i++){
			rightArr[i-mid] = arr[i];
		}	
		
		sort(leftArr);
		sort(rightArr);
		merge(leftArr, rightArr, arr);
	}
	
	public void merge(int[] leftArr, int[] rightArr, int[] arr) {
		mergeSortArr = new int[arr.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<leftArr.length&&j<rightArr.length){
			if(leftArr[i]<=rightArr[j]){
				mergeSortArr[k] = leftArr[i];
				i++;
			}else{
				mergeSortArr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<leftArr.length){
			mergeSortArr[k] = leftArr[i];
			i++;
			k++;
		}
		
		while(j<rightArr.length){
			mergeSortArr[k] = rightArr[j];
			j++;
			k++;
		}
		
		for(int x=0; x<arr.length; x++){
			arr[x]=mergeSortArr[x];
		}
	}
	
}
