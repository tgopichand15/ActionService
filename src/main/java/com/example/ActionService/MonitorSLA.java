package com.example.ActionService;

import com.example.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class MonitorSLA {

    @Autowired
    public FetchDataClient fetchdataclienttest;


    @Autowired
    public FetchTicketDetails fetchdetails;

    @Autowired
    public AlertUsersSLA alertuserssla;

    public void monitiorSLA() {



        //fetching ticket numbers from DB code to be written for this method
        List<String> al = fetchdataclienttest.fetchticketDetails();


        //for each ticket checking if this is about to be breached method to be impletemented in fetchticketdetails class
        for( String s:al){
            boolean status = fetchdetails.fetchIssueIsAbouttoBreach(s);
            Ticket t=fetchdataclienttest.fetchticketdetails(s);
            String emailid=t.getAssignedToTeam();
            if (status) {
                alertuserssla.sendEmailAlert(emailid,s);
            }
        }

    }


    //fetch incidents numbers from Db and get theitr SLA and alert users


}
