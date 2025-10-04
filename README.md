# 🛒 E-Commerce Microservices Project

- Built using **Spring Boot**, **Spring Cloud Gateway**, and **Gradle**
- Contains **Product Microservice** and **Order Microservice**
- Integrated with **MySQL database** for persistent storage
- **Role-based security** with in-memory authentication:
  - Admin: full access to Product service
  - User: access only to Order service
- **REST Template** used for communication between Product and Order services
- **API Gateway** as the single entry point with security configuration
- **Global Exception Handling** implemented in both Product and Order services
- Exposes **REST APIs** for interaction between services
