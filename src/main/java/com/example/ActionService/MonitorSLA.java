package com.example.ActionService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

public class MonitorSLA {

    public void monitiorSLA() {

        @Autowired
        private FetchDataClientTest fetchdataclienttest;


        @Autowired
        private FetchTicketDetails fetchticketdetails;

        @Autowired
        private AlertUsersSLA alertuserssla;


        //fetching ticket numbers from DB code to be written for this method
        ArrayList<String> al = fetchdataclienttest.fetchticketDetails();


        //for each ticket checking if this is about to be breached method to be impletemented in fetchticketdetails class
        foreach(String ticket:al){
            boolean status = fetchticketdetails.fetchIssueIsAbouttoBreach(ticket);
            if (status) {
                alertuserssla.sendEmailAlert(al.get(1), message.get(0));
            }
        }

    }


    //fetch incidents numbers from Db and get theitr SLA and alert users


}
