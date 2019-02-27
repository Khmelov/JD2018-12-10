package by.it.skosirskiy.jd03_02.beans;

import java.sql.Timestamp;


public class Request {
    private long id;
    private String type;
    private Timestamp date_create;
    private Timestamp date_complete;
    private int user_id;
    private int status_id;
    private int address_id;
    public Request() {
    }

    public Request(long id, String type, Timestamp date_create, Timestamp date_complete, int user_id, int status_id, int address_id) {
        this.id = id;
        this.type = type;
        this.date_create = date_create;
        this.date_complete = date_complete;
        this.user_id = user_id;
        this.status_id = status_id;
        this.address_id = address_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }

    public void setDate_complete(Timestamp date_complete) {
        this.date_complete = date_complete;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public Timestamp getDate_complete() {
        return date_complete;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date_create=" + date_create +
                ", date_complete=" + date_complete +
                ", user_id=" + user_id +
                ", status_id=" + status_id +
                ", address_id=" + address_id +
                '}';
    }
}
