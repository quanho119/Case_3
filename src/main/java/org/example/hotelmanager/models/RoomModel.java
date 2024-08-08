package org.example.hotelmanager.models;

import org.example.hotelmanager.databases.DatabaseConnect;
import org.example.hotelmanager.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomModel {
    private final Connection conn;

    public RoomModel() {
        this.conn = DatabaseConnect.getConnection();
    }

    public ResultSet getRooms() throws SQLException {
        String sql = "SELECT rooms.id, rooms.room_number, rooms.floor_number, room_type_id, room_type.name AS room_type, rooms.price, room_status_id , room_status.name AS room_status FROM rooms JOIN room_type ON rooms.room_type_id = room_type.id JOIN room_status ON rooms.room_status_id = room_status.id ORDER BY rooms.room_number";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    public void deleteRoom(int id) throws SQLException {
        String sql = "DELETE FROM rooms WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public void createRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms(id, room_number, floor_number, room_type_id, room_status_id, price) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, room.getId());
        ps.setString(2, room.getRoom_number());
        ps.setInt(3, room.getFloor_number());
        ps.setInt(4, room.getRoom_type_id());
        ps.setInt(5, room.getRoom_status_id());
        ps.setFloat(6, room.getPrice());
        ps.executeUpdate();
    }

    public ResultSet search(String keyword) throws SQLException {
        String sql = "SELECT rooms.id, rooms.room_number, rooms.floor_number, room_type_id, room_type.name AS room_type, rooms.price, room_status_id , room_status.name AS room_status FROM rooms JOIN room_type ON rooms.room_type_id = room_type.id JOIN room_status ON rooms.room_status_id = room_status.id WHERE room_number LIKE ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        return ps.executeQuery();
    }

    public ResultSet getRoomById(int id) throws SQLException {
        String sql = "SELECT rooms.id, rooms.room_number, rooms.floor_number, room_type_id, room_type.name AS room_type, rooms.price, room_status_id , room_status.name AS room_status FROM rooms JOIN room_type ON rooms.room_type_id = room_type.id JOIN room_status ON rooms.room_status_id = room_status.id WHERE rooms.id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE rooms SET room_number =?, floor_number =?, room_type_id =?, room_status_id =?, price =? WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, room.getRoom_number());
        ps.setInt(2, room.getFloor_number());
        ps.setInt(3, room.getRoom_type_id());
        ps.setInt(4, room.getRoom_status_id());
        ps.setFloat(5, room.getPrice());
        ps.setInt(6, room.getId());
        ps.executeUpdate();
    }

    public void checkIn(int id) throws SQLException {
        String sql = "UPDATE rooms SET room_status_id =? WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    public void checkOut(int id) throws SQLException {
        String sql = "UPDATE rooms SET room_status_id = ? WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    public ResultSet getRoomByFloor(int floorInt) throws SQLException {
        String sql = "SELECT rooms.id, rooms.room_number, rooms.floor_number, room_type_id, room_type.name AS room_type, rooms.price, room_status_id , room_status.name AS room_status FROM rooms JOIN room_type ON rooms.room_type_id = room_type.id JOIN room_status ON rooms.room_status_id = room_status.id  where floor_number = ? ORDER BY rooms.room_number";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, floorInt);
        return ps.executeQuery();

    }

    public ResultSet getMaxFloors() throws SQLException {
        String sql = "SELECT MAX(floor_number) as max_floor FROM rooms";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }
}
