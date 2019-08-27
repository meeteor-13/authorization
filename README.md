
# Authorization Service

> OAuth2 OIDC service powered by Red Hat.

## Usage

### Docker

Bootstrap project using docker-compose:
```
docker-compose up
```

Create an account on an already running container by running:
```
docker exec <container> keycloak/bin/add-user-keycloak.sh -u <username> -p <password>
```

Stop and remove containers, networks, images:
```
docker-compose down
```

### How to use

So, all necessary public urls are here:

`http://localhost:8081/auth/realms/meeteor13/.well-known/openid-configuration`
