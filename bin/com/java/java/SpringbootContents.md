-------------------------------------------------------------------------------------------
** Spring Boot **
-------------------------------------------------------------------------------------------
**1. Core Spring Boot Fundamentals**

**Basic:**
1. What is Spring Boot and how is it different from the Spring Framework?
2. What are the key features of Spring Boot?
3. What is the purpose of the @SpringBootApplication annotation?
4. What is auto-configuration in Spring Boot? How does it work internally?
5. What is the difference between @Component, @Service, and @Repository?
6. How do you create a simple REST API using Spring Boot?
7. How do you run a Spring Boot application?
8. How can you change the default port of a Spring Boot application?

**Intermediate:**
9. What is the role of application.properties and application.yml files?
10. What is the difference between @RestController and @Controller?
11. What are starter dependencies in Spring Boot? Why are they useful?
12. How does Spring Boot handle dependency management?
13. What is the purpose of CommandLineRunner and ApplicationRunner?

**2. Dependency Injection & Bean Management**
14. What is dependency injection and how is it implemented in Spring Boot?
15. What are the different scopes of beans in Spring?
16. Explain the lifecycle of a Spring bean.
17. What is the use of @Autowired, and what are the different ways to inject dependencies?
18. What is the difference between field, setter, and constructor injection?
19. How do you define custom beans using @Bean and @Configuration?

**3. Advanced Spring Boot Features**
20. How does Spring Boot handle profiles (@Profile) and environment-specific configurations?
21. How do you secure a Spring Boot application?
22. What is Spring Boot Actuator? What are its common endpoints?
23. How can you monitor a Spring Boot application?
24. How do you enable and use caching in Spring Boot?
25. How does Spring Boot support asynchronous processing (@Async)?
26. What are custom health indicators in Actuator?

**4. REST API & Exception Handling**
27. How do you handle exceptions in Spring Boot?
28. What is the role of @ControllerAdvice and @ExceptionHandler?
29. How do you implement validation in Spring Boot using @Valid and @Validated?
30. How do you implement global error handling?
31. How do you handle request/response logging?

**5. Data Access Layer (Spring Data JPA)**
32. What is Spring Data JPA and how does it simplify database access?
33. How do you define a JPA repository?
34. Difference between CrudRepository, JpaRepository, and PagingAndSortingRepository.
35. How do you define custom queries in Spring Data JPA?
36. What is the N+1 select problem and how do you prevent it?
37. How does lazy vs. eager loading work?
38. How do you manage transactions in Spring Boot?

**6. Security**
39. What is Spring Security and how do you integrate it with Spring Boot?
40. How does authentication and authorization work in Spring Security?
41. How do you implement JWT-based authentication in Spring Boot?
42. What are filters in Spring Security?
43. How do you secure REST endpoints?
44. How do you configure CORS in Spring Boot?

**7. Microservices & Cloud Integration**
45. How do you build microservices using Spring Boot?
46. What is Spring Cloud? How does it complement Spring Boot?
47. What are service discovery and configuration management in microservices?
48. How does Spring Boot support distributed tracing?
49. How do you use Feign Client or RestTemplate for service-to-service calls?
50. What is Circuit Breaker and how can it be implemented (e.g., Resilience4J, Hystrix)?
51. How do you externalize configuration using Spring Cloud Config?

**8. Testing**
52. How do you write unit tests for Spring Boot applications?
53. What is the role of @SpringBootTest, @WebMvcTest, and @DataJpaTest?
54. How do you mock dependencies using Mockito?
55. How do you test REST endpoints?
56. How do you use TestContainers for integration testing?

**9. Performance, Deployment, and Optimization**
57. How do you improve startup performance in Spring Boot?
58. How can you package a Spring Boot application as a Docker image?
59. How do you deploy a Spring Boot application on AWS or Kubernetes?
60. How do you tune Hibernate performance (batch fetching, caching)?
61. How do you handle large data uploads/downloads?

**10. Scenario-Based / Practical Questions**
1. You notice that your Spring Boot application takes too long to start — how do you debug it?
2. How would you implement multi-tenant architecture in Spring Boot?
3. If a service depends on another microservice, how do you handle failures gracefully?
4. How do you implement request tracing across multiple microservices?
5. How do you handle versioning of REST APIs?