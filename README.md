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
6. Regenerate client secret
   <img src="./markdown/Regenerate.png" alt="Alt text" title="People">
5. Get JWT token
```
Trigger POST request to http://localhost:9090/realms/sa-mini-project1-realm-prod/protocol/openid-connect/token
```
<img src="./markdown/get_token_1.png" alt="Alt text" title="Step1">
<img src="./markdown/get_token_2.png" alt="Alt text" title="Step2">
<img src="./markdown/get_token_3.png" alt="Alt text" title="Step3">

6. Trigger job with token

```
Trigger POST request to http://localhost:8080/api/admin/batch
```
<img src="./markdown/Run_Batch_Job.png" alt="Alt text" title="Batch Job">

7. Verify result in logs or postgres client
   <img src="./markdown/people.png" alt="Alt text" title="People">
