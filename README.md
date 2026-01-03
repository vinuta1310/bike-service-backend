# 🚲 Bike Service Management – Backend

A Spring Boot backend application for managing bikes and service bookings.  
It provides REST APIs for bike CRUD operations and service booking management.

---

## ⚡ Features

- Add, view, update, and delete bikes
- Create and view service bookings
- RESTful APIs using Spring Boot
- MySQL database integration
- Clean layered architecture (Controller, Repository)

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

---

## 🚀 How to Run

### 1️⃣ Open terminal in the backend folder

```bash
cd bike-service-backend/backend
```

### 2️⃣ Ensure MySQL is running

Update credentials in `application.properties`:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/bike_service
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3️⃣ Build and run the application
```bash
mvn clean install
mvn spring-boot:run
```
### 4️⃣ Backend runs on
http://localhost:8080

## 📡 API Endpoints
### 🚲 Bike APIs
GET /api/bikes
POST /api/bikes
PUT /api/bikes/{id}
DELETE /api/bikes/{id}

### 🛠️ Service Booking APIs
GET /api/service-bookings
POST /api/service-bookings

## 📸 Screenshots
### Add Bike
![post Bike](Screenshots/postBike.png)
### Bike List
![get Bike](Screenshots/getBike.png)
### Delete Bike
![delete Bike](Screenshots/deleteBike.png)
### Service Booking
![get Serive Booking](Screenshots/postService.png)