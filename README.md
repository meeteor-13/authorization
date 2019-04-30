
# Authorization Service

> Authorization service powered by Spring Boot. Default implementation of password flow using OAuth2 protocol
[![java version][java-image]][java-url]
[![build status][travis-image]][travis-url]
[![release][release-image]][release-url]
[![license][license-image]][license-url]

[java-image]: https://img.shields.io/badge/java-%3E%3D11-brightgreen.svg?style=flat-square
[java-url]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[release-image]: https://img.shields.io/github/release/meeteor-13/core-service.svg?style=flat-square
[release-url]: https://github.com/meeteor-13/core-service/releases
[travis-image]: https://img.shields.io/travis/meeteor-13/core-service/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/meeteor-13/core-service
[license-image]: https://img.shields.io/github/license/mashape/apistatus.svg?style=flat-square
[license-url]: https://github.com/meeteor-13/core-service/blob/master/LICENSE

## Technologies

* [Java](https://openjdk.java.net/)
* [Maven](https://maven.apache.org/)
* [Spring](https://spring.io/)

## Usage

### Local

Run application:
```
./mvnw spring-boot:run
```

Run tests:
```
./mvnw test
```

Build application artifact:
```
./mvnw clean install
```

Build application artifacts (without tests):
```
./mvnw clean install -Dmaven.test.skip=true
```

### Docker

Bootstrap project using docker-compose:
```
docker-compose up
```

Stop and remove containers, networks, images:
```
docker-compose down
```

## To perform requests

### Password flow

Retrieve access token
```
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Authorization: Basic Z3JlZXRpbmctc2VydmljZTpncmVldGluZy1zZWNyZXQ=' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'grant_type=password&username=solairerove&password=strongpwd'
```

Check access token
```
curl -X POST \
  'http://localhost:8080/oauth/check_token?token=840237df-9c14-4ca8-9449-35dfed7e52ba' \
  -H 'Authorization: Basic Z3JlZXRpbmctc2VydmljZTpncmVldGluZy1zZWNyZXQ=' \
  -H 'cache-control: no-cache'
```
