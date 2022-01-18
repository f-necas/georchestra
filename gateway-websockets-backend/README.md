# Websockets demo application

Simple application inspired on the (messaging-stomp-websocket)[https://github.com/spring-guides/gs-messaging-stomp-websocket]
project from the spring-guides demos.

To be accessed through the gateway to demo its support for websockets.

## Build

```
mvn spring-boot:build-image
```

creates the `groldan/georchestra-websockets-demo:latest` docker image.

## Run

Locally:

```
mvn spring-boot:run
```

Now that the service is running, point your browser at http://localhost:8080 and click the Connect button.

Upon opening a connection, you are asked for your name. Enter your name and click Send.
Your name is sent to the server as a JSON message over STOMP. After a one-second simulated
delay, the server sends a message back with a “Hello” greeting that is displayed on the page.
At this point, you can send another name or you can click the Disconnect button to close the connection.