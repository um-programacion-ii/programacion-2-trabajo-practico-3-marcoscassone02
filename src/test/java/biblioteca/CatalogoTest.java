package biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {

    private Catalogo catalogo;

    @BeforeEach
    public void setUp() {
        catalogo = new Catalogo();
        catalogo.agregarLibro(new Libro("111", "Libro Uno", "Autor A"));
        catalogo.agregarLibro(new Libro("222", "Libro Dos", "Autor B"));
        catalogo.agregarLibro(new Libro("333", "Libro Tres", "Autor C"));
    }

    @Test
    public void testBuscarLibroExistente() {
        Libro libro = catalogo.buscarPorISBN("111");
        assertNotNull(libro);
        assertEquals("Libro Uno", libro.getTitulo());
    }

    @Test
    public void testBuscarLibroInexistente() {
        Libro libro = catalogo.buscarPorISBN("999");
        assertNull(libro);
    }

    @Test
    public void testObtenerLibrosDisponibles() {
        List<Libro> disponibles = catalogo.obtenerLibrosDisponibles();
        assertEquals(3, disponibles.size());
        assertTrue(disponibles.stream().anyMatch(l -> l.getIsbn().equals("111")));
        assertTrue(disponibles.stream().anyMatch(l -> l.getIsbn().equals("333")));
    }
}
