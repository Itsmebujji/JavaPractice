package com.vineeth;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class JavaMain {
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println("----------------------Numbers--------------------------");
		
		Numbers num = new Numbers();
		num.evenOrOddNumber(0);
		num.isPrime(6);
		num.primeNumbers(20);
		num.swapNumber(10, 20);
		num.reverseNumber(45); 
		num.fibnacciSeries(10);
		num.digitSum(134);
		num.digitProduct(273);
		num.armStrongNumebr(153);
		
		System.out.println("----------------------Strings--------------------------");
		
		Strings str = new Strings();
		str.reverseString("vinubujji");
		str.reverseStr("vinubujji");
		str.vowelsPresent("lodfadnoedvadffe");
		str.isPalindrome("madam");
		str.rmChar("Vineethc", 'c');
		str.countDist("vinu bujji");
		str.mutable();
		str.anagram("silent", "listen");
		str.rotation("ABCD","CDAB");
		
		System.out.println("----------------------Arrays--------------------------");
		
		ArraysQS arrQS = new ArraysQS();
		int[] arr1 = new int[]{1,2,3,4};
		int[] arr2 = new int[]{2,4,5,1};
		int[] arr3 = new int[]{23,34,65,7,4,5,73,56,2,3,48,56,43,90,96,98};
		arrQS.arraySum(arr1);
		arrQS.sameElements(arr1, arr2);
		System.out.println(Arrays.equals(arr1, arr2));
		arrQS.secondLargest(arr3);
		arrQS.arrSuffle(arr1);
		arrQS.closestZeroPair(arr3);
		String S = "ABC";
		char[] chArr = S.toCharArray();
		arrQS.permutations(chArr, 0, chArr.length-1);
		
		System.out.println("\n----------------------Linked List--------------------------");
		
		List<Integer> lst = new LinkedList<Integer>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		lst.stream().sorted((a,b)->b-a).forEach(i->System.out.print(i));
		System.out.print("\n");
		lst.stream().filter(i->i%2==0).sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.print("\n"); 
		List<String> l1 = new ArrayList<String>();
		l1.add("vineeth");
		l1.add("bujji");
		List<String> l2 = new ArrayList<String>();
		l2.add("vasu");
		l2.add("sekhar");
		List<String> ls = new LinkedList<String>();
		ls.addAll(l1);
		ls.addAll(l2);
		System.out.println(ls);
		
		System.out.println("----------------------Binary-search--------------------------");
		
		int[] ar = new int[] {1,2,3,4,5,6,7,8,9,10};
		BinarySearch bs = new BinarySearch(ar, 6);
		bs.search();
		
		System.out.println("----------------------Merge-sort--------------------------");
		
		int[] sortarr = new int[] {23,45,34,37,42,56,76,83,69,91};
		MergeSort ms = new MergeSort();
		ms.mergeSort(sortarr);
		
		
		System.out.println("\n----------------------Multi-threading--------------------------");
		
//		Deadlock1 d1 = new Deadlock1(obj1,obj2);
//		Deadlock2 d2 = new Deadlock2(obj1,obj2);
//		d1.start();
//		d2.start();
		
		System.out.println("\n----------------------File Handling--------------------------");
		
		FileHandling fh = new FileHandling();
		fh.getString();
		
		System.out.println("\n----------------------Data Formatting--------------------------");
		
		String s1 = "dd/mm/yyyy";
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s1);
        String formattedDate = now.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
	}
	
}
