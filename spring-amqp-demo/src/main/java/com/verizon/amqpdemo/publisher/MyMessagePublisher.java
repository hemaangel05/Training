package com.verizon.amqpdemo.publisher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMessagePublisher {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

		AmqpTemplate template = ctx.getBean(RabbitTemplate.class);

		while (true) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String message = dateFormat.format(date);
			System.out.println("Sending DateTime#");
			template.convertAndSend(message);
			System.out.println("sent!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
