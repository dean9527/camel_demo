package com.dean.it;

import org.apache.camel.CamelContext;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileMoveAndProcessWithCamel {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				Processor processor = new FileEventProcessor();
				from("file:D:\\program\\dev\\camel_move\\input?delay=30000")
				.process(processor).to("file:D:\\program\\dev\\camel_move\\output");
			}
		});
		context.start();
		boolean loop = true;
		while(loop) {
			Thread.sleep(25000);
		}
		context.stop();
	}
}
