package kr.co.ex.biz.process;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestTemplateUtil {
	private static final Logger log = LoggerFactory.getLogger(RestTemplateUtil.class);
	
	@Autowired
    private RestTemplate restTemplate;
    
    public ResponseEntity<String> excuteGetExchange(String url, HashMap<String, String> map, HttpHeaders header){
    	log.info("getExchange running...");
    	ResponseEntity<String> resultSet = null;
    	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    	for(Map.Entry<String, String> entry : map.entrySet()) {
    		builder.queryParam(entry.getKey(), entry.getValue());
    	}
    	
    	HttpEntity<HttpHeaders> request = new HttpEntity<HttpHeaders>(header);
    	resultSet = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, String.class);
    	
    	log.debug("getResultSet: " + resultSet.getBody());
    	return resultSet;
    }
    
    public ResponseEntity<String> excutePostExchange(String url, MultiValueMap<String, String> map, HttpHeaders header){
    	log.info("postExchange running...");
    	ResponseEntity<String> resultSet = null;
    	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, header);
    	resultSet = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    	
    	log.debug("postResultSet: " + resultSet.getBody());
    	return resultSet;
    }
}