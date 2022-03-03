package kr.co.ex.biz.process;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	/**
	 * 이 프로젝트는 RestTemplate를 사용한 http통신을 하는데, 이 경우 모든 통신을 TCP/IP로 진행하게 되어 많은 프로세스가 Time_Wait 상태에 들어갑니다. 
	 * 해당 현상을 해결하기 위해 apache http client 의존성을 활용하여 http 통신의 스레드풀을 확장시키는 설정을 추가했습니다.
	 */
    @Bean
    public RestTemplate getCustomRestTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(2000);
        httpRequestFactory.setReadTimeout(3000);
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(200)
                .setMaxConnPerRoute(20)
                .build();
        httpRequestFactory.setHttpClient(httpClient);
        return new RestTemplate(httpRequestFactory);
    }

}