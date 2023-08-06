1.Your choices of framework :

        Spring Boot: I have included dependencies such as spring-boot-starter-data-jpa and spring-boot-starter-web, indicating that are building a Spring Boot application. Spring Boot is a popular framework for building Java-based web applications with simplified configuration and development.

        Hibernate: I have included dependencies related to Hibernate, such as hibernate-core and hibernate-entitymanager. Hibernate is an Object-Relational Mapping (ORM) framework that simplifies database interactions and provides a way to map Java objects to database tables.

         MySQL Database: I have included the mysql-connector-j dependency, which indicates that are using MySQL as my database.

2.Your DB Schema:

      2.1 Data Entity:
          Table Name: data
          Columns:
          id: Primary Key (Auto-generated)
          key: Unique identifier for the data
          value: The value associated with the key

    2.2 User Entity:
        Table Name: user
        Columns:
        id: Primary Key (Auto-generated)
        username: Unique username for the user
        email: Unique email address for the user
        password: User's password
        fullName: Full name of the user
        age: Age of the user
        gender: Gender of the user

        Based on the entity definitions, the database have two tables:
        
        data:
             Columns: id, key, value
        user:
            Columns: id, username, email, password, fullName, age, gender

3.instructions to run the code:

Step 1: Set Up the Development Environment

Before you begin, ensure that you have the following tools installed:

* Java Development Kit (JDK) 17 or later
* Apache Maven
* MySQL Database Server

Step 2: Configure the Database

Create a MySQL database named project (or a name of your choice) with the username root and password ROOT.
Make sure the database server is up and running.

Step 3: Clone the Project

Clone the project from your repository using Git or download the project source code as a ZIP file and extract it.

Step 4: Build the Project

Step 5: Run the Application

After building the project, you can run the Spring Boot :

Step 6: Access the API Endpoints

Once the application is running, you can access the API endpoints using a tool like  Postman, or any web browser.

To store data:
POST request to http://localhost:8080/api/data with JSON body: {"key": "your-key", "value": "your-value"}

To retrieve data:
GET request to http://localhost:8080/api/data/{key} (replace {key} with the actual key)

To update data:
PUT request to http://localhost:8080/api/data/{key} with JSON body: {"value": "new-value"}

To delete data:
DELETE request to http://localhost:8080/api/data/{key} (replace {key} with the actual key)

Step 7: Register User and Generate Token ( it is Optional)
If you want to test the user registration and token generation functionality, you can use the following endpoints:

To register a new user:
POST request to http://localhost:8080/api/register with JSON body containing user details.

To generate a token:
POST request to http://localhost:8080/api/token with JSON body containing username and password.

4.Instructions to setup the code:

        Step 1: Install Required Software
        Step 2: Set Up the Database
        Step 3: Clone the Project
        Step 4: Configure the Database Connection
        Step 5: Build and Run the Application
        Step 6: Interact with the API Endpoints
