# SA Mini Project
## Members
1. Tuan Anh Nguyen
2. Tan Phat Nguyen

## Run project
1. Run docker compose to deploy the services
```
$ docker compose -f docker-compose.prod.yml up -d
```
2. Monitor logs
```
$ docker compose -f docker-compose.prod.yml logs -f
```
3. Import Realm into Keycloak
- Navigate to (http://localhost:9090/) to open Keycloak
- Select Create Realm -> Browser to file *realm-export.prod.json* to and click on Create
4. Create User
Create user and assign roles to ADMIN e.g username: phat, password: 123
5. Get JWT token
```
curl --location --request POST 'http://localhost:9090/realms/sa-mini-project1-realm-prod/protocol/openid-connect/token' \
--header 'Authorization: Basic c2EtbWluaS1wcm9qZWN0MTpmM2lndGVRaDBGZTR4SjZTMUtXMmt2dW1NcWtFRFNLbg==' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=phat' \
--data-urlencode 'password=123' | jq
```
6. Trigger job
```

```
