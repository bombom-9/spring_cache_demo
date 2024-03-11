package com.demo.message.entity;

//import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//public class Message implements Serializable {
public class Message {
	
//	private static final long serialVersionUID = -1330881135547995156L;
	
	private String id;
	private Date date;

}
