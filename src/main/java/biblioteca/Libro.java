package biblioteca;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private EstadoLibro estado;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    // Setters
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + isbn + '\'' +
                ", Título='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Estado=" + estado +
                '}';
    }
}
