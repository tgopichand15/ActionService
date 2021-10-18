/*package com.example.ActionService;

import com.example.entities.Ticket;
import com.example.entities.UnresolvedIssue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Actioncontroller {

    public CreateIncident createincident;

    public FetchDataClient fetchdataclient;

    private FetchTicketDetails fetchticketdetails;

    private AlertUsersSLA alertuserssla;

    private MonitorSLA monitorsla;


    public Actioncontroller(CreateIncident createincident,FetchDataClient fetchdataclient,FetchTicketDetails fetchticketdetails,AlertUsersSLA alertuserssla,MonitorSLA monitorsla){
        this.createincident=createincident;
        this.fetchdataclient=fetchdataclient;
        this.fetchticketdetails=fetchticketdetails;
        this.alertuserssla=alertuserssla;
        this.monitorsla=monitorsla;
    }

    public CreateIncident getCreateincident() {
        return createincident;
    }

    public void setCreateincident(CreateIncident createincident) {
        this.createincident = createincident;
    }

    public FetchDataClient getFetchdataclient() {
        return fetchdataclient;
    }

    public void setFetchdataclient(FetchDataClient fetchdataclient) {
        this.fetchdataclient = fetchdataclient;
    }

    public FetchTicketDetails getFetchticketdetails() {
        return fetchticketdetails;
    }

    public void setFetchticketdetails(FetchTicketDetails fetchticketdetails) {
        this.fetchticketdetails = fetchticketdetails;
    }

    public AlertUsersSLA getAlertuserssla() {
        return alertuserssla;
    }

    public void setAlertuserssla(AlertUsersSLA alertuserssla) {
        this.alertuserssla = alertuserssla;
    }

    public MonitorSLA getMonitorsla() {
        return monitorsla;
    }

    public void setMonitorsla(MonitorSLA monitorsla) {
        this.monitorsla = monitorsla;
    }

    public Actioncontroller(){

    }

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
}*/
