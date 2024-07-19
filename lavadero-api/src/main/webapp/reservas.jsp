<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Reservas Registradas</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Reservas Registradas</h1>
    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Modelo del Vehículo</th>
                <th>Horario de Entrega</th>
                <th>Forma de Entrega</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="reserva" items="${reservas}">
                <tr>
                    <td>${reserva.persona.nombre}</td>
                    <td>${reserva.vehiculo.modelo}</td>
                    <td>${reserva.horarioEntrega}</td>
                    <td>${reserva.formaEntrega}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

