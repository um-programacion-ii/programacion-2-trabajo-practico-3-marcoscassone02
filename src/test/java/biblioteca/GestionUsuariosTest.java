package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

public class GestionUsuariosTest {

    @Mock
    private Usuario usuarioMock;
    @Mock
    private Prestamo prestamoMock;

    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios = new GestionUsuarios();
    }

    @Test
    public void testRegistrarUsuarioExitoso() throws Exception {
        // Arrange
        String nombreUsuario = "Juan";

        // Act
        gestionUsuarios.registrarUsuario(nombreUsuario);

        // Assert
        Usuario usuario = gestionUsuarios.obtenerUsuario(nombreUsuario);
        assertNotNull(usuario);
        assertEquals(nombreUsuario, usuario.getNombre());
    }

    @Test
    public void testRegistrarUsuarioExistente() {
        // Arrange
        String nombreUsuario = "Juan";
        try {
            gestionUsuarios.registrarUsuario(nombreUsuario);
        } catch (Exception e) {
            fail("No debería lanzar excepción en la primera registración");
        }

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            gestionUsuarios.registrarUsuario(nombreUsuario);
        });

        assertEquals("Usuario ya registrado.", exception.getMessage());
    }

    @Test
    public void testObtenerUsuarioNoExistente() {
        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            gestionUsuarios.obtenerUsuario("Carlos");
        });

        assertEquals("Usuario no encontrado.", exception.getMessage());
    }

    @Test
    public void testAgregarPrestamo() throws Exception {
        // Arrange
        Usuario usuarioMock = mock(Usuario.class);
        List<Prestamo> prestamos = new ArrayList<>();

        when(usuarioMock.getHistorialPrestamos()).thenReturn(prestamos);

        // Simulamos el comportamiento del método agregarPrestamo para que agregue al historial falso
        doAnswer(invoc -> {
            prestamos.add(prestamoMock);
            return null;
        }).when(usuarioMock).agregarPrestamo(prestamoMock);

        // Act
        usuarioMock.agregarPrestamo(prestamoMock);

        // Assert
        assertTrue(usuarioMock.getHistorialPrestamos().contains(prestamoMock));
        verify(usuarioMock, times(1)).getHistorialPrestamos();  // Verifica que se llamó una vez
    }


    @Test
    public void testManejoDeExcepcionEnPrestamo() throws Exception {
        // Arrange
        String nombreUsuario = "Juan";
        gestionUsuarios.registrarUsuario(nombreUsuario);
        Usuario usuario = gestionUsuarios.obtenerUsuario(nombreUsuario);

        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            // Simulamos que el historial de préstamos es null
            usuario.agregarPrestamo(null);
        });

        assertEquals("No se puede agregar un préstamo nulo.", exception.getMessage());
    }
}
