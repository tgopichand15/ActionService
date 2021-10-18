package com.example.ActionService;

import com.example.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CreateIncident {

    //write code to call create incident powershell scrtipt


    SaveDataClient savedataclient;


    @Autowired
    public CreateIncident(SaveDataClient s){
        this.savedataclient=s;
    }

    public CreateIncident(){

    }

    public SaveDataClient getSavedataclient() {
        return savedataclient;
    }

    public void setSavedataclient(SaveDataClient savedataclienttest) {
        this.savedataclient = savedataclient;
    }

    public static ArrayList<String> executeScript(String hostname, String issuename) {
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


        savedataclient.addTickettoDb(t);
    }


}
