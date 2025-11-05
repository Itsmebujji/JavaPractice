package com.vineeth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaFeatures {

	public static void main(String[] args) {
		
		
		//####################################################################################################
		// Java 8 Features
		//####################################################################################################
		System.out.println("----------------------Java 8 Features--------------------------");
		
		System.out.println("----------------------Lambda Functions--------------------------");
		/*
		 * 1. Lambda Functions: 
		 * 		Lambdas let you write inline implementations of functional interfaces 
		 * 		(interfaces with only one abstract method). They make code shorter, cleaner, 
		 * 		and easier to read.
		 */
		
        List<String> names = Arrays.asList("Vineeth", "Vasu", "Sekhar");

        // Without Lambda
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // With Lambda
        Collections.sort(names, (a, b) -> a.compareTo(b));

        names.forEach(n -> System.out.println("Hello, " + n));
        
        System.out.println("----------------------Functional Interfaces--------------------------");
        /*
		 * 2. Functional Interfaces: 
		 * 		A Functional Interface has exactly one abstract method.
		 *      They’re the foundation of lambdas.
		 * Common functional interfaces:
		 * 		Runnable -> void run()
		 * 		Callable<T> -> T call()
		 * 		Predicate<T> -> test condition
		 * 		Function<T, R> -> transforms data
		 * 		Consumer<T> -> takes input, returns nothing
		 * 		Supplier<T> -> returns a value, no input
		 */
        
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Function<Integer, Integer> square = n -> n * n;
        Consumer<Integer> printer = n -> System.out.println("Value: " + n);
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Square of 5: " + square.apply(5));
        printer.accept(42);
        System.out.println("Random number: " + randomSupplier.get());
        
        System.out.println("----------------------Stream API--------------------------");
        /*
         * Stream API Concept:
         * The Stream API allows functional-style operations on collections (filtering, mapping, reducing, etc.)
         * It makes data processing concise and parallelizable
         */
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)     // keep only even numbers
                .map(n -> n * n)             // square each
                .collect(Collectors.toList());

        System.out.println("Even squares: " + evenSquares);
        
        System.out.println("----------------------Default and Static Methods--------------------------");
        /*
         * Default and Static Methods in Interfaces Concept:
         * 		Java 8 lets you define default and static methods inside interfaces.
         * 		Default method -> provides implementation so classes don’t need to override it.
         * 		Static method ->  belongs to the interface itself.
         */
        
//        interface MyInterface {
//            default void show() {
//                System.out.println("Default method in interface");
//            }
//
//            static void staticShow() {
//                System.out.println("Static method in interface");
//            }
//        }
//
//        public class DefaultStaticExample implements MyInterface {
//            public static void main(String[] args) {
//                DefaultStaticExample obj = new DefaultStaticExample();
//                obj.show(); // calls default method
//                MyInterface.staticShow(); // calls static method
//            }
//        }
        
        System.out.println("----------------------New Date and Time API--------------------------");
        /*
         * New Date and Time API (java.time) Concept:
         * 		Replaces old java.util.Date and Calendar — thread-safe and much more intuitive.
         *
         */
        
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate futureDate = date.plusDays(10);

        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);
        System.out.println("10 days later: " + futureDate);
        
        System.out.println("----------------------Optional Class--------------------------");
        /*
         * Optional Class Concept:
         * 		Optional is a container that may or may not hold a non-null value.
         * 		Helps to avoid NullPointerException.
         */
        Optional<String> name = Optional.ofNullable(null);

        System.out.println("Is present? " + name.isPresent());
        System.out.println("Value or default: " + name.orElse("Anonymous"));

        name.ifPresent(n -> System.out.println("Hello, " + n));
        
        System.out.println("----------------------Method References--------------------------");
        /*
         * Method References Concept:
         * 		A method reference is a shorthand for a lambda that calls an existing method.
         */
        List<String> lst = Arrays.asList("Alice", "Bob", "Charlie");

        // Using lambda
        lst.forEach(n -> System.out.println(n));

        // Using method reference
        lst.forEach(System.out::println);
        
        System.out.println("----------------------Streams with Parallel Processing Concept--------------------------");
        /*
         * Streams with Parallel Processing Concept:
         * 		You can run stream operations in parallel to utilize multiple CPU cores.
         */
        
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        list.parallelStream()
            .forEach(n -> System.out.println(Thread.currentThread().getName() + " -> " + n));
        
      //####################################################################################################
      // Java 11 Features
      //####################################################################################################
        System.out.println("----------------------Java 11 Features--------------------------");
        
        System.out.println("----------------------Local Variable--------------------------");
        /*
         * Local Variable Type Inference (var) Concept:
         * 		Introduced in Java 10 and continued in Java 11 — you can use var to let the compiler infer the type of local variables.
         * 		Only works for local variables, not fields, method parameters, or return types.
         */
        
        var message = "Hello, Java 11";   // compiler infers String
        var number = 42;                  // compiler infers int
        var ls = List.of("A", "B", "C"); // List<String>

        for (var item : ls) {
            System.out.println(item);
        }

        System.out.println(message + " - number: " + number);
        
        System.out.println("----------------------New String Methods--------------------------");
        /*
         * New String Methods
         * 		Java 11 added several helpful methods to the String class for trimming, checking, and repeating strings.
         */
        
        String str = "   Java 11 Features   ";

        System.out.println("isBlank(): " + str.isBlank()); // false
        System.out.println("strip(): '" + str.strip() + "'"); // removes Unicode whitespaces
        System.out.println("stripLeading(): '" + str.stripLeading() + "'");
        System.out.println("stripTrailing(): '" + str.stripTrailing() + "'");
        System.out.println("repeat(3): " + "Hi ".repeat(3));

        String multiline = "Line1\nLine2\nLine3";
        multiline.lines().forEach(System.out::println); // splits string into lines
        
        System.out.println("----------------------HttpClient--------------------------");
        /*
         * HttpClient (New HTTP API) Concept:
         * A brand-new, modern HTTP client API introduced in Java 11 (java.net.http package).
         * It supports synchronous, asynchronous, and HTTP/2 communication.
         * 
         */
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com"))
                .build();

        HttpResponse<String> response = null;
        
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        
        System.out.println("----------------------Files API Enhancements--------------------------");
        /*
         * Files API Enhancements
         * 		Java 11 added new Files utility methods for reading and writing strings easily.
         */
        
        Path path = Path.of("example.txt");

        // Write a string to file
        try {
			Files.writeString(path, "Hello, Java 11!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Read the string back
        String content = null;
		try {
			content = Files.readString(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(content);
        
        System.out.println("----------------------Predicate.not()--------------------------");
        /*
         * Predicate.not() Utility Concept:
         * A new static method Predicate.not() was added to make stream filtering
         * cleaner when you want the opposite condition.
         * 
         */
        
        List<String> nameList = List.of("Alice", "", "Bob", " ", "Charlie");

        // Remove blank names using Predicate.not
        List<String> validNames = nameList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());

        System.out.println(validNames); // [Alice, Bob, Charlie]
        
        System.out.println("----------------------Launch Single-File Source Code--------------------------");
        /*
         * Launch Single-File Source Code Directly
         * 		In Java 11, you can run a .java file directly without compiling it first using javac.
         */
        
        // java Hello.java
        
		//####################################################################################################
		// Java 17 Features
		//####################################################################################################
		System.out.println("----------------------Java 17 Features--------------------------");
		
		/*
		 * Sealed Classes and Interfaces:
		 * 		Sealed classes let you restrict which other classes can extend or implement them.
		 * 		This helps maintain control over inheritance and improve code safety.
		 * 			sealed -> restricts which classes can extend it
		 * 			permits -> specifies allowed subclasses
		 * 			final -> subclass cannot be extended further
		 * 			non-sealed -> subclass can be extended freely
		 */
		
		// Define a sealed class
//		sealed class Shape permits Circle, Rectangle, Square { }
//
//		final class Circle extends Shape { }
//		final class Rectangle extends Shape { }
//		non-sealed class Square extends Shape { }  // non-sealed allows further inheritance
//
//		public class SealedExample {
//		    public static void main(String[] args) {
//		        Shape shape = new Circle();
//		        System.out.println("Shape is a " + shape.getClass().getSimpleName());
//		    }
//		}
		
		/*
		 * Pattern Matching for instanceof
		 * 		You can now combine instanceof checks and casts in a single, concise expression.
		 * 
		 */
		Object obj = "Java 17";

        if (obj instanceof String string) {  // pattern variable
            System.out.println(str.toUpperCase());
        } else {
            System.out.println("Not a string");
        }
        
        /*
         * Records
         * 		A record is a special kind of class used to represent immutable data.
         * 		It automatically generates constructors, getters, toString(), equals(), and hashCode().
         */
        
//        public record Person(String name, int age) { }
//        Person p = new Person("Alice", 30);
//        System.out.println(p.name());  // getter
//        System.out.println(p.age());
//        System.out.println(p);
        
        /*
         * Switch Expressions
         * 		Switch can now return values and use arrow syntax for cleaner code.
         */
        
        String day = "MONDAY";

        String type = switch (day) {
            case "SATURDAY", "SUNDAY" -> "Weekend";
            default -> {
                System.out.println("Other day");
                yield "Other day"; // return value
            }
        };

        System.out.println(type);
		
        /*
         * Text Blocks
         * 		Text blocks make working with multi-line strings easy — perfect for JSON, HTML, or SQL.
         */
        
        String json = """
                {
                    "name": "Alice",
                    "age": 25,
                    "city": "London"
                }
                """;

        System.out.println(json);
        
		//####################################################################################################
		// Java 21 Features
		//####################################################################################################
        System.out.println("----------------------Java 21 Features--------------------------");
        
        // Record Patterns: This is now a permanent language feature. It allows you to deconstruct record-types (and nested patterns) succinctly.
        
        // Pattern Matching for switch: Also a permanent feature in Java 21: you can now use switch expressions/statements with type patterns.
        
        // Virtual Thread: Virtual threads are now finalized in Java 21. They allow lightweight threads so you can create 
        // many more than platform threads, improving scalability of concurrent applications.
        
//        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            for (int i = 0; i < 1000; i++) {
//                int id = i;
//                executor.submit(() -> {
//                    System.out.println("Running task " + id + " on " + Thread.currentThread());
//                });
//            }
//        } // executor auto-closes and waits
        
        
        
//        	Here are 3-4 top options you could pick, one for each domain (Tableau + Informatica):
//
//        	“Tableau Server 2019.1 Administration” (Udemy) – for Tableau Server admin.
//
//        	“Tableau Server / Site Administration” official Tableau training – for deeper official/admin path.
//
//        	“Informatica PowerCenter Administration” (Udemy) – for Informatica admin basics & advanced.
//
//        	“Informatica Platform Administration Fundamentals” (Informatica University) – for enterprise/production scale admin tasks.
        	
	}

}
