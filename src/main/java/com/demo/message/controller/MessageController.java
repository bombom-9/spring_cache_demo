package com.demo.message.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.message.service.MessageService;
import com.demo.message.vo.Message;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MessageController {

	private final MessageService messageService;

	@GetMapping("/messages/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable String id) {
		
		Message result = messageService.getMessage(id);

		return new ResponseEntity<Message>(result, HttpStatusCode.valueOf(200));
		
	}

	@GetMapping("/messages/{id}/new")
	public ResponseEntity<Message> getNewMessage(@PathVariable String id) {
		
		Message result = messageService.getNewMessage(id);

		return new ResponseEntity<Message>(result, HttpStatusCode.valueOf(200));
		
	}
	
	@DeleteMapping("/messages/{id}")
	public ResponseEntity<?> getNumber(@PathVariable String id) {
		
		messageService.deleteMessage(id);

		return ResponseEntity.ok("deleted.");
		
	}
	
}
