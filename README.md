#  MultiGenesys E-Commerce Backend API

Welcome to the **MultiGenesys E-Commerce Backend**! This is a robust, scalable RESTful API built with **Spring Boot** and **Java 17**. It handles core e-commerce functionalities including user authentication (JWT), product management, shopping carts, and order processing.

---

##  Features
* **User Authentication & Authorization:** Secure registration and login using JSON Web Tokens (JWT).
* **Product Management:** CRUD operations for e-commerce products.
* **Shopping Cart:** Add products to cart, remove items, and clear cart.
* **Order Processing:** Place orders, track order history, and update order statuses.
* **Automated Database Management:** Hibernate automatically creates and updates MySQL tables.

---

##  Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Spring Security)
* **Security:** JWT (JSON Web Tokens)
* **Database:** MySQL
* **Build Tool:** Maven
* **Utilities:** Lombok, Postman (for API testing)

---

##  Database Schema (Entities)
When the application runs, Hibernate automatically generates the following tables in MySQL:
1. `users`: Manages user accounts (id, email, password, role).
2. `product`: Stores product catalog (id, name, description, price, stock_quantity, image_url).
3. `cart_item`: Manages items currently in a user's shopping cart.
4. `orders`: Tracks user orders (total_price, shipping_address, payment_status).
5. `order_item`: Maps specific products and their quantities to an order.

---

##  Project Setup & Installation (Start Point)

Follow these steps to set up and run the project on your local machine.

### 1. Prerequisites
Ensure you have the following installed:
* [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [MySQL Server & Workbench](https://dev.mysql.com/downloads/installer/)
* IDE (Eclipse / IntelliJ IDEA / STS / VS Code)

### 2. Clone the Repository
```bash
git clone <your-github-repository-url>
cd MultiGenesys
```

### 3. Database Configuration
Open your MySQL workbench or MySQL Command Line and create a new database:
```sql
CREATE DATABASE ecommerce_db;
```

### 4. Application Properties
Navigate to `src/main/resources/application.properties` and verify your database credentials:
```properties
# Server Port
server.port=8080

# Database Connection
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_mysql_password_here

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
*( **Note:** Replace `your_mysql_password_here` with your actual MySQL password).*

---

##  Running the Application

You can run the application directly from your IDE by executing the `MultiGenesysApplication.java` file, or via the terminal using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

If successful, you will see the Spring Boot logo in the console, and the server will start on `http://localhost:8080`.

---

##  API Endpoints Reference

Below is the complete list of REST API endpoints available in the MultiGenesys E-Commerce Backend:

| Module / Feature | HTTP Method | Endpoint URL | Description |
| :--- | :--- | :--- | :--- |
| **Authentication** | `POST` | `/api/auth/register` | Register a new user account |
| **Authentication** | `POST` | `/api/auth/login` | Authenticate user & receive JWT token |
| **User Profile** | `GET` | `/api/users/{id}` | Get specific user profile details |
| **Products** | `GET` | `/api/products` | Retrieve a list of all products |
| **Products** | `GET` | `/api/products/{id}` | Retrieve details of a specific product |
| **Products** | `POST` | `/api/products` | Add a new product to the catalog |
| **Products** | `PUT` | `/api/products/{id}` | Update an existing product's details |
| **Products** | `DELETE` | `/api/products/{id}` | Remove a product from the catalog |
| **Shopping Cart**| `GET` | `/api/cart/{userId}` | Get the current items in a user's cart |
| **Shopping Cart**| `POST` | `/api/cart/add` | Add a product to the shopping cart |
| **Shopping Cart**| `DELETE` | `/api/cart/remove/{cartItemId}`| Remove a specific item from the cart |
| **Shopping Cart**| `DELETE` | `/api/cart/clear/{userId}` | Empty the entire shopping cart |
| **Orders** | `POST` | `/api/orders/placeOrder` | Place a new order from cart items |
| **Orders** | `GET` | `/api/orders/user/{userId}` | Retrieve the order history of a user |
| **Orders** | `PUT` | `/api/orders/{orderId}/status` | Update the status of an existing order |

> ** Testing Note:** Use Postman or Swagger to test these endpoints. Secured endpoints require a valid JWT token. Pass the token in the request header as: `Authorization: Bearer <your_token>`

---

##  Security Notes
This project is secured using **Spring Security** and **JWT**. 
* For development and testing, some APIs might be open (`permitAll()`) in the `WebSecurityConfig`. 
* When APIs are secured, ensure you include the JWT token in your API client requests.

---
**Developed by:** Rupesh Patil  
**Version:** 1.0.0