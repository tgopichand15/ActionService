package com.example.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UnresolvedIssue {

    @Id
    @Column(name="issue_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="issuename")
    private String issuename;

    @Column(name="Hostname")
    private String Hostname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssuename() {
        return issuename;
    }

    public void setIssuename(String issuename) {
        this.issuename = issuename;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    @Override
    public String toString() {
        return "UnresolvedIssue{" +
                "id=" + id +
                ", issuename='" + issuename + '\'' +
                ", Hostname='" + Hostname + '\'' +
                '}';
    }
}

