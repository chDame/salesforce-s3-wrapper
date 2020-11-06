package com.cdame.services;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

public class SalesForceEncoderInterceptor implements ClientHttpRequestInterceptor {

	    @Override
	    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
	        return execution.execute(new HttpRequestWrapper(request) {
	            @Override
	            public URI getURI() {
	                URI u = super.getURI();
	                String strictlyEscapedQuery = /*StringUtils.replace(u.getRawQuery(), "%", "%25");
	                strictlyEscapedQuery =*/ StringUtils.replace(u.getRawQuery(), "+", "%2B");
	                return UriComponentsBuilder.fromUri(u)
	                        .replaceQuery(strictlyEscapedQuery)
	                        .build(true).toUri();
	            }
	        }, body);
	    }
	}
