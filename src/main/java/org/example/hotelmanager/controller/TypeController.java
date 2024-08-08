package org.example.hotelmanager.controller;

import org.example.hotelmanager.entity.Type;
import org.example.hotelmanager.services.RoomService;
import org.example.hotelmanager.services.StatusService;
import org.example.hotelmanager.services.TypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "TypeController", value = "/types/*")
public class TypeController extends HttpServlet {
    private TypeService typeService;

    @Override
    public void init() throws ServletException {
        typeService = new TypeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        try {
            if (url == null || url.equals("/")) {
                this.renderTypeList(req, resp);
            }
            switch (Objects.requireNonNull(url)) {
                case "/create":
                    this.renderCreateType(req, resp);
                    break;
                case "/delete":
                    this.deleteType(req, resp);
                    break;
                case "/update":
                    this.renderUpdateType(req, resp);
                    break;
                default:
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        try {
            switch (Objects.requireNonNull(url)) {
                case "/create":
                    this.createType(req, resp);
                    break;
                case "/update":
                    this.updateType(req, resp);
                    break;
                default:
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateType(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.typeService.update(req, resp);
        resp.sendRedirect("/types/");
    }

    private void renderUpdateType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Type type = typeService.getTypeById(req, resp);
        req.setAttribute("type", type);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/types/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteType(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.typeService.delete(req, resp);
        resp.sendRedirect("/types/");
    }

    private void createType(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.typeService.create(req, resp);
        resp.sendRedirect("/types/");
    }

    private void renderCreateType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/types/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void renderTypeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Type> types = typeService.getAllTypes();
        req.setAttribute("types", types);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/types/list.jsp");
        requestDispatcher.forward(req, resp);
    }


}
