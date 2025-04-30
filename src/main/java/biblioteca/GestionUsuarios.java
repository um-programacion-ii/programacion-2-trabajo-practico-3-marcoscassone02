package biblioteca;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {
    private Map<String, Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(String nombre) throws Exception {
        if (usuarios.containsKey(nombre)) {
            throw new Exception("Usuario ya registrado.");
        }
        usuarios.put(nombre, new Usuario(nombre, null));
    }

    public Usuario obtenerUsuario(String nombre) throws Exception {
        Usuario usuario = usuarios.get(nombre);
        if (usuario == null) {
            throw new Exception("Usuario no encontrado.");
        }
        return usuario;
    }
}
