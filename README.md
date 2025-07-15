# ✈️ Sistema de Gestión de Reservas de Vuelos - Final Progamaciónm II

Este proyecto consiste en el desarrollo de una aplicación Java para gestionar reservas de vuelos. El sistema debe aplicar principios de **Programación Orientada a Objetos (POO)**, utilizar **colecciones para almacenamiento de datos** y generar archivos **CSV** con información del sistema.

---

## 📌 Requerimientos Funcionales

### 👤 Gestión de Pasajeros
Ruta sugerida: `/src/main/java/com/flight/service/PasajeroService.java`
- Registrar pasajeros (validar que no haya duplicados).
- Buscar pasajeros por DNI.

### ✈️ Gestión de Vuelos
Ruta sugerida: `/src/main/java/com/flight/service/VueloService.java`
- Registrar vuelos con validación de datos.
- Validar duplicados al registrar vuelos.

### 🧾 Gestión de Reservas
Ruta sugerida: `/src/main/java/com/flight/service/ReservaService.java`
- Crear una reserva para un pasajero en un vuelo (validar capacidad disponible).
- Cancelar reservas usando el código de reserva.
- Al cancelar, liberar el espacio correspondiente en el vuelo.

### 🧮 Estadísticas del Sistema
Ruta sugerida: `/src/main/java/com/flight/service/EstadisticasService.java`
- Obtener el número total de reservas.
- Mostrar los vuelos con mayor cantidad de reservas.

### 📤 Generación de CSV
Ruta sugerida: `/src/main/java/com/flight/util/CsvGenerator.java`
- Generar un archivo CSV con la lista de reservas existentes.
- Incluir datos de pasajeros y vuelos.
- **Formato del CSV:**

