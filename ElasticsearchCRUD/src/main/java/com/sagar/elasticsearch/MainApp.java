package com.sagar.elasticsearch;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

	public static void main(String[] args) throws Exception {
		// Create a Camel context
		CamelContext context = new DefaultCamelContext();

		// Add the Camel route
		context.addRoutes(new MyCamelRoute());

		// Start the Camel context
		context.start();

		// Create a ProducerTemplate to send messages
		ProducerTemplate producerTemplate = context.createProducerTemplate();

		// Replace 'yourJsonData' with the actual JSON data you want to send
		String yourJsonData = "{ \"employee_name\": \"Employee\", \"employee_number\": \"ID123\"}";

		// Send the JSON data to the Camel route
		producerTemplate.sendBody("direct:submitForm", yourJsonData);

		// Sleep for a while to allow Camel to process the message
		Thread.sleep(5000);

		// Stop the Camel context
		context.stop();
	}
}
