package org.example.hotelmanager.services;

import org.example.hotelmanager.entity.Room;
import org.example.hotelmanager.models.RoomModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private final RoomModel roomModel;

    public RoomService() {
        roomModel = new RoomModel();
    }

    public List<Room> getAllRooms(HttpServletRequest req) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String floor = req.getParameter("floor");
        ResultSet resultSet = null;

        if (floor == null) {
            resultSet = this.roomModel.getRooms();
        } else {
            int floorInt= Integer.parseInt(floor);
            resultSet = this.roomModel.getRoomByFloor(floorInt);
        }
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String room_number = resultSet.getString("room_number");
            int floor_number = resultSet.getInt("floor_number");
            int room_status_id = resultSet.getInt("room_status_id");
            String room_status = resultSet.getString("room_status");
            int room_type_id = resultSet.getInt("room_type_id");
            String room_type = resultSet.getString("room_type");
            float price = resultSet.getFloat("price");
            Room room = new Room(room_number, floor_number, room_status_id, room_type_id, price);
            room.setId(id);
            room.setRoom_status(room_status);
            room.setRoom_type(room_type);
            rooms.add(room);
        }
        return rooms;
    }

    public int getCountFloor() throws SQLException {
        ResultSet resultSet = this.roomModel.getMaxFloors();
        while(resultSet.next()){
            return resultSet.getInt("max_floor");
        }
        return 0;
    }

    public void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.roomModel.deleteRoom(id);
    }

    public void createRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String room_number = req.getParameter("room_number");
        int floor_number = Integer.parseInt(req.getParameter("floor_number"));
        int room_status_id = 1;
        int room_type_id = Integer.parseInt(req.getParameter("room_type_id"));
        float price = Float.parseFloat(req.getParameter("price"));

        Room room = new Room(room_number, floor_number, room_status_id, room_type_id, price);
        this.roomModel.createRoom(room);
    }

    public List<Room> getRoomByRoomNumber(HttpServletRequest req) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String keyword = req.getParameter("keyword");
        if (keyword == null || keyword.isEmpty()) {
            return rooms;
        }
        ResultSet resultSet = this.roomModel.search(keyword);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String room_number = resultSet.getString("room_number");
            int floor_number = resultSet.getInt("floor_number");
            int room_status_id = resultSet.getInt("room_status_id");
            String room_status = resultSet.getString("room_status");
            int room_type_id = resultSet.getInt("room_type_id");
            String room_type = resultSet.getString("room_type");
            float price = resultSet.getFloat("price");
            Room room = new Room(room_number, floor_number, room_status_id, room_type_id, price);
            room.setId(id);
            room.setRoom_status(room_status);
            room.setRoom_type(room_type);
            rooms.add(room);
        }
        return rooms;
    }

    public Room getRoomById(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        ResultSet resultSet = this.roomModel.getRoomById(id);
        Room room = null;
        while (resultSet.next()) {
            String room_number = resultSet.getString("room_number");
            int floor_number = resultSet.getInt("floor_number");
            int room_status_id = resultSet.getInt("room_status_id");
            String room_status = resultSet.getString("room_status");
            int room_type_id = resultSet.getInt("room_type_id");
            String room_type = resultSet.getString("room_type");
            int price = resultSet.getInt("price");
            room = new Room(room_number, floor_number, room_status_id, room_type_id, price);
            room.setId(id);
            room.setRoom_status(room_status);
            room.setRoom_type(room_type);
        }
        return room;
    }

    public void updateRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String room_number = req.getParameter("room_number");
        int floor_number = Integer.parseInt(req.getParameter("floor_number"));
        int room_status_id = Integer.parseInt(req.getParameter("room_status_id"));
        int room_type_id = Integer.parseInt(req.getParameter("room_type_id"));
        float price = Float.parseFloat(req.getParameter("price"));

        Room room = new Room(room_number, floor_number, room_status_id, room_type_id, price);
        room.setId(id);
        this.roomModel.updateRoom(room);
    }

    public void checkInRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.roomModel.checkIn(id);
    }

    public void checkOutRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.roomModel.checkOut(id);
    }
}
