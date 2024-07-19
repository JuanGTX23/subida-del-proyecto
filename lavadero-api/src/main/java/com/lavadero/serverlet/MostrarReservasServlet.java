package com.lavadero.serverlet;

import com.lavadero.model.Reserva;
import com.lavadero.dao.ReservaDAO;
import com.lavadero.util.DatabaseConnection;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/mostrarReservas")
public class MostrarReservasServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reserva> reservas;
        try (Connection connection = DatabaseConnection.getConnection()) {
            ReservaDAO reservaDAO = new ReservaDAO(connection);
            reservas = reservaDAO.obtenerReservas();
        } catch (SQLException e) {
            throw new ServletException("Error al obtener las reservas", e);
        }

        // Configurar la respuesta para que sea en formato JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Convertir la lista de reservas a JSON
        Gson gson = new Gson();
        String json = gson.toJson(reservas);

        // Enviar la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
