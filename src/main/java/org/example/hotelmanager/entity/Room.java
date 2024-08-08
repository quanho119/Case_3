package org.example.hotelmanager.entity;

public class Room {
    private int id;
    private String room_number;
    private int floor_number;
    private int room_status_id;
    private String room_status;
    private int room_type_id;
    private String room_type;
    private float price;
    public Room(String room_number, int floor_number, int room_status_id, int room_type_id, float price) {
        this.room_number = room_number;
        this.floor_number = floor_number;
        this.room_status_id = room_status_id;
        this.room_type_id = room_type_id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public int getRoom_status_id() {
        return room_status_id;
    }

    public void setRoom_status_id(int room_status) {
        this.room_status_id = room_status;
    }

    public int getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(int room_type_id) {
        this.room_type_id = room_type_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
