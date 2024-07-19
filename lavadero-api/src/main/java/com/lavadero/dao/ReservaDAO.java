package com.lavadero.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.lavadero.model.Reserva;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarReserva(Reserva reserva) throws SQLException {
        String query = "INSERT INTO reservas (persona_id, vehiculo_id, horario_entrega, forma_entrega) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reserva.getPersonaId());
            stmt.setInt(2, reserva.getVehiculoId());
            stmt.setString(3, reserva.getHorarioEntrega());
            stmt.setString(4, reserva.getFormaEntrega());
            stmt.executeUpdate();
        }
    }

    public List<Reserva> obtenerReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String query = "SELECT * FROM reservas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setPersonaId(rs.getInt("persona_id"));
                reserva.setVehiculoId(rs.getInt("vehiculo_id"));
                reserva.setHorarioEntrega(rs.getString("horario_entrega"));
                reserva.setFormaEntrega(rs.getString("forma_entrega"));
                reservas.add(reserva);
            }
        }
        return reservas;
    }
}

