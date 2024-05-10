# skeleton-openapi

1. No Specification:
    
    - In this scenario, there is no predefined specification or
    requirements for the application. Developers might start with a
    basic idea or a vague concept, but there's no detailed plan or
    specification document.
    
    - Development typically begins with exploration and experimentation.
    Developers might start with a simple prototype to flesh out ideas
    and gather feedback.
    
    - With Spring Boot and Angular, developers would begin by setting up
    the basic structure of the backend and frontend respectively. They
    might start with creating RESTful APIs in Spring Boot to handle
    backend functionality and build simple Angular components for the
    frontend UI.
    
    - As the development progresses and more clarity emerges regarding the
    requirements, developers iterate on the codebase, adding features,
    refining the architecture, and improving the user experience.
    
2. Code First:
    
    - In a "code first" approach, development starts directly with writing
    code without a detailed specification. However, there might be some
    high-level goals or concepts in mind.
    
    - Developers dive straight into coding, implementing features and
    functionalities based on their understanding of the project
    requirements and their experience.
    
    - With Spring Boot and Angular, developers would begin by setting up
    the project structure, defining the backend APIs, and building
    frontend components. They might start with basic CRUD operations to
    get the application up and running.
    
    - This approach allows for quick prototyping and iteration. Developers
    continuously refine the codebase based on feedback and evolving
    requirements. However, it can also lead to challenges in maintaining
    consistency and scalability if not managed properly.
    
3.  API First:
    
    - In an "API first" approach, the development process starts by
    defining the API specifications before writing any code. This
    involves designing the contract between the frontend and backend
    systems.
    
    - Developers create a detailed API specification using tools like
    Swagger or OpenAPI Specification (OAS). This specification outlines
    the endpoints, request/response payloads, authentication mechanisms,
    etc.
    
    - Once the API specification is finalized and agreed upon, backend
    developers implement the API endpoints in Spring Boot according to
    the specification. Meanwhile, frontend developers use the API
    specification to design and develop the frontend components in
    Angular that interact with the backend.
    
    - This approach promotes clear communication between frontend and
    backend teams since both parties work based on a shared
    understanding of the API contract. It also helps in ensuring
    consistency and interoperability between different parts of the
    application.

This repo contains a simple frontend and backend application to do crud-operations on an employee collection.
The backend serves apis and operate the adjustments to the data. The frontend collect the data and push the adjustements to the backend.

This branch explore the second approach on designing api's using the [Spring Rest Openapi Documentation](https://www.baeldung.com/spring-rest-openapi-documentation) as documentation

simple by adding 
```
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
```
by adding this dependency we can have bean validation
```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
        <version>3.2.4</version>
    </dependency>
```

we have our documentation:\
json description can be viewed on: [api-docs](http://localhost:8080/v3/api-docs).\
swagger docs can be viewed on: [swagger-ui](http://localhost:8080/swagger-ui/index.html).


# pros/cons
### Pros
- its very simple do get api documentation by added some dependencies
- documentation of the annotations is good
- we can serve this documentation to users of the api
- validation is done by annotations and described in the api
### Cons
- documentation is done in the code
- code is still a manually process which can have errors
