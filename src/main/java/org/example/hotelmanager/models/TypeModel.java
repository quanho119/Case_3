package org.example.hotelmanager.models;

import org.example.hotelmanager.databases.DatabaseConnect;
import org.example.hotelmanager.entity.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeModel {
    private final Connection conn;

    public TypeModel() {
        this.conn = DatabaseConnect.getConnection();
    }

    public ResultSet getTypes() throws SQLException {
        String sql = "SELECT * FROM room_type";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    public void create(Type type) throws SQLException {
        String sql = "INSERT INTO room_type(name) VALUES (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, type.getName());
        preparedStatement.executeUpdate();
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM room_type WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }

    public ResultSet getById(int id) throws SQLException {
        String sql = "SELECT * FROM room_type WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public void update(Type type) throws SQLException {
        String sql = "UPDATE room_type SET name =? WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, type.getName());
        ps.setInt(2, type.getId());
        ps.executeUpdate();

    }
}
