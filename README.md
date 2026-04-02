# Currency Converter - Spring Boot

A Spring Boot REST API that loads currency exchange rates from an XML file into an H2 database on startup and converts between currencies.

## Tech Stack
- Java 21
- Spring Boot 4.x
- Spring Data JPA
- H2 Database
- Maven

## Project Structure
```
src/
├── main/
│   ├── java/com/example/currency_converter_service/
│   │   ├── advice/
│   │   │   ├── ErrorResponseDto.java
│   │   │   └── GlobalExceptionHandler.java
│   │   ├── config/
│   │   │   └── AppConfig.java
│   │   ├── controller/
│   │   │   └── CurrencyConvertorController.java
│   │   ├── dto/
│   │   │   └── CurrencyDetailDto.java
│   │   ├── entity/
│   │   │   └── CurrencyDetail.java
│   │   ├── exception/
│   │   │   └── ResourceNotFoundException.java
│   │   ├── repository/
│   │   │   └── CurrencyConvertorRepository.java
│   │   ├── service/
│   │   │   ├── CurrencyConvertorService.java
│   │   │   └── CurrencyConvertorServiceImpl.java
│   │   ├── CurrencyConverterServiceApplication.java
│   │   └── DataLoader.java
│   └── resources/
│       ├── fx-rates.xml

## Setup & Run

1. Clone the repo
```
git clone https://github.com/your-username/currency-converter.git
cd currency-converter
```

2. Run the app
```
mvn spring-boot:run
```

3. App starts at `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /convert?from=USD&to=INR&amount=100 | Convert currency |

## H2 Console
```
URL:      http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:currencydb
Username: sa
Password: (leave blank)
```

## application.properties
```
spring.datasource.url=jdbc:h2:mem:currencydb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.defer-datasource-initialization=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
