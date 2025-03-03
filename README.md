# Overseas Consultancy System

This project is designed to help students **appoint teachers and arrange meetings** for overseas education consultation. It is built using **Spring Boot, Spring Security, and JSP** to provide a secure and interactive platform.

## Features

### **For Students**
- Register and log in securely using **Spring Security**.
- Browse available teachers based on expertise and location.
- Schedule meetings with selected teachers.
- View and manage upcoming appointments.

### **For Teachers**
- Register and manage profile details.
- Accept or decline student meeting requests.
- Provide consultation services through scheduled appointments.

### **Admin Panel**
- Manage student and teacher registrations.
- Monitor scheduled meetings and ensure smooth operations.
- Handle security and authentication settings.

## Technologies Used
- **Spring Boot** - Backend development
- **Spring Security** - Authentication and authorization
- **JSP** - Frontend UI
- **Hibernate / JPA** - Database interaction
- **PostgreSQL** - Database storage

## Installation & Setup

### **Prerequisites**
- Java 17+
- Maven
- PostgreSQL database

### **Clone the Repository**
```sh
 git clone https://github.com/your-repo/overseas-consultancy.git
 cd overseas-consultancy
```

### **Configure Database**
Modify `application.properties` to set up database credentials:
```properties
spring.datasource.url=jdbc:postgres://localhost:3306/consultancydb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### **Build & Run the Application**
```sh
mvn clean install
mvn spring-boot:run
```

## Future Enhancements
- Video call integration for remote consultations.
- AI-based teacher recommendations based on student preferences.
- Payment integration for paid consultation sessions.

---
This project simplifies overseas education consultation by providing an easy-to-use platform for students and teachers. 🚀

