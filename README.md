# Ricket Project

## Purpose
Create a simple order flow with notification sending.

### Technologies Used
1. **Spring Boot**
2. **RSocket**
3. **REST API**
4. **GraphQL**
5. **Temporal**
6. **Microservices**

## Setup Environment

Stay at the root of the project and follow these steps:

1. Navigate to the `env` directory:
   ```sh
   cd env
   ```
2. Start the environment using Docker Compose:
   ```sh
   docker-compose up -d
   ```
3. Register the Temporal namespace:
   ```sh
   docker exec temporal-admin-tools tctl --ns order-namespace namespace register
   ```

## Get App Password

Follow this guide to create an app password for Gmail:  
🔗 [How to Create an App Password on Gmail](https://bestsoftware.medium.com/how-to-create-an-app-password-on-gmail-e00eff3af4e0)

Once you have the **app password**, you can configure it in two ways:

1. Directly set the app password in `order-service/app/src/main/resources/application.properties`:
   ```properties
   MAIL_APP_PASSWORD=your-app-password
   ```
2. Pass it as an environment variable when starting the application:
   ```sh
   export MAIL_APP_PASSWORD=your-app-password
   ```

## Test Application

### Open Temporal Client
Access Temporal UI at:  
🔗 [http://localhost:8080/namespaces/order-namespace/workflows](http://localhost:8080/namespaces/order-namespace/workflows)

> **Note:** You **must** register the namespace before using the Temporal client!

### Test API
Use the following `curl` command to test the order creation API:

```sh
curl --location 'http://localhost:8075/order/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customerName": "Nguyen Van A",
    "orderDate": "2025-01-01",
    "totalAmount": 17500,
    "status": "PENDING",
    "email": "xxxxxx@gmail.com",
    "phoneNumber": "09112839xxxx",
    "notificationMethod": "MAIL"
}'
```

This request will create a new order with an email notification.
