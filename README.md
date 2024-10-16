# jwt-auth project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
(maybe you need first mvn wrapper:wrapper to generate .mvn directory)

```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `jwt-auth-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/jwt-auth-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
`./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/jwt-auth-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please
consult https://quarkus.io/guides/building-native-image.

## Running in DEV mode with Dev services

This code project needs a PostgreSQL database. Because no DB parameters are configured in the dev profile, Quarkus will
start a testcontainer containing a PostgresSQL database. The name of the database created inside the testcontainer is
equal to 'quarkus'. When you want to login to the database the username and password are also equal to 'quarkus'.

NOTE: to use DEV services (which are based on testcontainers) one needs to install docker or podman