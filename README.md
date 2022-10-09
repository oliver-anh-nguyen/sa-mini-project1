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
curl --location --request POST 'http://localhost:8080/api/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "phat",
    "password": "123"
}' | jq
```
6. Trigger job with token
```
curl --location --request POST 'http://localhost:8080/api/admin/batch' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJNY0I0emhRaEdhWFJZdHpPbDVjYUdXaWFIMkFGcUpBdVM1cktMMFg1LXpVIn0.eyJleHAiOjE2NjUzMzI1MjIsImlhdCI6MTY2NTMzMjIyMiwianRpIjoiZDFmZjkwNjAtYmFkMy00Y2UzLTlhZmMtZjExOTMyNTU5NmU0IiwiaXNzIjoiaHR0cDovL3NhLWtleWNsb2FrOjkwOTAvcmVhbG1zL3NhLW1pbmktcHJvamVjdDEtcmVhbG0tcHJvZCIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJkNDQ3ZDUxMi02ODYxLTRmOTItOTE1NS03YWZhOTk2YWFhZDIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJzYS1taW5pLXByb2plY3QxIiwic2Vzc2lvbl9zdGF0ZSI6ImFlNmRlNmVlLWE4NGItNDVjOS1iMGFkLTI4YjVlZWZhYTRkOSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL3NhLW1pbmktcHJvamVjdDEtc2VydmljZTo4MDgwIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXNhLW1pbmktcHJvamVjdDEtcmVhbG0iLCJvZmZsaW5lX2FjY2VzcyIsIkFETUlOIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InNhLW1pbmktcHJvamVjdDEtYXBwIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiJhZTZkZTZlZS1hODRiLTQ1YzktYjBhZC0yOGI1ZWVmYWE0ZDkiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc2EtbWluaS1wcm9qZWN0MS1yZWFsbSIsIm9mZmxpbmVfYWNjZXNzIiwiQURNSU4iLCJ1bWFfYXV0aG9yaXphdGlvbiJdLCJuYW1lIjoiUGhhdCBOZ3V5ZW4iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJwaGF0IiwiZ2l2ZW5fbmFtZSI6IlBoYXQiLCJmYW1pbHlfbmFtZSI6Ik5ndXllbiIsImVtYWlsIjoicGhhdEBnbWFpbC5jb20ifQ.qxvHDwFHQO-L2qvNtA3zKW8rIHvucd_7yTjrq-0QT8B2uSGJdbl0wJZdRXk1-ggkrfWHPL6RncN6SDzY5hiPWjknXyO4_K169sz8kzf9WLtHCaiN5ho7uwuz0sf8c7tIN2Buj4hxacmdXbPjqXwYlJjE9qbNjAmtw4-0AabkyoEBhQbyX39GTXscMU1VLEMbyxiF0qquZFqPv2aB7-EAlvbSOlr8AdLEPDs3Hw9YOKpvz2lsnn2gfwXzMEx0EucAlPqb9nlcBQtK14bUkuA8aeB-y1Rr5XlUDVSTk_txwZtgypw5nEhWgEy006U5dQTk0Pw-ZkqPSVbSvD64yfoG1Q'
```
7. Verify result in logs or postgres client
   <img src="./markdown/people.png" alt="Alt text" title="People">
