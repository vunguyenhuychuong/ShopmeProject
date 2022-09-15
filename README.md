# ShopmeProject
ShopmeProject is a website manage Products and Users for Now. It is a project still in processing, still countinue develeping , It is my first project i decided to use SpringBoot ,Spring MVC framework to practice.

[I. Công cụ để dùng Project]
- [1. Inteliji IDEA 2022.1.2(Ultimate Edition)]
- [2. MySQL Workbench 8.0]
- [3. JDK 18 version]
- [4. Spring Boot version 2.6.10 upper ]
- [5. JUnit Test ]


[II. Introduction ]
- Hibernate is used as JPA implementation by default
- Repositories:
  + Extend CRUDRepository, PagingAndSortingRepository
  + Use pre-defined methods: save(), findAll() , findById() , deleteById()
  + Use custom queries with @Query annotation
  + Use @Modyfying and @Transactional for Update queries
  + Pagination : Pageable, Sort, Page,PageRequest
- Entities: 
  + Code entity class first -> create table (forward engineering)
  + Use @Transient for getter methods that do not relate to field mapping
- Spring Security
  + Implements a simple RESTFUL webservice using @RestController (UserRestController)
  + Run internally (no public API) : just return a String Not Json.
- BootStrap, CSS and HTML
  + HTML5 define standard attributes for form fields validation
  + Font Awesome icons, CSS media queries to target different screen size.
- Thymeleaf
  + Integrated very well with Spring MVC
  + th:each- > iterate a collection
  + th:propertyName -> generate value for HTML attribute(th:src, th:href,th:class, th:action)
- Architecture: 
  + Repository Layer: entity classesand queries.
  + Service layer :bussiness/domain-specific logics.
  + Controller layer :request handling.
  + View layer: UI code generation.

## FEATURE
-USER
  * Encode Bcryte Password User
  * User List Function
  * Check validate Unique Emails, empty fields When create user.
  * SortList filter by ascending, descending ID, FirstName, LastName, Enabled(Status).
  * Pagnitation for User List , Search keyword textbox.
  * Export CSV | Excel | PDF  file Excel List User (Using SuperCSV,Apache Poi, OpenPDF) 
  
  
  
  ## SCREEN SHOT PROJECT
  * Admin Page
  <img src="https://user-images.githubusercontent.com/86512368/189934378-c622bd86-3376-4fd1-85d8-ea5026d88bf2.png" >
  
  <img src="https://user-images.githubusercontent.com/86512368/189726097-9fb4c15b-c48d-49b8-bc79-50f918ee75fa.png" >
 

