# Library

Developed and maintained a Spring Boot application comprising various modules, including API class, DTO, entity class, repository class, service class, exception, utility, and validator class.
Implemented three REST APIs "getBookDetailsByBookName" ,"getBookDetailsByAuthor" and "addStudent", each with distinct business logic encapsulated within service classes.
Utilized MySQL database with Spring Data, employing the @Query approach to retrieve data and CRUD repository for database operations.
Utilized the @ManyToMany approach to establish a relational connection between entity classes "Book" and "Student" ensuring robust data organization and retrieval capabilities.
Implemented an Exception Controller Advice class to handle custom, general, and validation exceptions, including MethodArgumentNotValidException and ConstraintViolationException.
Integrated a validator class to validate payment types and phone numbers using validation annotations within entity classes.
