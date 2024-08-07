# Voter Management System

## Overview

The Voter Management System is a Spring Boot application designed to manage voter information efficiently. This system allows administrators to add, update, and view voter details through a user-friendly web interface built with Thymeleaf.

## Features

- **Add Voter**: Create new voter records with details such as name, date of birth, gender, username, and password.
- **Update Voter**: Edit existing voter information easily using a dedicated update form.
- **View Voters**: List all voters with their respective details for quick access and management.
- **Form Validation**: Ensure data integrity with robust validation for voter name, date of birth, and other fields.
- **User-Friendly Interface**: Leverage Thymeleaf templates for a clean and intuitive user experience.

## Technologies Used

- **Java**: Core programming language for the backend logic.
- **Spring Boot**: Framework for building the application and managing dependencies.
- **Hibernate**: ORM tool for database interactions.
- **Thymeleaf**: Templating engine for rendering dynamic web pages.
- **Jakarta Persistence API (JPA)**: For object-relational mapping.
- **Jakarta Validation**: For validating input fields.
- **MySQL**: Database for storing voter information.

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/voter-management-system.git
   cd voter-management-system


 **application properties**
spring.datasource.url=jdbc:mysql://localhost:3306/voter_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
