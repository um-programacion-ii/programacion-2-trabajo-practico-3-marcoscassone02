
public class Main {
    public static void main(String[] args) {
        // Crear instancia del catálogo
        Catalogo catalogo = new Catalogo();

        // Crear libros
        Libro libro1 = new Libro("123", "El Principito", "Antoine de Saint-Exupéry", EstadoLibro.DISPONIBLE);
        Libro libro2 = new Libro("456", "Cien años de soledad", "Gabriel García Márquez", EstadoLibro.PRESTADO);
        Libro libro3 = new Libro("789", "1984", "George Orwell", EstadoLibro.DISPONIBLE);

        // Agregar libros al catálogo
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
        catalogo.agregarLibro(libro3);

        // Buscar un libro por ISBN
        System.out.println("🔍 Buscando libro con ISBN 456...");
        Libro encontrado = catalogo.buscarPorISBN("456");
        if (encontrado != null) {
            System.out.println("✅ Libro encontrado: " + encontrado.getTitulo() + " por " + encontrado.getAutor());
        } else {
            System.out.println("❌ Libro no encontrado.");
        }

        // Mostrar libros disponibles
        System.out.println("\n📚 Libros disponibles:");
        for (Libro libro : catalogo.obtenerLibrosDisponibles()) {
            System.out.println("- " + libro.getTitulo() + " (ISBN: " + libro.getIsbn() + ")");
        }
    }
}
