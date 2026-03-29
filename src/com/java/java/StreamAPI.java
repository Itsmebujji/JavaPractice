package com.java.java;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {
		
		// Filter tasks
		
	    // Filter a list of integers, keeping only even numbers.
		List<Integer> l1 = Arrays.asList(1,2,3,4,5);
		l1.stream().filter(i->i%2==0).forEach(i->System.out.print(i+" "));
		System.out.println("");
	    // Filter a list of strings to include only those starting with "A".
		List<String> l2 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l2.stream().filter(i->i.startsWith("A")).forEach(i->System.out.print(i+" "));
		System.out.println("");
	    // Remove all null values from a list of strings.
		List<String> l3 = Arrays.asList("Amma", "Nanna", "Bujji", null, null);
		l3.stream().filter(i->i!=null).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Filter a list of people to include only those older than 18.
		List<Person> l4 = Arrays.asList(new Person("vk",26), new Person("kk",27), new Person("vs",18), new Person("ks",16));
		l4.stream().filter(i->i.getAge()>18).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// From a list of integers, keep only numbers greater than the average.
		
		// Filter a list of words to include only palindromes.
		
		// Remove all empty strings from a list.
		List<String> l5 = Arrays.asList("Amma", "Nanna", "Bujji", "", "");
		l5.stream().filter(i->i!="").forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Filter a list of products with prices below 100.
		List<Product> l6 = Arrays.asList(new Product(1,"Mango",140), new Product(2,"Banana",40), new Product(2,"Apple",160), new Product(2,"Orange",70));
		l6.stream().filter(i->i.getProductPrice()<100).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Keep only emails that contain "gmail.com".
		List<String> l7 = Arrays.asList("Amma@gmail.com", "Nanna@gmail.com", "Bujji@gmail.com", "", "");
		l7.stream().filter(i->i!=""&&i.contains("gmail.com")).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Filter a list of transactions to include only successful ones.
		List<String> l8 = Arrays.asList("Success", "Failure", "Failure", "Success", "Success");
		l8.stream().filter(i->i!="Failure").forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		System.out.println("----------------------------------------------------------");
		
	    // Mapping / transformation tasks
		
		// Convert a list of strings to uppercase.
		List<String> l9 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l9.stream().map(i->i.toUpperCase()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of integers to their squared values.
		List<Integer> l10 = Arrays.asList(1,2,3,4,5);
		l10.stream().map(i->i*i).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of Employee objects to a list of their names.
		List<Person> l11 = Arrays.asList(new Person("vk",26), new Person("kk",27), new Person("vs",18), new Person("ks",16));
		l11.stream().map(i->i.getName()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of strings to their lengths.
		List<String> l12 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l12.stream().map(i->i.length()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of dates to their year values.
		List<LocalDate> l13 = Arrays.asList(LocalDate.of(1998, 6, 27), LocalDate.of(1999, 5, 1), LocalDate.of(1978, 9, 1));
		l13.stream().map(i->i.getYear()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of words to their first character.
		List<String> l14 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l14.stream().map(i->i.charAt(0)).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Add 10 to each integer in a list.
		List<Integer> l15 = Arrays.asList(1,2,3,4,5);
		l15.stream().map(i->i+10).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of strings into their reversed versions.
		List<String> l16 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l16.stream().map(i->new StringBuffer(i).reverse()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// Convert a list of temperatures from Celsius to Fahrenheit.
		
		// Convert a list of person names into Person objects with a default age.
		List<String> l17 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l17.stream().map(i->new Person(i,26)).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		System.out.println("----------------------------------------------------------");
		
		// Flattening tasks
		
		// Flatten a list of lists of integers into a single list.
		List<List<Integer>> l18 = Arrays.asList(Arrays.asList(1,2,3,4,5), Arrays.asList(6,7,8,9,10), Arrays.asList(11,12,13,14,15));
		l18.stream().flatMap(i->i.stream()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// From a list of sentences, extract all words into one list.
		List<String> l19 = Arrays.asList("Java is programming language", "It is Java programming", "One of the secure Language");
		l19.stream().flatMap(i->Arrays.stream(i.split(" "))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().forEach(i->System.out.print(i.getKey()+"->"+i.getValue()+" | "));
		System.out.println("");
		// Flatten a list of arrays of strings into a single list.
		List<List<String>> l20 = Arrays.asList(Arrays.asList("Love is caring without conditions","Love is understanding without needing words"),
				Arrays.asList("Love is putting someone elses happiness beside your own"));
		l20.stream().flatMap(i->i.stream()).forEach(i->System.out.println(i));
		// Flatten a list of orders (each containing multiple items) into a list of all items.
		List<List<Product>> l21 = Arrays.asList(Arrays.asList(new Product(1,"Mango",140), new Product(2,"Banana",40)), 
				Arrays.asList(new Product(2,"Apple",160)),Arrays.asList(new Product(2,"Orange",70)));
		l21.stream().flatMap(i->i.stream()).map(i->i.getProductName()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// From a list of people with multiple phone numbers, create a list of all phone numbers.
		List<List<String>> l22 = Arrays.asList(Arrays.asList("9234754524","245245343463"),
				Arrays.asList("89023485234"), Arrays.asList("90238547834"));
		l22.stream().flatMap(i->i.stream()).forEach(i->System.out.print(i+" | "));
		System.out.println("");
		// Flatten a list of sets of integers into one list.
		List<Set<Integer>> l23 = Arrays.asList(
				new HashSet<>(Arrays.asList(1,2,3,4,5)), new HashSet<>(Arrays.asList(6,7,8,9,10)), new HashSet<>(Arrays.asList(11,12,13,14,15))
				);
		l23.stream().flatMap(i->i.stream()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		// From a list of paragraphs, create a list of all unique words.
		List<String> l24 = Arrays.asList("Java is programming language", "It is Java programming", "One of the secure Language");
		l24.stream().flatMap(i->Arrays.stream(i.split(" "))).map(i->i.toLowerCase()).distinct().forEach(i->System.out.print(i+" / "));
		System.out.println("");
		// Flatten a list of character arrays into a list of characters.
		List<List<Character>> l25 = Arrays.asList(Arrays.asList('a','b','c','d'), Arrays.asList('e','f','g','h'), Arrays.asList('i','j','k','l'));
		l25.stream().flatMap(i->i.stream()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		
		System.out.println("----------------------------------------------------------");
		
		// mapToInt(), mapToLong(), mapToDouble() tasks
		
		// Convert a List<String> of numbers into an IntStream and find the sum.
		List<String> l26 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		System.out.println(l26.stream().mapToInt(i->i.length()).sum());

		// Given a list of employees, extract their salaries as DoubleStream and find average.
		List<Employee> l27 = Arrays.asList(new Employee(1, "vk", 200000.00), new Employee(2, "vasu",35000.00), new Employee(3, "sekhar", 50000.00));
		System.out.println(l27.stream().mapToDouble(Employee::getSalary).average().orElse(0));
		
		// Convert a list of strings into their lengths using mapToInt()
		List<String> l28 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		l28.stream().mapToInt(i->i.length()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// From a list of objects, map IDs (long) and find max ID.
		List<Employee> l29 = Arrays.asList(new Employee(1, "vk", 200000.00), new Employee(2, "vasu",35000.00), new Employee(3, "sekhar", 50000.00));
		System.out.println(l29.stream().mapToDouble(Employee::getEmployeeId).max().orElse(0));
		
		// Convert List<Double> to DoubleStream and calculate sum of squares.
		List<Double> l30 = Arrays.asList(1.0,5.0,4.0);
		l30.stream().mapToDouble(i->i*i).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Extract ASCII values of characters in a string using mapToInt().
		List<Character> l31 = Arrays.asList('A','b','C','d');
		l31.stream().mapToInt(i->i.charValue()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Given a list of employee, map total salary (double) and find highest salary value.
		List<Employee> l32 = Arrays.asList(new Employee(1, "vk", 200000.00), new Employee(2, "vasu",35000.00), new Employee(3, "sekhar", 50000.00));
		System.out.println(l32.stream().mapToDouble(Employee::getSalary).max().orElse(0));
		
		// Convert a list of timestamps to LongStream and find earliest timestamp.
		List<Long> timestamps = Arrays.asList(1678901234567L, 1678801234567L, 1679001234567L);
		System.out.println(timestamps.stream().mapToLong(i->i.longValue()).min().orElse(0));
		
		// From a list of strings, map to lengths and count how many are > 5.
		List<String> l33 = Arrays.asList("Amma", "Nanna", "Bujji", "Annayya", "Thammu");
		System.out.println(l33.stream().mapToInt(i->i.length()).filter(i->i>5).count());
		
		// Chain mapToInt() → filter() → sum() for even numbers.
		List<Integer> l34 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(l34.stream().mapToInt(i->i.intValue()).filter(i->i%2==0).sum());
		
		// flatMapToInt(), flatMapToLong(), flatMapToDouble()
	
		// Flatten a List<List<Integer>> into a single IntStream
		List<List<Integer>> l35 = Arrays.asList(Arrays.asList(1,2,3,4,5), Arrays.asList(9,10), Arrays.asList(6,7,8));
		l35.stream().flatMap(i->i.stream()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Given sentences, flatten all words → map word lengths → sum.
		List<String> l36 = Arrays.asList("Java is programming language", "It is Java programming", "One of the secure Language");
		System.out.println(l36.stream().flatMap(i->Arrays.stream(i.split(" "))).mapToInt(i->i.length()).sum());
		
		// Flatten a list of strings into character ASCII values
		List<String> l37 = Arrays.asList("vineeth","vasu");
		l37.stream().flatMap(i->i.chars().boxed()).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Given students with multiple scores, flatten scores and find average
		List<List<Integer>> l38 = Arrays.asList(Arrays.asList(100,93,83,89), Arrays.asList(85,92,94,87), Arrays.asList(91,97,92,94));
		System.out.println(l38.stream().flatMap(i->i.stream()).mapToInt(i->i.intValue()).average().orElse(0));
		
		// Flatten nested lists and count distinct integers.
		List<List<Integer>> l39 = Arrays.asList(Arrays.asList(1,2,3,4,5), Arrays.asList(3,7,8,5), Arrays.asList(6,7,8,9,10));  
		l39.stream().flatMap(i->i.stream()).distinct().forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Flatten list of lists and filter numbers > 10.
		List<List<Integer>> l40 = Arrays.asList(Arrays.asList(10,12,31,8,15), Arrays.asList(41,38,26,47), Arrays.asList(16,7,28,19,21));
		l40.stream().flatMap(i->i.stream()).filter(i->i>20).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Convert list of strings into stream of digits using flatMapToInt()
		List<String> l41 = Arrays.asList("1","2","3","4","5");
		l41.stream().flatMapToInt(i->i.chars().map(j->j-'0')).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Remove Duplicates
		
		// Remove duplicate strings from a list
		List<String> l42 = Arrays.asList("Vineeth", "bujji", "Vineeth","Sekhar","Vasu");
		l42.stream().distinct().forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Remove duplicate integers from a list
		List<Integer> l43 = Arrays.asList(1,5,4,3,5,3,4,2,6,7,8,5);
		l43.stream().distinct().forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Remove duplicates ignoring case
		List<String> l44 = Arrays.asList("Vineeth", "Bujji","bujji", "vineeth","Sekhar","Vasu");
		Set<String> seen1 = new HashSet<>();
		l44.stream().filter(i->seen1.add(i.toLowerCase())).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Get distinct characters from a string
		String s1 = "vineeth";
		s1.chars().distinct().mapToObj(i->(char) i).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Count distinct elements in a list
		List<Integer> l45 = Arrays.asList(1,2,3,4,5,4,3,2,6,8,9,1,10);
		l45.stream().distinct().forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Find distinct even numbers
		List<Integer> l46 = Arrays.asList(1,2,3,4,5,4,3,2,6,8,9,1,10);
		l46.stream().distinct().filter(i->i%2==0).forEach(i->System.out.print(i+" "));
		System.out.println("");
		
		// Get distinct objects based on a field
		List<Employee> l47 = Arrays.asList(new Employee(1, "vk", 200000.00), new Employee(2, "vasu",35000.00), new Employee(1, "sekhar", 50000.00));
		Set<Integer> seen2 = new HashSet<>();
		l47.stream().filter(i->seen2.add((int) i.getEmployeeId())).forEach(i->System.out.print(i+" "));
		
		// 
	}
}
