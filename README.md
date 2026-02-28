# FoodDeliveryApplication
Java-based Food Delivery Web Application developed using Servlets, JSP, JDBC, and MySQL. Implements user authentication, restaurant and menu listing, cart management, and a checkout flow. Built as a backend-focused full-stack learning project using MVC-style architecture.
# Food Delivery Application

## Project Overview

This project is a **Java-based Food Delivery Web Application** developed as part of my full‑stack learning journey. The application focuses on **backend logic, request flow, database interaction, and session management** using core Java web technologies.

The system allows users to register, log in, browse restaurants and food items, add items to a cart, and proceed through a checkout flow. The emphasis of this project is on **how data moves between pages**, how user actions are handled, and how information is stored and retrieved from the database.

The application follows an **MVC‑style architecture**:

* **Model** → JDBC‑based DAO classes and database tables
* **View** → JSP pages (UI)
* **Controller** → Java Servlets (request handling & navigation)

---

## Technologies Used

### Backend

* Java
* Java Servlets
* JDBC
* Apache Tomcat

### Frontend

* JSP (JavaServer Pages)
* HTML
* CSS

### Database

* MySQL

### Tools

* Eclipse IDE
* MySQL Workbench
* Git & GitHub

---

## Application Architecture (MVC‑Style)

### Controller Layer (Servlets)

* Handles all incoming HTTP requests
* Processes user input from JSP forms
* Communicates with DAO classes for database operations
* Controls page navigation using redirects and forwards
* Manages session data such as logged‑in user and cart

### Model Layer (JDBC & DAO)

* Java classes represent entities such as User, Restaurant, FoodItem, and CartItem
* DAO classes handle:

  * Database connections
  * SQL queries (INSERT, SELECT, UPDATE)
  * Data mapping between database tables and Java objects

### View Layer (JSP)

* Displays dynamic data sent by servlets
* Collects user input through forms
* Shows validation messages and error feedback
* Uses session and request attributes to render UI state

---

## User Flow & Page Navigation

### 1. User Registration

* User enters details such as name, email, and password
* Form data is submitted to a **Register Servlet**
* Servlet validates input and stores user data in the database using JDBC
* On success, user is redirected to the login page

---

### 2. User Login

* User enters email and password on the login page
* Login Servlet:

  * Retrieves user data from the database using JDBC
  * Validates credentials
  * Creates an HTTP session on successful login
* On successful authentication:

  * User is redirected to the restaurant listing page
* On failure:

  * User is redirected to an error or retry page

---

### 3. Restaurant Listing

* Restaurants are fetched from the database using DAO classes
* Data is sent from the servlet to the JSP using request attributes
* JSP dynamically displays available restaurants
* User selects a restaurant to view its menu

---

### 4. Menu & Food Items

* Selected restaurant ID is passed as a request parameter
* Servlet retrieves food items related to that restaurant
* Menu items are displayed dynamically using JSP
* Each item has an **Add to Cart** option

---

### 5. Cart Management

* Cart data is stored in the **HttpSession**
* When a user adds an item:

  * Item details are added to a session‑based cart object
* Cart page allows:

  * Viewing selected items
  * Updating quantities
  * Removing items
* Cart data persists across pages during the session

---

### 6. Checkout Flow

* Cart is validated before checkout
* User proceeds to checkout page
* Order details are prepared from session data
* (Order persistence can be extended in future updates)

---

## Input Handling & Validation

* JSP forms collect user input (login, registration, cart actions)
* Servlets:

  * Read request parameters
  * Validate data
  * Control navigation based on input correctness
* Prevents unauthorized access using session checks

---

## Session Management

* HttpSession is used to:

  * Track logged‑in users
  * Maintain cart state across multiple pages
  * Control page access
* Session invalidation is handled during logout

---

## Database Design

* Relational tables created in MySQL
* Tables include:

  * Users
  * Restaurants
  * Food Items
  * Cart / Order‑related structures
* JDBC is used for all database communication

---

## Error Handling & Navigation Control

* Invalid login credentials redirect users appropriately
* Missing sessions redirect users to login page
* Servlet mappings ensure controlled page access

---

## Project Status

🚧 **In Progress**

Planned improvements:

* Order history
* Admin module for restaurant and menu management
* Payment simulation
* Improved UI and validation

---

## Purpose of This Project

This project demonstrates:

* Practical understanding of Java web development
* Clear request‑response flow using Servlets and JSP
* JDBC‑based database interaction
* Session handling and page navigation logic


