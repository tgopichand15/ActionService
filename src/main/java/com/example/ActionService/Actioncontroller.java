package com.example.ActionService;

import com.example.client.FetchDataClient;
import com.example.entities.Ticket;
import com.example.entities.UnresolvedIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Actioncontroller {



    @Autowired
    public CreateIncident createincident;

    @Autowired
    public FetchDataClient fetchdataclienttest;


    @Autowired
    private FetchTicketDetails fetchticketdetails;

    @Autowired
    private AlertUsersSLA alertuserssla;

    @Autowired
    private MonitorSLA monitorsla;

    @RequestMapping("/Action_service")
    public List<UnresolvedIssue> createTickets(){

        //process data from DB and finally create final entries for hashmap values hostname and issues name


        List<UnresolvedIssue> a=fetchdataclienttest.getunresolveduissues();


        //list of unresoved issues
        ArrayList<UnresolvedIssue> unresolveditems=new ArrayList<UnresolvedIssue>();

        for(UnresolvedIssue i:a){
            ArrayList<String> ticket=createincident.executeScript(i.getHostname(),i.getIssuename());

            Ticket tick=new Ticket();
            tick.setTicketnumber(ticket.get(0));
            tick.setAssignedToTeam(ticket.get(0));
            if(ticket != null){
                createincident.inserRecordstoDB(tick);
            }
            else{
                unresolveditems.add(i);
            }
        }



        monitorsla.monitiorSLA();;


        List<String> tickets=fetchdataclienttest.fetchticketDetails();

        for(String s:tickets){
            boolean status=fetchticketdetails.fetchIssueIsAbouttoBreach(s);

            if(status==true){
               Ticket t=fetchdataclienttest.fetchticketdetails(s);

               alertuserssla.sendEmailAlert(t.getAssignedToTeam(),s);

            }
        }
        return unresolveditems;
    }
}
