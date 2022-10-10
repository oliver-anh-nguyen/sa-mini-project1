# SA Mini Project
## Members
1. Tuan Anh Nguyen
2. Tan Phat Nguyen

## Build project
```
$ cd sa-mini-project1
$ ./gradlew build
```
### Please refer a 3 minute-video for the quick demo
   https://mum0-my.sharepoint.com/:v:/g/personal/tan_nguyen_miu_edu/EXyPpJKbJPVAnnx-uXLurEEBfS9x98lHcHX-alIOaYKZMg?e=yGC9xa

## Run project
1. Run docker compose to deploy the services
```
$ docker compose -f docker-compose.prod.yml up -d
```
2. Monitor logs
```
$ docker compose -f docker-compose.prod.yml logs -f
```
3. Get JWT token
```
$ curl --location --request POST 'http://localhost:8080/api/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "phat",
    "password": "123"
}'
```
<img src="./markdown/get_token.png" alt="Alt text" title="Get Token">

6. Trigger job with token

```
$ curl --location --request POST 'http://localhost:8080/api/admin/batch' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJYbGt5R1RwZDV4TXVRTk5iVDJHUldZazkyOERWQUVHRGxiWU1aRzBmUDljIn0.eyJleHAiOjE2NjUzNjU2MTIsImlhdCI6MTY2NTM2NTMxMiwianRpIjoiYTkwYjYxNGItODliZS00M2ZhLTg0NzMtZGM2MGRjNjdjYzBiIiwiaXNzIjoiaHR0cDovL3NhLWtleWNsb2FrOjkwOTAvcmVhbG1zL3NhLW1pbmktcHJvamVjdDEtcmVhbG0tcHJvZCIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0YzViYzYyYy1mZGE3LTQ1ODAtODI0Zi1jNzNmMTFlNjFiNjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJzYS1taW5pLXByb2plY3QxIiwic2Vzc2lvbl9zdGF0ZSI6IjkxOTE2YTU2LTlmMzEtNDQyOS04YmU4LWJlMjQ5NWZmYWM3NSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL3NhLW1pbmktcHJvamVjdDEtc2VydmljZTo4MDgwIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXNhLW1pbmktcHJvamVjdDEtcmVhbG0iLCJvZmZsaW5lX2FjY2VzcyIsIkFETUlOIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InNhLW1pbmktcHJvamVjdDEtYXBwIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiI5MTkxNmE1Ni05ZjMxLTQ0MjktOGJlOC1iZTI0OTVmZmFjNzUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc2EtbWluaS1wcm9qZWN0MS1yZWFsbSIsIm9mZmxpbmVfYWNjZXNzIiwiQURNSU4iLCJ1bWFfYXV0aG9yaXphdGlvbiJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJwaGF0IiwiZ2l2ZW5fbmFtZSI6IiIsImZhbWlseV9uYW1lIjoiIn0.VTBKyQeyUS7KkYzLoTd57i48NQYrf85o6L3LgCbq-iMlYQzGUtmZX_-V8nDBjEL0_BbzFOEZpQ_QM1iWKtTlfBCaX_2BHdrgkH-lsQ8P7mTCtUIu5bEieB-ms0ekILWtFhcTcT8GNQbsVq4WxBywW2I3FOAXJh9H58BfwtcAvuwIhZtv-3qy7B4zHfY4y3A9fA8Cxp9WAAOxRUA2fblExsOx7VwFMss-7_sZxcxKSSUkVBZLq-2TUhs8wydvEzwxWk7LNuekC_mTnupi8RTuQ7U6UfwYdZTVAk0KxBWZOfFiEm_lWyUAntNgkcRE7K8RM59O8Uf3tv7mWBJKc0sx2Q'
```
<img src="./markdown/trigger_job.png" alt="Alt text" title="Batch Job">

7. Verify result in logs or postgres client
   <img src="./markdown/people.png" alt="Alt text" title="People">

8. Shutdown all containers
```
$ docker compose -f docker-compose.prod.yml down
```


