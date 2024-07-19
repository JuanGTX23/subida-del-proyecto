package com.lavadero.serverlet;

import com.lavadero.model.Reserva;
import com.lavadero.dao.ReservaDAO;
import com.lavadero.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/api/reserva")
public class AgregarReservaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String modelo = request.getParameter("modelo");
        String horarioEntrega = request.getParameter("horarioEntrega");
        String formaEntrega = request.getParameter("formaEntrega");

        // Aquí deberías obtener el ID de la persona y el vehículo de la base de datos o insertarlos
        int personaId = obtenerPersonaId(nombre); // Implementa este método según tu lógica.
        int vehiculoId = obtenerVehiculoId(modelo); // Implementa este método según tu lógica.

        Reserva reserva = new Reserva();
        reserva.setPersonaId(personaId);
        reserva.setVehiculoId(vehiculoId);
        reserva.setHorarioEntrega(horarioEntrega);
        reserva.setFormaEntrega(formaEntrega);

        try (Connection connection = DatabaseConnection.getConnection()) {
            ReservaDAO reservaDAO = new ReservaDAO(connection);
            reservaDAO.agregarReserva(reserva);
        } catch (SQLException e) {
            throw new ServletException("Error al guardar la reserva", e);
        }

        response.sendRedirect("reservas.html"); // Redirige a una página de confirmación si es necesario
    }

    // Método para obtener el ID de la persona basado en el nombre
    private int obtenerPersonaId(String nombre) {
        // Implementar lógica para obtener el ID de la persona por nombre.
        // Ejemplo: buscar en la base de datos y devolver el ID.
        // Retorna 1 como un valor de ejemplo. Deberías reemplazarlo con la lógica real.
        return 1; // Cambia esto por el ID real obtenido.
    }

    // Método para obtener el ID del vehículo basado en el modelo
    private int obtenerVehiculoId(String modelo) {
        // Implementar lógica para obtener el ID del vehículo por modelo.
        // Ejemplo: buscar en la base de datos y devolver el ID.
        // Retorna 1 como un valor de ejemplo. Deberías reemplazarlo con la lógica real.
        return 1; // Cambia esto por el ID real obtenido.
    }
}
