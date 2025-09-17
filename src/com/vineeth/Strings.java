package com.vineeth;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings {
	
	public void reverseString(String str){
		StringBuilder string = new StringBuilder(str);
		System.out.println(string.reverse().toString());
	}
	
	public void reverseStr(String s){
		char[] arr = s.toCharArray();
		String str = "";
		for(int i=arr.length-1;i>=0;i--){
			str+=arr[i];
		}
		System.out.println(str);
	}
	
	public void vowelsPresent(String str){
		if(str.toLowerCase().matches(".*[aeiou].*")){
			System.out.println("Vowels are present in the given string");
		}else{
			System.out.println("Vowels are not present in the given string");
		}
	}
	
	public void isPalindrome(String str){
		StringBuilder strb = new StringBuilder(str);
		String s = strb.reverse().toString();
		if(str.equals(s)){
			System.out.println("It is a palindrome");
		}else{
			System.out.println("It is not a palindrome");
		}
	}
	
	public void rmChar(String s, char c){
		System.out.println(s.replace(c, ' '));
	}

	public void countDist(String string) {
		String s1 = string.replace(" ", "");
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int count = 1;
		for(int i=0; i<s1.length(); i++){
			if(!hm.containsKey(s1.charAt(i))){
				hm.put(s1.charAt(i), count);
			}else{
				hm.put(s1.charAt(i), hm.get(s1.charAt(i)).intValue()+1);
			}
		}
		System.out.println(hm);
		Map<Character, Long> freqMap = s1.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		
//		Map<String,Double> wordFreq = input.stream().collect(Collectors.groupingBy(Function.identity,Collectors.counting()));
	}

	public void mutable() {
		String s1 = "vineeth";
		String s2 = new String("vineeth");
		System.out.println(s1==s2);   // memory location
		System.out.println(s1.equals(s2));  // content
		
	}

	public void anagram(String s1, String s2) {
		boolean flag = false;
		for(int i=0;i<s1.length();i++){
			String s = String.valueOf(s1.charAt(i));
			if(s2.contains(s)){
				flag = true;
			}else{
				flag = false;
				break;
			}
		}
		if(flag == true){
			System.out.println("It is a Anagram");
		}else{
			System.out.println("It is not a Anagram");
		}
	}
	
	
	public static void main(String[] args) {
		Strings st = new Strings();
		st.anagram("madam", "damam");
	}

	public void rotation(String s1, String s2) {
		String concatString = s1+s1;
		if (concatString.contains(s2)) {
            System.out.println(s2 + " is a rotation of " + s1);
        } else {
            System.out.println(s2 + " is NOT a rotation of " + s1);
        }
	}
	
	
}
