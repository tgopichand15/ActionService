package com.example.ActionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actioncontroller {


    @Controller
    @RequestMapping("/Action_service")
    public List<UnresolvedIssues> createTickets(){

        //process data from DB and finally create final entries for hashmap values hostname and issues name

        @Autowired
        private CreateIncident createincident;

        @Autowired
        private FetchDataClientTest fetchdataclienttest;

        ArrayList<UnresolvedIssues> a=fetchdataclienttest.getunresolveduissues();


        //list of unresoved issues
        ArrayList<UnresolvedIssues> unresolveditems=new ArrayList<UnresolvedIssues>();

        foreach(UnresolvedIssues i:a){
            ArrayList<String> ticket=createIncident.executeScript(i.hostname,i.path);
            if(ticket != null){
                createIncident.inserRecordstoDB();
            }
            else{
                unresolveditems.add(i);
            }
        }

        @Autowired
        private MonitorSLA monitorsla;

        monitorsla.monitorSLA();

        @Autowired
        private FetchDataClientTest fetchdataclienttest;

        @Autowired
        private FetchTicketDetails fetchticketdetails;

        @Autowired
        private AlertUsersSLA alertuserssla;


        ArrayList<String> tickets=fetchdataclienttest.fetchticketDetails();

        foreach(String s:tickets){
            boolean status=fetchticketdetauls.fetchIssueIsAbouttoBreach(s);

            if(status==true){
               Tickets t=fetchdataclienttest.fetchticketdetails(s);

               alertuserssla.sendEmailAlert(t.getAssignedToTeam(),s);

            }
        }
        return unresolveditems;
    }
}
