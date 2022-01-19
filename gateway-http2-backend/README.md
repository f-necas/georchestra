# HTTP/2 demo application

Simple HTTP/2 application inspired on the (this guide)[https://byte27.com/2020/02/03/using-http-2-in-your-spring-boot-application/].

To be accessed through the gateway to demo its support for websockets.

## Build

```
mvn spring-boot:build-image
```

creates the `groldan/georchestra-http2-demo:latest` docker image.

## Run

Locally:

```
mvn spring-boot:run
```

Verify the connection is HTTP/2:

```
curl -k -sI https://127.0.0.1:8443
```

> Use the curl command to connect to our test endpoint (-k option, lets curl trust self-signed certificates).

The output of this should show that HTTP/2 is now successfully enabled.

```
curl -k -sI https://127.0.0.1:8443
HTTP/2 200 
content-type: text/plain;charset=UTF-8
content-length: 12
date: Wed, 19 Jan 2022 03:54:00 GMT
```
