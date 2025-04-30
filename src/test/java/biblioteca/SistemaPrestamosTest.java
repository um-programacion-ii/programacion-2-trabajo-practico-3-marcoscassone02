package biblioteca;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

public class SistemaPrestamosTest {

    @Mock
    private Libro libroMock;

    private SistemaPrestamos sistemaPrestamos;

    @BeforeEach
    public void setUp() {
        // Inicializa el mock y el sistema de préstamos
        MockitoAnnotations.openMocks(this);
        sistemaPrestamos = new SistemaPrestamos();
    }

    @Test
    public void testPrestarLibro() {
        // Arrancar el mock
        when(libroMock.getIsbn()).thenReturn("1234");
        when(libroMock.getTitulo()).thenReturn("El Gran Libro");
        when(libroMock.getAutor()).thenReturn("Autor Desconocido");
        when(libroMock.getEstado()).thenReturn(EstadoLibro.DISPONIBLE);

        // Prestar el libro
        sistemaPrestamos.agregarPrestamo(libroMock);

        // Verificar que el estado del libro cambió a PRESTADO
        verify(libroMock).setEstado(EstadoLibro.PRESTADO);

        // Asegurarse de que el préstamo se haya registrado en el sistema
        List<Prestamo> prestamos = sistemaPrestamos.obtenerPrestamos();
        assertEquals(1, prestamos.size(), "Debe haber un préstamo registrado.");

        // Verificar que el libro prestado es el correcto
        assertEquals(libroMock, prestamos.get(0).getLibro(), "El libro prestado debe ser el mismo.");
    }

    @Test
    public void testObtenerPrestamosPorLibro() {
        // Preparar el mock
        Libro libro1 = mock(Libro.class);
        Libro libro2 = mock(Libro.class);

        when(libro1.getIsbn()).thenReturn("1001");
        when(libro2.getIsbn()).thenReturn("1002");

        // Crear el sistema de préstamos y agregar préstamos
        SistemaPrestamos sistema = new SistemaPrestamos();
        sistema.agregarPrestamo(libro1);
        sistema.agregarPrestamo(libro2);

        // Obtener los préstamos por libro
        List<Prestamo> prestamosLibro1 = sistema.obtenerPrestamosPorLibro(libro1);

        // Verificar que se obtiene el préstamo correcto
        assertEquals(1, prestamosLibro1.size(), "Debe haber un préstamo para el libro 1.");
        assertEquals(libro1, prestamosLibro1.get(0).getLibro(), "El préstamo debe ser del libro 1.");

        List<Prestamo> prestamosLibro2 = sistema.obtenerPrestamosPorLibro(libro2);

        // Verificar que se obtiene el préstamo correcto para libro2
        assertEquals(1, prestamosLibro2.size(), "Debe haber un préstamo para el libro 2.");
        assertEquals(libro2, prestamosLibro2.get(0).getLibro(), "El préstamo debe ser del libro 2.");
    }

    @Test
    public void testSimulacionCatalogoLibros() {
        // Crear libros mock
        Libro libro1 = mock(Libro.class);
        Libro libro2 = mock(Libro.class);

        when(libro1.getIsbn()).thenReturn("1111");
        when(libro1.getTitulo()).thenReturn("Java Básico");

        when(libro2.getIsbn()).thenReturn("2222");
        when(libro2.getTitulo()).thenReturn("Patrones de Diseño");

        // Crear el catálogo (simulación)
        List<Libro> catalogo = List.of(libro1, libro2);

        // Simular que el sistema tiene estos libros
        SistemaPrestamos sistema = new SistemaPrestamos();
        sistema.agregarPrestamo(libro1);

        // Verificar que el libro 1 está prestado
        assertEquals(1, sistema.obtenerPrestamos().size(), "Debe haber un préstamo.");
        assertEquals(libro1, sistema.obtenerPrestamos().get(0).getLibro(), "El préstamo debe ser del libro 1.");
    }
}
