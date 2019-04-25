
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

## Env Prerequisites

```
✗ java -version
  openjdk version "11.0.2" 2019-01-15 LTS
  OpenJDK Runtime Environment Zulu11.29+3-CA (build 11.0.2+7-LTS)
  OpenJDK 64-Bit Server VM Zulu11.29+3-CA (build 11.0.2+7-LTS, mixed mode)

✗ mvn -v
  Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T22:00:29+03:00)
  Maven home: /Users/solairerove/.sdkman/candidates/maven/current
  Java version: 11.0.2, vendor: Azul Systems, Inc., runtime: /Users/solairerove/.sdkman/candidates/java/11.0.2-zulu
  Default locale: en_BY, platform encoding: UTF-8
  OS name: "mac os x", version: "10.14.4", arch: "x86_64", family: "mac"

✗ docker -v
  Docker version 18.09.2, build 6247962

✗ docker-compose -v
  docker-compose version 1.23.2, build 1110ad01
```

## Usage

### Local

Run application:
```
mvn spring-boot:run
```

Run tests:
```
mvn test
```

Build application artifact:
```
mvn clean install
```

Build application artifacts (without tests):
```
mvn clean install -Dmaven.test.skip=true
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
