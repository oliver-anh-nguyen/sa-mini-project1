realmName="demo"
client_id="spring_keycloak_demo_client"
client_secret="9ee1dcb4-4983-4ee5-b8a2-ae384f6fc4e5"

echo "Starting creation of $realmName realm. Your clientId: $client_id clientSecret: $client_secret"

# login
docker-compose exec keycloak /opt/jboss/keycloak/bin/kcadm.sh config credentials --server http://localhost:9090/auth --realm master --user admin --password admin

# Create realm
docker-compose exec keycloak /opt/keycloak/bin/kcadm.sh create realms -s realm=$realmName -s enabled=true
