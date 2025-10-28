package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        return null;
    }

}
