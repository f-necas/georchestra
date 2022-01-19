package com.example.messagingstompwebsocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class OutputMessage {
	private String from;
	private String text;
	private String time;
}
