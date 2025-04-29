package biblioteca;


public class Main {
    public static void main(String[] args) {
        // Crear un nuevo libro
        Libro libro = new Libro("978-1234567890", "El Principito", "Antoine de Saint-Exupéry");

        // Mostrar datos del libro
        System.out.println("📚 Libro creado:");
        System.out.println(libro);

        // Cambiar estado a PRESTADO
        libro.setEstado(EstadoLibro.PRESTADO);

        // Mostrar datos actualizados
        System.out.println("\n📕 Después de prestar el libro:");
        System.out.println(libro);
    }
}
