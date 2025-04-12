# Compiling instructions

Instructions to compile the Android app using Docker.

## Dependencies

Install Docker on your computer.
- docker.io
- docker-compose-v2

For example:
```
$ sudo apt-get install docker.io docker-compose-v2
```

## Docker compose

Create a file named `docker-compose.yml`. Place it in the
same directory as this project.

File: `docker-compose.yml`  
Content:
```
services:
  sokoban-android-build:
    image: circleci/android:api-30
    container_name: sokoban-android-build
    volumes:
      - ./au.com.codenhall_20_src:/workspace
    working_dir: /workspace
    command: bash
    tty: true
```

## Start container

Start the Docker container:
```
$ docker compose up -d
```

## Compile the project

Connect to the docker container
```
$ docker exec -it --user root sokoban-android-build bash
```

Compile the project using Gradle
```
# ./gradlew clean build
```

The first time you run the command, it takes several minutes
to download Gradle and other dependencies to the docker image.

## Change access rights

Since the project was built using the root user, the generated
files belong to the user root.

Change the owner of the generated files:
```
$ sudo chown -R [user]:[group] au.com.codenhall_20_src/app/build
```

**NOTE**: Replace [user] and [group] with your username.

## Sign the APK

Before you can install the APK on a phone, you need to sign it.

You will need to create a signing key:
```
$ keytool -genkey -v -keystore release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias sokoban
```

Then, you can use the key to sign the APK:
```
$ apksigner sign --ks release-key.jks --ks-key-alias sokoban --out au.com.codenhall_20_src/app/build/outputs/apk/release/au.com.codenhall.sokoban_20.apk au.com.codenhall_20_src/app/build/outputs/apk/release/app-release-unsigned.apk
```

## Copy the APK to your phone

If everything went well, there should be a signed Android APK file in:
```
au.com.codenhall_20_src/app/build/outputs/apk/release/au.com.codenhall.sokoban_20.apk
```

Copy the file to your Android phone and install with your phone's package installer.
