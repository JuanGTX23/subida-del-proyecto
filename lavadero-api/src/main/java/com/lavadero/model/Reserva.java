package com.lavadero.model;
public class Reserva {
    private int id;
    private int personaId;
    private int vehiculoId;
    private String horarioEntrega;
    private String formaEntrega;
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getFormaEntrega() {
        return formaEntrega;
    }

    public void setFormaEntrega(String formaEntrega) {
        this.formaEntrega = formaEntrega;
    }
}
