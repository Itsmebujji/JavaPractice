-------------------------------------------------------------------------------------------
**Java Contents**
-------------------------------------------------------------------------------------------

1. **Java Features**
2. **JVM**
3. **JDK vs JRE vs JVM**
4. **Java Basic Syntax**
5. **Java Comments**
6. **Java Variables**
7. **Java Data Types:**
    1. Primitive data type: `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`  
    2. Non-Primitive data type: `String`, `Arrays`, `Classes`, `Interfaces`  

8. **Type Casting**
    1. Auto-boxing  
    2. Unboxing  

9. **Java Operators**  
    1. Arithmetic Operators (`+`, `-`, `*`, `/`, `%`, `++`, `--`)  
    2. Assignment Operators (`=`, `+=`, `-=`, `/=`, `*=`, `%=`)  
    3. Relational Operators (`==`, `!=`, `>`, `<`, `>=`, `<=`)  
    4. Logical Operators (`&&`, `||`, `!`)  
    5. Bitwise Operators (`&`, `|`, `^`, `~`, `<<`, `>>`)  

10. **Java Control Statements**  
    1. **Decision Making:**  
        a. If Else Statement (`if`, `if else`, `if else if else`)  
        b. Switch Statement (`switch`, `case`, `default`, `break`, `continue`)  
    2. **Loop Control:**  
        a. For Loop  
        b. For-Each Loop  
        c. While Loop  
        d. Do While Loop  

11. **Object Oriented Programming (OOP)**  
    1. **Object**  
    2. **Classes**  
    3. **Encapsulation**  
        a. Access Specifiers / Modifiers  
        b. Attributes  
        c. Constructor  
        d. Methods  
    4. **Abstraction**  
        a. Abstract Class  
        b. Interface  
    5. **Inheritance**  
        a. Parent Class  
        b. Child Class  
        c. Diamond Problem  
    6. **Polymorphism**  
        a. Method Overloading (`compile-time`)  
        b. Method Overriding (`runtime`)  
        c. Static Binding  
        d. Dynamic Binding  

12. **Java Error & Exceptions:**  
    1. Exception  
    2. Error  
    3. Exceptions  
        a. Checked Exception (`compile-time`)  
        b. Unchecked Exception (`runtime`)  
    4. `try-catch`  
    5. `try-with-resources`  
    6. Multi-catch block, Nested try block, Finally block  
    7. `throws`, `throw`  
    8. Custom Exception  

13. **Java Collections:**  
    1. **Collection**  
    2. **Collections**  
    3. **Interfaces**  
        1. **List**  
            a. ArrayList  
            b. LinkedList  
            c. Vector  
            d. Stack  
        2. **Set**  
            a. HashSet  
            b. LinkedHashSet  
            c. TreeSet  
        3. **Queue / Deque**  
            a. PriorityQueue  
            b. ArrayDeque  
            c. ConcurrentLinkedQueue  
        4. **Map**  
            a. HashMap  
            b. LinkedHashMap  
            c. TreeMap  
            d. WeakHashMap  
            e. IdentityHashMap  
            f. Hashtable  
    4. **Utility and Supporting Classes**  
        a. Iterable Interface  
        b. ListIterator  
        c. Enumeration  
        d. Comparator  
        e. Comparable  
    5. **Concurrency Collections**  
        a. ConcurrentHashMap  
        b. ConcurrentLinkedQueue  
        c. BlockingQueue  
        d. CopyOnWriteArrayList  

14. **Multithreading**  
    1. Multithreading  
    2. Thread  
    3. Thread Life Cycle  
    4. Thread States  
    5. Creating a Thread  
        a. Extend Thread class  
        b. Implement Runnable interface  
    6. Thread Methods  
    7. Starting a Thread  
    8. Naming the Thread  
    9. Joining the Thread  
    10. Thread Priority  
    11. Difference between `run()` and `start()`  
    12. Synchronization  
        a. Block Synchronization  
        b. Method Level Synchronization  
        c. Static Synchronization  
    13. Inter-thread Communication  
        a. `wait()`, `notify()`, `notifyAll()`  
    14. Difference between `wait()` and `join()`  
    15. Thread DeadLock  
    16. Thread Safety  
        a. Synchronization  
        b. `volatile` Keyword  
        c. Atomic Variable  
        d. `final` Keyword  
    17. Daemon Thread and Non-Daemon Thread  
    18. Main Thread vs Child Thread  
    19. Producer-Consumer Problem  

15. **Concurrency Utilities**  
    1. **Lock Interface**  
        a. Methods – `lock()`, `unlock()`, `tryLock()`, `tryLock(T,U)`, `lockInterruptibly()`  
    2. **ReentrantLock**  
        a. Methods – Lock interface methods + `getHoldCount()`, `getQueueLength()`, `isLocked()`, `isFair()`, `getOwner()`  
    3. Thread Pool  
    4. Thread Group  
    5. Thread Scheduler  
        a. Time Sliced Scheduling (Round Robin Scheduling)  
        b. Priority Based Scheduling  
        c. Preemptive Scheduling  
    6. Context Switching  
    7. ThreadLocal  
    8. Callable Interface  
    9. Future and CompletableFuture  
    10. Executor Framework  
        a. Executor  
        b. ExecutorService  
        c. ScheduledExecutorService  
        d. CountDownLatch  
        e. BlockingQueue  
        f. DelayQueue  
        g. CyclicBarrier  
        h. Semaphore  

16. **Java File Handling**  
    1. Create a File  
    2. Read a File  
    3. Write to a File  
    4. Delete Files  
    5. Java I/O Streams  

17. **Others**  
    1. `super`, `final`, `instanceof`  
    2. Call by Value, Call by Reference  
    3. Marker Interface  
        a. Serializable Interface  
        b. Cloneable Interface  
    4. Garbage Collector  
    5. Consumer, Supplier  

18. **Java Features**  
    1. **Java 8 Features**  
        a. `forEach()` method in Iterable interface  
        b. Default and Static Methods in Interface  
        c. Functional Interfaces and Lambda Expressions  
        d. Java Stream API  
        e. DateTime API  
        f. Optionals  
    2. **Java 11 Features**  
        a. Running Java files within a single command  
        b. New Utility Methods in String Class  
        c. Local Variable Syntax in Lambda Parameters (`var`)  
        d. HttpClient Standardized  
        e. `Files.readString()` / `writeString()`  
    3. **Java 17 Features**  
        a. Sealed Classes  
        b. `instanceof` Pattern Matching  
        c. Records  
        d. Standardized Switch  
        e. Text Blocks  
    4. **Java 21 Features**  
        a. Virtual Threads  
        b. Records Standardized  
        c. Switch Standardized  
        d. String Templates  
        e. Sequenced Collections  
        f. Scoped Values (`ThreadLocal`)
