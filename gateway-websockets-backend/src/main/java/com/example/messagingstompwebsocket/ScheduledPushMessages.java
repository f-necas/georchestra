package com.example.messagingstompwebsocket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.javafaker.ChuckNorris;

@Service
public class ScheduledPushMessages {

	private @Autowired ChuckNorris chuckNorris;
	private @Autowired SimpMessagingTemplate simpMessagingTemplate;
	
	@Scheduled(fixedRate = 5000)
	public void sendMessage() {
		Greeting messagePayload = newMessage();
		simpMessagingTemplate.convertAndSend("/topic/greetings", messagePayload);
	}

	private Greeting newMessage() {
		String time = DateTimeFormatter.ISO_TIME.format(LocalDateTime.now());
		String from = "Chuck Norris";
		String fact = chuckNorris.fact();
		String message = String.format("%s - %s says: %s", time, from, fact);
		return new Greeting(message);
	}
}
