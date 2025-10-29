package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        logger.info("BASE URI: " + filterableRequestSpecification.getBaseUri());
        logger.info("Request Header: " + filterableRequestSpecification.getHeaders());
        logger.info("Request PayLoad: " + filterableRequestSpecification.getBody());
    }

    public void logResponse( Response response){
        logger.info("STATUS CODE: " + response.getStatusCode());
        logger.info("Response Header: " + response.headers());
        logger.info("Request Body: " + response.getBody().prettyPrint());
    }
}
