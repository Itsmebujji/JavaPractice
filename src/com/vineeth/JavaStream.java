package com.vineeth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStream {

	public static void main(String[] args) {
		
		/*
		 *            STREAMS
		 * Types of methods in stream:
		 * 1. Intermediate stream
		 * 2. Terminal stream
		 * 
		 * Intermediate stream: Used to transform, filter, or modify the stream's elements without producing a final output immediately.
		 * --->  filter(predicate), map(function), distinct(), sorted(), limit(), skip(), flatmap(), peek()
		 * 
		 * Terminal stream: These methods produce a non-stream result such as a primitive value, an object, a collection, or no value at all.
		 * --->  forEach(), collect(), reduce(), count(), min(), max(), anymatch(), allMatch(), noneMatch(), findfirst(), findAny()
		 * 
		 * 
		 * collectors method:
		 * toList()
		 * toSet()
		 * toMap()
		 * joining()
		 * summingInt(), summingLong(), summingDouble()
		 * averageInt(), averageLong(), averageDouble()
		 * counting()
		 * grouping()
		 * partitioningby()
		 * toCollection()
		 * summarizingInt(), summarizingLong(), summarizingDouble()
		 *
		 */

		
		System.out.println("<------------------------------Q1------------------------------>");
		//1. find odd and even from the list
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.add(7);
		l1.add(8);
		l1.add(9);
		l1.add(10);
		List<Integer> lst1 = l1.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("Even numbers: "+lst1);
		List<Integer> lst2 = l1.stream().filter(i->i%2!=0).collect(Collectors.toList());
		System.out.println("Odd numbers: "+lst2);
		Map<Boolean, List<Integer>> m1 = l1.stream().collect(Collectors.partitioningBy(i->i%2==0));
		System.out.println("Even numbers: "+m1.get(true));
		System.out.println("Odd numbers: "+m1.get(false));
		
		
		System.out.println("<------------------------------Q2------------------------------>");
		//2. Remove the duplicate elements from the list
		List<Character> l2 = Arrays.asList('a','b','v','i','n','u','b','u','j','j','i');
		l2.stream().distinct().forEach(System.out::print);
		System.out.println("\n");
		
		System.out.println("<------------------------------Q3------------------------------>");
		//3. frequency of each character in a string
		String s1 = "vinubujji";
		Map<Character, 	Long> m2 = s1.chars().filter(c->c!=' ').mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		m2.forEach((c,f)-> System.out.println("Character: "+c+"-> Frequency: "+f));
		System.out.println(m2);
		
		System.out.println("<------------------------------Q4------------------------------>");
		//4. Find frequency of each element in a array
		
		String s2 = "cheppubujji";
		char[] ch1 = s2.toCharArray();
		Map<Character, Long> m3 = IntStream.range(0, ch1.length).filter(c -> c!=' ').mapToObj(c->ch1[c]).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(m3);
		
		System.out.println("<------------------------------Q5------------------------------>");
		//5. Sort the given list of decimals in reverse order
		List<Integer> l3 = l1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(l3);

		System.out.println("<------------------------------Q6------------------------------>");
		//6. Given a list of strings, join the strings with `[` as prefix, `]` as suffix and `,` as delimiter
		List<String> l4 = Arrays.asList("vineeth", "vasu", "sekhar");
		System.out.println(l4);
		String joined = l4.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(joined);
		
		System.out.println("<------------------------------Q7------------------------------>");
		//7. Given list of integers, print the numbers which are multiples of 5
		List<Integer> l5 = Arrays.asList(1,2,3,4,5);
		List<Integer> l6 = l5.stream().map(i->i*i).collect(Collectors.toList());
		System.out.println(l6);
		
		System.out.println("<------------------------------Q8------------------------------>");
		//8. Given a list of numbers, find max and min
		int max = l5.stream().max(Integer::compare).orElse(null);
		int min = l5.stream().min(Integer::compare).orElse(null);
		System.out.println("Max: "+max+" Min: "+min);
		
		System.out.println("<------------------------------Q9------------------------------>");
		//9. How do you merge two unsorted arrays into single sorted array using java
		int[] arr1 = new int[]{13,54,73,56,4,7,45,23,43,12,98};
		int[] arr2 = new int[]{1,4,65,34,75,87,34,56,90,65,34};
		int[] arr3 = new int[arr1.length+arr2.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		int[]  arr4 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		System.out.println(Arrays.toString(arr4));
		
		System.out.println("<------------------------------Q10------------------------------>");
		//10. How do you merge two unsorted arrays into single sorted array without duplicates
		int[]  arr5 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(arr5));
		
		System.out.println("<------------------------------Q11------------------------------>");
		//11. How do you get three maximum numbers and three minimum numbers from the given list of integers
		List<Integer> l7 = Arrays.asList(10,1,2,34,56,34,23,45,67,56,86,78);
		List<Integer> topMax = l7.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		List<Integer> topMin = l7.stream().sorted().limit(3).collect(Collectors.toList());
		System.out.println("Top 3 Max numbers: "+topMax);
		System.out.println("Top 3 Min numbers: "+topMin);
		
		System.out.println("<------------------------------Q12------------------------------>");
		//12. program to check if two strings are anagrams or not
		anagram("listen","silent");
		
		System.out.println("<------------------------------Q13------------------------------>");
		//13. Find sum of all digits of a number
		int x1 = 12345;
		int y1 = String.valueOf(x1).chars().map(Character::getNumericValue).sum();
		System.out.println(y1);
		
		System.out.println("<------------------------------Q14------------------------------>");
		//14. Find second largest number in an integer array
		List<Integer> l8 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		int x2 = l8.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println("The second largest number in array: "+x2);
		
		System.out.println("<------------------------------Q15------------------------------>");
		//15. Given a list of strings, sort them according to increasing order of their length
		List<String> l9 = Arrays.asList("vineeth","bujji","vasu","sekhar");
		System.out.println(l9.stream().sorted((a,b)->a.length()-b.length()).collect(Collectors.toList()));
		System.out.println(l9.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));
		//descending
		System.out.println(l9.stream().sorted((a,b)->b.length()-a.length()).collect(Collectors.toList()));
		System.out.println(l9.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList()));
		
		System.out.println("<------------------------------Q16------------------------------>");
		//16. Given an integer array, find sum and average of all elements
		List<Integer> l10 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		System.out.println(l10.stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum());
		System.out.println(l10.stream().collect(Collectors.summarizingInt(Integer::intValue)).getAverage());
		
		System.out.println("<-----------------------------Q17------------------------------>");
		//17. How do you find common elements between two arrays
		Integer[] arr6 = new Integer[]{2,4,3,6,7};
		Integer[] arr7 = new Integer[]{3,5,6,9,1,8,0,2};
		List<Integer> lst = new ArrayList();
		for(int i=0;i<arr6.length;i++){
			for(int j=0;j<arr7.length;j++){
				if(arr6[i]==arr7[j]){
					lst.add(arr6[i]);
				}
			}
		}
		System.out.println(lst);
		Set<Integer> st = new HashSet(Arrays.asList(arr6));
		List<Integer> l11 = Arrays.stream(arr7).filter(st::contains).collect(Collectors.toList());
		System.out.println(l11);
		
		System.out.println("<-----------------------------Q18------------------------------>");
		//18. Reverse each word of a string
		String s5 = "Hello bujji, where are you";
		String s6 = Arrays.stream(s5.split(" ")).map(i-> new 
		StringBuilder(i).reverse().toString()).collect(Collectors.joining(" "));
		System.out.println(s6);
		
		System.out.println("<-----------------------------Q19------------------------------>");
		//19. How do you find sum of first 10 natural numbers
		int x3 = 10;
		System.out.println(IntStream.range(0,x3).sum());
		
		System.out.println("<-----------------------------Q20------------------------------>");
		//20. Reverse an integer array
		int[] arr8 = new int[]{1,2,3,4,5};
		int[] arr9 = IntStream.rangeClosed(1, arr8.length).map(i->arr8[arr8.length-i]).toArray();
		System.out.println(Arrays.toString(arr9));
		
		System.out.println("<-----------------------------Q21------------------------------>");
		//21. Print first 10 even numbers
		int x4 = 10;
		int[] arr10 = IntStream.range(1, x4).filter(i->i%2==0).toArray();
		System.out.println(Arrays.toString(arr10));
				
		System.out.println("<-----------------------------Q22------------------------------>");
		//22. How do you find the most repeated element in an array
		int[] arr11 = {1, 2, 3, 1, 5, 7, 5, 5, 9, 3, 1, 3, 3, 7,6};
		int x5 = Arrays.stream(arr11).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				 .entrySet().stream()
				 .max(Map.Entry.comparingByValue())
				 .map(Map.Entry::getKey).get();
		System.out.println(x5);
		
		System.out.println("<-----------------------------Q23------------------------------>");
		//23. Palindrome program
		String s7 = "Madam".toLowerCase();
		boolean flag = IntStream.range(0, s7.length()/2).allMatch(i->s7.charAt(i)==s7.charAt(s7.length()-i-1));
		if(!flag) {
			System.out.println("It is not a palindrome");
		}else{
			System.out.println("It is a palindrome");
		}
		
		System.out.println("<-----------------------------Q24------------------------------>");
		//24. Given a list of strings, find out those strings which start with a number
		String s8 = "v";
		List<String> l12 = Arrays.asList("vineeth","bujji","vasu");
		List<String> l13 = l12.stream().filter(i->i.startsWith(s8)).collect(Collectors.toList());
		System.out.println(l13);
				 
		System.out.println("<-----------------------------Q25------------------------------>");
		//25. How do you extract duplicate elements from an array
		int[] array = {10, 12, 33, 30, 40, 40,52, 34, 40, 12, 78, 83, 78, 61, 61};
		Set<Integer> set1 = new HashSet();
		Set<Integer> set2 = Arrays.stream(array).filter(i->!set1.add(i)).boxed().collect(Collectors.toSet());
		System.out.println(set2);
				 
		System.out.println("<-----------------------------Q26------------------------------>");
		//26. Print duplte characters in a string
		String s9="vinubujji";
		Set<Character> set3 = new HashSet();
		Set<Character> set4 = s9.chars().mapToObj(c->(char) c).filter(i->!set3.add(i)).collect(Collectors.toSet());
		System.out.println(set4);
				 
		System.out.println("<-----------------------------Q27------------------------------>");
	    //27. Find first repeated character in a string
		String s10="vinubujji";
		Set<Character> seen = new HashSet<>();
		char c = s10.chars().mapToObj(i -> (char) i).filter(i -> !seen.add(i)).findFirst().get();
		System.out.println(c);
		
		System.out.println("<-----------------------------Q28------------------------------>");
		//28. Find first repeated character in a string
		String s11="vinubujji";
		Set<Character> set5 = new HashSet<>();
		char c2 = s10.chars().mapToObj(i -> (char) i).filter(i -> set5.add(i)).findFirst().get();
		System.out.println(c2);
				 
		System.out.println("<-----------------------------Q29------------------------------>");
		//29. Find the longest string in a list of strings using java streams
		List<String> l14 = Arrays.asList("vineeth", "bujji", "vasu", "sekhar");
		String s12 = l14.stream().max(Comparator.comparingInt(String::length)).get().toString();
		System.out.println(s12);
				
		System.out.println("<-----------------------------Q30------------------------------>");
		//30. Calculate the average age of a list of person objects
		List<Person> l15 = Arrays.asList(
				new Person("Alice", 30),
				new Person("Bob", 25),
				new Person("Charlie", 35),
				new Person("David", 40)
		);
		double averageAge = l15.stream().mapToInt(Person::getAge).average().orElse(0.0);
		System.out.println("Average age: "+ averageAge);
		
		System.out.println("<-----------------------------Q31------------------------------>");
		//31. Check if a list of integers contains a prime number
		List<Integer> l16 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> l17 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> l18 = l16.stream().filter(l17::contains).collect(Collectors.toList());
		System.out.println("Intersection: " + l18);
				        
		System.out.println("<-----------------------------Q32------------------------------>");
		//32. Find the 4th smallest element in a an array
		int[] arr = {7, 10, 4, 3, 20, 15};
		int fourthSmallest = Arrays.stream(arr).boxed().sorted().skip(3).findFirst().get();
		System.out.println("4th smallest element is: " + fourthSmallest);
				        
		System.out.println("<-----------------------------Q33------------------------------>");
		//33. Given a list of strings, find the frequency of each word using java
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		Map<String, Long> frequency = words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		frequency.forEach((word, count) -> System.out.println(word + ": " + count));
				 
		System.out.println("<-----------------------------Q34------------------------------>");
		//34. Find pairs in the array whose sum should be match with given target
		int[] ar = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int target = 21;
		findPair(ar,target);
		findPairs(ar,target);
		
	}
	
	
	
	private static void anagram(String string, String string2) {
		if(string.length()!=string2.length()){
			System.out.println(string+" and "+string2+" are not anagrams");
		}
		String s4 = string.toLowerCase().chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
		String s5 = string2.toLowerCase().chars().sorted().mapToObj(c->String.valueOf((char) c)).collect(Collectors.joining());
		if(s4.contains(s5)){
			System.out.println(string+" and "+string2+" are anagrams");
		}else{
			System.out.println(string+" and "+string2+" are not anagrams");
		}
	}

	
	public static void findPair(int[] arr, int target){
		int sum=0;
		List<Integer> al = new ArrayList<>();
		List<List<Integer>> al2 = new ArrayList<List<Integer>>();
		Map<Integer, List<List<Integer>>> m = new HashMap();
		for(int i=0;i<arr.length; i++){
			for(int j=i+1;j<arr.length;j++){
				sum = arr[i]+arr[j];
				if(sum==target){
					al = Arrays.asList(arr[i],arr[j]);
					al2.add(al);
					m.put(sum, al2);
				}
			}
			sum=0;
		}
		System.out.println(m);
	}
	
	
	public static void findPairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                result.add(Arrays.asList(complement, num));
            }
            seen.add(num);
        }
        System.out.println(result);
    }

	
}
