package com.example.ActionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionServiceApplication.class, args);

		@Autowired
		FetchDataClientTest fetchdata;

		List<Unresolvedisssues> l=fetchdata.getunresolvedIssues();

		@Autowired
		private CreateIncident createincident;

		foreach(Unresolvedissue u:l){
			createincident.executescript(l.getHostname(),l.getPath());
		}



	}

}
