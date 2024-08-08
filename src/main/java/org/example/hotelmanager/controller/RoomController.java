package org.example.hotelmanager.controller;

import org.example.hotelmanager.entity.Room;
import org.example.hotelmanager.entity.Status;
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

@WebServlet(name = "RoomController", value = "/rooms/*")
public class RoomController extends HttpServlet {
    private RoomService roomService;
    private TypeService typeService;
    private StatusService statusService;

    @Override
    public void init() throws ServletException {
        roomService = new RoomService();
        typeService = new TypeService();
        statusService = new StatusService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        try {
            if (url == null || url.equals("/")) {
                this.renderRoomList(req, resp);
            }
            switch (Objects.requireNonNull(url)) {
                case "/create":
                    this.renderRoomCreate(req, resp);
                    break;
                case "/update":
                    this.renderRoomUpdate(req, resp);
                    break;
                case "/delete":
                    this.deleteRoom(req, resp);
                    break;
                case "/search":
                    this.searchRoom(req, resp);
                    break;
                case "/checkin":
                    this.checkInRoom(req, resp);
                    break;
                case "/checkout":
                    this.checkOutRoom(req, resp);
                    break;
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
                    this.createRoom(req, resp);
                    break;
                case "/update":
                    this.updateRoom(req, resp);
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void checkOutRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.roomService.checkOutRoom(req, resp);
        resp.sendRedirect("/rooms/");
    }


    private void checkInRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.roomService.checkInRoom(req, resp);
        resp.sendRedirect("/rooms/");
    }


    private void updateRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.roomService.updateRoom(req, resp);
        resp.sendRedirect("/rooms/");
    }

    private void searchRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Room> rooms = this.roomService.getRoomByRoomNumber(req);
        int floor = roomService.getCountFloor();
        req.setAttribute("rooms", rooms);
        req.setAttribute("floor", floor);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/rooms/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void renderRoomUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        Room room = this.roomService.getRoomById(req, resp);
        List<Type> types = this.typeService.getAllTypes();
        List<Status> statuses = this.statusService.getAllStatuses();
        req.setAttribute("room", room);
        req.setAttribute("types", types);
        req.setAttribute("statuses", statuses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/rooms/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void createRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        this.roomService.createRoom(req, resp);
        resp.sendRedirect("/rooms/");
    }

    private void renderRoomList(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Room> rooms = this.roomService.getAllRooms(req);
        int floor = roomService.getCountFloor();
        req.setAttribute("rooms", rooms);
        req.setAttribute("floor", floor);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/rooms/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void renderRoomCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Type> types = this.typeService.getAllTypes();
        req.setAttribute("types", types);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/rooms/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        this.roomService.deleteRoom(req, resp);
        resp.sendRedirect("/rooms/");
    }

}
