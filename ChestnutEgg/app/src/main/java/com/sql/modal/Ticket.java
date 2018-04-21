package com.sql.modal;

import org.litepal.crud.DataSupport;

/**
 * Created by dan on 2018/3/25.
 */
public class Ticket extends DataSupport{

    private String order_number;
    private String train_number;
    private String departure_date;
    private String departure_time;
    private String departure_place;
    private String destination_time;
    private String destination_place;
    private String seat_number;
    private int isshow;

    public Ticket(String order_number, String train_number, String departure_date, String departure_time, String departure_place, String destination_time, String destination_place, String seat_number,int isshow) {
        this.order_number = order_number;
        this.train_number = train_number;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.departure_place = departure_place;
        this.destination_time = destination_time;
        this.destination_place = destination_place;
        this.seat_number = seat_number;
        this.isshow = isshow;
    }

    public int getIsshow() {
        return isshow;
    }

    public void setIsshow(int isshow) {
        this.isshow = isshow;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public String getDestination_time() {
        return destination_time;
    }

    public void setDestination_time(String destination_time) {
        this.destination_time = destination_time;
    }

    public String getDestination_place() {
        return destination_place;
    }

    public void setDestination_place(String destination_place) {
        this.destination_place = destination_place;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }






}
