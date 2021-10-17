package com.example.ActionService;

import com.example.client.SaveDataClient;
import com.example.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class CreateIncident {

    //write code to call create incident powershell scrtipt


    @Autowired
    public SaveDataClient savedataclienttest;

    public static ArrayList<String> executeScript(String hostname,String issuename) {
        try {

            Process p = new ProcessBuilder()
                    .inheritIO()
                    .command("invoke-command", "-computername", "Server1",
                            "-filepath", "C:\\scripts\\script.ps1").start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    void inserRecordstoDB(Ticket t) {



        //once ticket is created via APi push it to DB pass ticket object to this method


        savedataclienttest.addTickettoDb(t);
    }


}
