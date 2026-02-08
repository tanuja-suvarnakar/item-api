# Item API - Sample Java Backend

This is a simple Java Spring Boot application that exposes a RESTful API
for managing a collection of items (e.g., ecommerce products).

Data is stored in an in-memory `ArrayList`, so all data is lost when
the application restarts.

## Tech Stack

- Java 17
- Spring Boot (Spring Web, Validation)
- Maven
- In-memory storage using `ArrayList`

## How to Run Locally

### Prerequisites

- Java 17 installed
- Maven installed

### Steps

1. Clone or download this repository.
2. Open a terminal in the project root directory (where `pom.xml` is located).
3. Run:

   ```bash
   mvn spring-boot:run

4.The application will start on port 8080.

Base URL: http://localhost:8080

API Endpoints
1. Add a New Item
URL: POST /api/items
Content-Type: application/json

Request Body Example:
{
  "name": "iPhone 15",
  "description": "Latest Apple smartphone",
  "price": 999.99,
  "category": "Electronics"
}

Validation Rules:

name: required, max 100 characters
description: required, max 500 characters
price: required, must be zero or positive
category: required
Success Response (201 Created):

{
  "id": 1,
  "name": "iPhone 15",
  "description": "Latest Apple smartphone",
  "price": 999.99,
  "category": "Electronics"
}

If validation fails, a 400 Bad Request is returned with details.

2. Get Single Item by ID
URL: GET /api/items/{id}

Example:

GET /api/items/1

Success Response (200 OK):
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Latest Apple smartphone",
  "price": 999.99,
  "category": "Electronics"
}

If item does not exist:

Response code: 404 Not Found
Health Check 
URL: GET /api/items/health
Returns a simple plain-text message to confirm that the API is running.

Implementation Details
Item class represents an item with:
id
name
description
price
category
ItemService manages items in an in-memory ArrayList.
CreateItemRequest is used for input validation when creating an item.
Validation annotations (@NotBlank, @Size, @PositiveOrZero, etc.) ensure required fields and constraints are satisfied.


## Deployment

This project is containerized with Docker and deployed on Render (free tier).

**Live Base URL:**  
https://item-api-xrfy.onrender.com

### Available Endpoints on Production

- Health Check  
  `GET https://item-api-xrfy.onrender.com/api/items/health`

- Add a New Item  
  `POST https://item-api-xrfy.onrender.com/api/items`  
  Body (JSON example):

  ```json
  {
    "name": "iPhone 15",
    "description": "Latest Apple smartphone",
    "price": 999.99,
    "category": "Electronics"
  }

  Get Item by ID
GET https://item-api-xrfy.onrender.com/api/items/{id}
Notes
The application is deployed on Render's free tier, so if it is idle for some time, the service may go to sleep.
When the first request comes after being idle, it might take a few seconds to start ("cold start").
After that, responses are fast and the API works as expected.

