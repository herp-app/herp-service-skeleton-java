package com.herp.service.skeletonjava;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest{
     @LocalServerPort
    	private int port;

     	@Autowired
     	private TestRestTemplate restTemplate;

    @Test
    public void installShouldReturnNodeDefinition() throws Exception {
	String baseUrl = "http://localhost:"+port+"/install";
	String nodeDefinition = "{\"name\":\"skeleton-java\",\"label\":\"Java Skeleton Service\",\"inputs\":[{\"fieldType\":\"string\",\"name\":\"inputField1\",\"label\":\"String input Field\"},{\"fieldType\":\"string\",\"name\":\"inputField1\",\"label\":\"String input Field\"}],\"outputs\":[{\"fieldType\":\"string\",\"name\":\"outputField\",\"label\":\"String output Field\"}]}";
	assertThat(this.restTemplate.getForObject(baseUrl, String.class)).contains("skeleton-java");
	assertThat(this.restTemplate.getForObject(baseUrl, String.class)).toString().equals(nodeDefinition);
    }

    @Test void doShouldReturnConcattenationn() throws Exception {
	String baseUrl = "http://localhost:"+port+"/do";

	MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

	String jsonBody = "{\"inputField1\":\"40.2\", \"inputField2\":\"test\"}";
	//MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
	//map.add("inputField1", "test");
	//map.add("inputField2", "40.2");

	HttpEntity<?> request = new HttpEntity<>(jsonBody, headers);

	ResponseEntity<String> response = restTemplate.postForEntity( baseUrl, request , String.class );
	assertThat(response.getBody().toString()).isEqualTo("{\"outputField\":\"40.2test\"}");
    }
    @Test
    void doShouldReturnConcattenation() throws Exception {
	String url = "http://localhost:"+port+"/do";


	// create headers
	HttpHeaders headers = new HttpHeaders();
	// set `content-type` header
	headers.setContentType(MediaType.APPLICATION_JSON);
	// set `accept` header
	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	// request body parameters
	Map<String, Object> map = new HashMap<>();
	map.put("inputField1", "test1");
	map.put("inputField2", "test2");
	// build the request
	HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

	// send POST request
	ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
	// check, if request was successful
	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	// check if request did return correct values
	assertThat(response.getBody()).isEqualTo("{\"outputField\":\"test1test2\"}");
    }

}
