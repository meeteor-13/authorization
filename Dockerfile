# ===============================
# [ Builder image ]
# ===============================
FROM openjdk:11-jdk-slim AS BUILDER

ARG WORK_DIR=/meeteor13

COPY . $WORK_DIR
WORKDIR $WORK_DIR

RUN ./mvnw -Dmaven.test.skip=true install

# ===============================
# [ Production image ]
# ===============================
FROM openjdk:11-jre-slim

LABEL name="meeteor13-authorization" \
      maintainer="solairerove@gmail.com"

ARG WORK_DIR=/meeteor13

ENV SERVER_PORT=8090 \
    JAVA_OPTS=""

WORKDIR $WORK_DIR
COPY --from=BUILDER $WORK_DIR/target/*.jar .

EXPOSE $SERVER_PORT
CMD java $JAVA_OPTS -Djava.security.egd=file:/dev/urandom -jar *.jar
