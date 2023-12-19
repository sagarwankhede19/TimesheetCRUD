package com.sagar.elasticsearch;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.elasticsearch.ElasticsearchConstants;

public class MyCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:submitForm")
            // Set the Elasticsearch index and operation
            .setHeader(ElasticsearchConstants.PARAM_INDEX_NAME, constant("times"))
            .setHeader(ElasticsearchConstants.PARAM_OPERATION, constant("INDEX"))

            // Convert the JSON data to a Map for Elasticsearch
            .unmarshal().json()
            
            // Send the data to Elasticsearch
            .to("elasticsearch-rest://elasticsearch");

        // You can add more routes or configurations as needed
    }
}
