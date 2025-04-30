import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private List<Libro> libros;

    public Catalogo() {
        this.libros = new ArrayList<>();
    }

    // Método para agregar un libro al catálogo
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Método para buscar un libro por ISBN
    public Libro buscarPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null; // No se encontró
    }

    // Método para obtener todos los libros DISPONIBLES
    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }
}
