# Event Management API (Spring Boot + MySQL)

## 📌 Project Overview

This is a **Spring Boot REST API** for managing events. It supports creating and fetching event details using **Spring Data JPA**, **MySQL**, and **DTO-based architecture**.

The project demonstrates:

* RESTful API development
* Layered architecture (Controller → Service → Repository → Entity)
* DTO usage for request/response
* Exception handling
* Swagger/OpenAPI documentation

---

## 🛠️ Technologies Used

* Java 17+
* Spring Boot 3
* Spring Web
* Spring Data JPA
* MySQL Database
* Lombok
* Hibernate
* Swagger / OpenAPI
* Maven

---

## ⚙️ Database Configuration (MySQL)

Update **application.yml**:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/event_db
    username: root
    password: root

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
```

Create database manually:

```sql
CREATE DATABASE event_db;
```

---

## 🗄️ Database Table Structure

**Table: events**

| Column      | Type        | Description             |
| ----------- | ----------- | ----------------------- |
| id          | BIGINT (PK) | Auto-generated event ID |
| title       | VARCHAR     | Event title             |
| description | TEXT        | Event description       |
| location    | VARCHAR     | Event location          |
| event_date  | DATE        | Event date              |
| organizer   | VARCHAR     | Organizer name          |

---

## 🚀 How to Run the Project

1. Open project in **IntelliJ / Eclipse**
2. Start **MySQL server**
3. Create database `event_db`
4. Update credentials in `application.yml`
5. Run:

```
EventManagementApplication.java
```

Server starts at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### 1️⃣ Create Event

**POST** `/api/events`

#### Request Body

```json
{
  "title": "Tech Conference",
  "description": "Spring Boot event",
  "location": "Hyderabad",
  "eventDate": "2026-02-05",
  "organizer": "Sai Krishna"
}
```

#### Response (201 Created)

```json
{
  "id": 1,
  "title": "Tech Conference",
  "description": "Spring Boot event",
  "location": "Hyderabad",
  "eventDate": "2026-02-05",
  "organizer": "Sai Krishna"
}
```

---

### 2️⃣ Get Event by ID

**GET** `/api/events/{id}`

Example:

```
GET http://localhost:8080/api/events/1
```

#### Response (200 OK)

```json
{
  "id": 1,
  "title": "Tech Conference",
  "description": "Spring Boot event",
  "location": "Hyderabad",
  "eventDate": "2026-02-05",
  "organizer": "Sai Krishna"
}
```

#### Error (404 Not Found)

```json
{
  "message": "Event not found with id 1"
}
```

---

## 📘 Swagger API Documentation

After running the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger allows you to:

* View all APIs
* Test endpoints from browser
* See request/response formats

---

## 🧪 Testing with Postman

* Method: **POST** → `http://localhost:8080/api/events`
* Header: `Content-Type: application/json`
* Body: raw JSON

Then test:

* **GET** → `http://localhost:8080/api/events/1`

---

## ❗ Common Errors & Fixes

### 415 Unsupported Media Type

➡ Add header:

```
Content-Type: application/json
```

### Hibernate Dialect Error

➡ Ensure MySQL URL, username, and password are correct in `application.yml`.

### Empty Table

➡ Send POST request before GET.
