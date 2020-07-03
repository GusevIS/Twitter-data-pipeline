package com.siepam.Twitterdatapipeline;

import com.siepam.Twitterdatapipeline.Collecting.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TwitterDataPipelineApplication {
	private static final Logger log = LoggerFactory.getLogger(TwitterDataPipelineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TwitterDataPipelineApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Request request = restTemplate.getForObject(
					"http://stream.meetup.com/2/rsvps", Request.class);
			log.info(request.toString());
		};
	}

}
