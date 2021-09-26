package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name="Ticket")
public class Tickets {

    @Id
    @Column(name="ticket_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(name="assignedtoteam")
    String assignedToTeam;

    @Column(name="Ticketnumber")
    String Ticketnumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignedToTeam() {
        return assignedToTeam;
    }

    public void setAssignedToTeam(String assignedToTeam) {
        this.assignedToTeam = assignedToTeam;
    }

    public String getTicketnumber() {
        return Ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        Ticketnumber = ticketnumber;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", assignedToTeam='" + assignedToTeam + '\'' +
                ", Ticketnumber='" + Ticketnumber + '\'' +
                '}';
    }
}
