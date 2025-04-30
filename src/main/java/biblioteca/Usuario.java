package biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private List<Prestamo> historialPrestamos;

    public Usuario(String nombre, List<Prestamo> historialPrestamos) {
        this.nombre = nombre;
        this.historialPrestamos = (historialPrestamos == null) ? new ArrayList<>() : historialPrestamos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            throw new NullPointerException("No se puede agregar un préstamo nulo.");
        }
        historialPrestamos.add(prestamo);
    }
}
