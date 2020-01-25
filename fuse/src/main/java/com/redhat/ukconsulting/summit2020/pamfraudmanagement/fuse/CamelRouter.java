package com.redhat.ukconsulting.summit2020.pamfraudmanagement.fuse;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("direct:checkTransactions").id("checkTransactions")
            .log("todo - read from kafka")
            .to("direct:checkRules")
            .to("direct:riskRating");

        from("direct:checkRules").id("checkRules")
            .log("Sending block alert for '${body}'...")
            .marshal().json(JsonLibrary.Jackson)
            .log("QUESTIONS; whats the Decision Service API? Do we have a Swagger spec?")
            .to("direct:todo");

        from("direct:riskRating").id("riskRating")
            .choice()
                .when().simple("${body.isHigh()}")
                .to("direct:sendBlockAlert")
            .otherwise()
                .to("direct:createCase")
            .end();

        from("direct:sendBlockAlert").id("sendBlockAlert")
            .log("Sending block alert for '${body}'...")
            .marshal().json(JsonLibrary.Jackson)
            .to("kafka:block_account");

        from("direct:createCase").id("createCase")
            .log("Calling case management for '${body}'...")
            .marshal().json(JsonLibrary.Jackson)
            .log("QUESTIONS; whats the Case Management API? Do we have a Swagger spec?")
            .to("direct:todo");
        // @formatter:on
    }
}