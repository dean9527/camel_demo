package com.dean.it;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileEventProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		InputStream body = exchange.getIn().getBody(InputStream.class);
		BufferedReader bufferReader = new BufferedReader(
				new InputStreamReader(body));
		StringBuffer strbf = new StringBuffer("");
		String str = null;
		str = bufferReader.readLine();
		while(str!=null) {
			System.out.println(str);
			strbf.append(str + " ");
			str = bufferReader.readLine();
		}
		exchange.getOut().setHeader(exchange.FILE_NAME, "converted.txt");
		exchange.getOut().setBody(strbf.toString());
	}

}
