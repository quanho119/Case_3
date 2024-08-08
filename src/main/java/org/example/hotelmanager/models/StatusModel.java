package org.example.hotelmanager.models;

import org.example.hotelmanager.databases.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusModel {
    private Connection conn;
    public StatusModel(){
        this.conn = DatabaseConnect.getConnection();
    }
    public ResultSet getStatus() throws SQLException {
        String sql="SELECT * FROM room_status";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        return ps.executeQuery();
    }

}
