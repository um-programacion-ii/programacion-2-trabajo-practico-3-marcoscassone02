package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    @Test
    public void testCreacionLibroConDatosValidos() {
        // Arrange
        String isbn = "978-1234567890";
        String titulo = "El Principito";
        String autor = "Antoine de Saint-Exupéry";

        // Act
        Libro libro = new Libro(isbn, titulo, autor);

        // Assert
        assertEquals(isbn, libro.getIsbn());
        assertEquals(titulo, libro.getTitulo());
        assertEquals(autor, libro.getAutor());
        assertEquals(EstadoLibro.DISPONIBLE, libro.getEstado());
    }

    @Test
    public void testCambioEstadoDelLibro() {
        // Arrange
        Libro libro = new Libro("978-1234567890", "El Principito", "Antoine de Saint-Exupéry");

        // Act
        libro.setEstado(EstadoLibro.PRESTADO);

        // Assert
        assertEquals(EstadoLibro.PRESTADO, libro.getEstado());
    }
}
