# 🚀 TinyURL Distributed Shortener Service

A **high-performance, scalable, and distributed URL shortener** built
with **Spring Boot microservices architecture**.\
Implements **Redis caching**, **Bloom Filters**, **Base62 encoding**,
and **unique ID generation** for fast and reliable URL shortening.

------------------------------------------------------------------------

## 🧩 Architecture Overview

This project is built around multiple microservices:

1.  **Shortening Service** -- Converts long URLs to short URLs using
    Base62 encoding.
2.  **ID Generator Service** -- Generates globally unique IDs using
    distributed ID generation.
3.  **Redis Cache Layer** -- Accelerates URL lookups and reduces
    database load.
4.  **Database Layer** -- Stores persistent mappings of long and short
    URLs.
5.  **API Gateway + Load Balancer** -- Routes and balances requests
    between microservices.

------------------------------------------------------------------------

## ⚙️ Technologies Used

-   **Spring Boot 3+**
-   **Spring Cloud (Eureka, Config Server, Gateway)**
-   **Redis**
-   **MySQL / PostgreSQL**
-   **Bloom Filter (Google Guava)**
-   **Docker & Docker Compose**

------------------------------------------------------------------------

## 🏗️ How to Run Locally

``` bash
# Clone the repository
git clone https://github.com/moonmido/tinyurl-microservice.git
cd tinyurl-microservice

# Build services
mvn clean install

# Run Docker Compose
docker-compose up -d
```

Services should now be accessible at:\
`http://localhost:8761` → Register Server
`http://localhost:8090` → ID Generator Service
`http://localhost:8091` → Url Shortening & Redirection Service


------------------------------------------------------------------------

## 📖 License

This project is licensed under the **MIT License**.

