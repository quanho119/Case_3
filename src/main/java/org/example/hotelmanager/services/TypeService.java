package org.example.hotelmanager.services;

import org.example.hotelmanager.entity.Type;
import org.example.hotelmanager.models.TypeModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeService {
    private final TypeModel typeModel;

    public TypeService() {
        typeModel = new TypeModel();
    }

    public List<Type> getAllTypes() throws SQLException {
        List<Type> types = new ArrayList<>();
        ResultSet rs = typeModel.getTypes();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Type type = new Type(name);
            type.setId(id);
            types.add(type);
        }
        return types;
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String name = req.getParameter("name");
        Type type = new Type(name);
        typeModel.create(type);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String id= req.getParameter("id");
        typeModel.delete(id);
    }

    public Type getTypeById(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        ResultSet resultSet = typeModel.getById(id);
        Type type = null;
        while(resultSet.next()) {
            int idType = resultSet.getInt("id");
            String name = resultSet.getString("name");
            type = new Type(name);
            type.setId(idType);
        }
        return type;
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Type type = new Type(name);
        type.setId(id);
        typeModel.update(type);
    }
}
