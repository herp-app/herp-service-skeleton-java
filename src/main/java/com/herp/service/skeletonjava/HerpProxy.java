package com.herp.service.skeletonjava;

import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Collections;
import java.lang.Exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class HerpProxy{
    String uri;

    HerpProxy(String uri){
	this.uri = uri;
    }

    public void register(Map<String, String> serviceInfo) throws Exception{
	String baseUrl = uri+"/services/register";
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


	RestTemplate restTemplate = new RestTemplate();
	HttpEntity<?> request = new HttpEntity<>(serviceInfo, headers);
	ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request, String.class);

	// If Server is not reachable, Exception is thrown by restTemplate.postForEntity(), anyways assert, that nothing strange did happen.
	assert(response != null);
	assert(response.getStatusCode() == HttpStatus.OK);
    }
}
