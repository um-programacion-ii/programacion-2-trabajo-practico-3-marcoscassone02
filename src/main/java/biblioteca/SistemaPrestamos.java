package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class SistemaPrestamos {
    private List<Prestamo> prestamos;

    public SistemaPrestamos() {
        this.prestamos = new ArrayList<>();
    }

    // Método para agregar un préstamo
    public void agregarPrestamo(Libro libro) {
        Prestamo nuevoPrestamo = new Prestamo(libro);
        prestamos.add(nuevoPrestamo);
        libro.setEstado(EstadoLibro.PRESTADO);  // Cambiar el estado del libro a prestado
    }

    // Método para obtener todos los préstamos
    public List<Prestamo> obtenerPrestamos() {
        return prestamos;
    }

    // Método para obtener los préstamos de un libro específico
    public List<Prestamo> obtenerPrestamosPorLibro(Libro libro) {
        List<Prestamo> prestamosLibro = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro)) {
                prestamosLibro.add(prestamo);
            }
        }
        return prestamosLibro;
    }

    @Override
    public String toString() {
        return "SistemaPrestamos{" +
                "prestamos=" + prestamos +
                '}';
    }
}
