package org.example.hotelmanager.services;

import org.example.hotelmanager.entity.Status;
import org.example.hotelmanager.models.StatusModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private final StatusModel statusModel;
    public StatusService() {
        this.statusModel = new StatusModel();
    }
    public List<Status> getAllStatuses() throws SQLException {
        List<Status> statuses = new ArrayList<>();
        ResultSet rs = statusModel.getStatus();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Status status = new Status(name);
            status.setId(id);
            statuses.add(status);
        }
        return statuses;
    }
}

