package com.example.ActionService;

import com.example.client.FetchDataClient;
import org.springframework.beans.factory.annotation.Autowired;

public class FetchTicketDetails {

    @Autowired
    FetchDataClient fetchdataclienttest;


    public static boolean fetchIssueIsAbouttoBreach(String Ticket) {
        //write code to call powershell script to ticket details

        try {

            Process p = new ProcessBuilder()
                    .inheritIO()
                    .command("invoke-command", "-computername", "Server1",
                            "-filepath", "C:\\scripts\\script.ps1").start();
            p.waitFor();
            int time=p.exitValue();
            //to check if breach time is lless than 30
            if (time <= 30) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


return false;
    }
    }





