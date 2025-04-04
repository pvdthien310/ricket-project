# ricket-project
## Purposes
    Create a simple order flow with send notification.:
###  1. SpringBoot
###  2. RSocket
###  3. RestApi
###  4. GraghQl
###  5. Temporal
###  6. Microservices

## Setup Environment

    Stay at the root of project
    1. Run 'cd env'
    2. Run 'docker-compose up -d'
    3. Run 'docker exec temporal-admin-tools tctl --ns order-namespace namespace register'

## Get App Password
    
    Read this: https://bestsoftware.medium.com/how-to-create-an-app-password-on-gmail-e00eff3af4e0

After your get **app password**. You have two ways to config
    
    1. You can set the app-password directly in order-service/app/src/main/resources/application.properties file at MAIL_APP_PASSWORD variable
    2. You can start app with env variable MAIL_APP_PASSWORD

## Test Application

### Open Temporal Client
    http://localhost:8080/namespaces/order-namespace/workflows

Note: you MUST run create namespace first !!!

### Test API: 
    curl --location 'http://localhost:8075/order/' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "customerName": "Nguyen Van A",
        "orderDate": "2025-01-01",
        "totalAmount": 17500,
        "status": "PENDING",
        "email": "xxxxxx@gmail.com",
        "phoneNumber": "09112839xxxx",
         "notificationMethod" : "MAIL"
    }'