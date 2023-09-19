package com.manumiguezz.springboot.EventsCRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_name")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "company_name")
    private String eventCompany;

    @Column(name = "tickets_sold")
    private int ticketSold;

    public Event(int id, String eventName, String eventCompany, int ticketSold) {
        this.id = id;
        this.eventName = eventName;
        this.eventCompany = eventCompany;
        this.ticketSold = ticketSold;
    }

    public Event(String eventName, String eventCompany, int ticketSold) {
        this.eventName = eventName;
        this.eventCompany = eventCompany;
        this.ticketSold = ticketSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCompany() {
        return eventCompany;
    }

    public void setEventCompany(String eventCompany) {
        this.eventCompany = eventCompany;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }
}
