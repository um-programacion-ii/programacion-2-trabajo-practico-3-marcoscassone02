package biblioteca;

import java.util.Date;

public class Prestamo {
    private Date fechaPrestamo;
    private Libro libro;

    public Prestamo(Libro libro) {
        this.fechaPrestamo = new Date();  // Asigna la fecha actual al préstamo
        this.libro = libro;
    }

    // Getters
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    // Setters
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "fechaPrestamo=" + fechaPrestamo +
                ", libro=" + libro +
                '}';
    }
}
