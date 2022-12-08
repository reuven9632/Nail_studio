"# Nail_studio" 

### CURL
```
curl --location --request POST 'localhost:8080/api/v1/registration' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "ReuvenS",
    "lastName": "Nail-studio",
    "email": "reuven1856@gmail.com",
    "password": "password"
}'
```