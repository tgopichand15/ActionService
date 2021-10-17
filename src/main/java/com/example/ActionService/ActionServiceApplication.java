package com.example.ActionService;

import com.example.client.FetchDataClient;
import com.example.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.entities.UnresolvedIssue;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class ActionServiceApplication {


	@Autowired
	static FetchDataClient fetchdata;


	@Autowired
	public static CreateIncident createincident;

	public static void main(String[] args) {
		SpringApplication.run(ActionServiceApplication.class, args);


		List<UnresolvedIssue> l=fetchdata.getunresolveduissues();


		for(UnresolvedIssue u:l){
			ArrayList<String> t=createincident.executeScript(u.getHostname(),u.getIssuename());
			Ticket n=new Ticket();
			n.setTicketnumber(t.get(0));
			n.setAssignedToTeam(t.get(1));
			createincident.inserRecordstoDB(n);
		}



	}

}
