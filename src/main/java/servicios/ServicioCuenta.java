/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import modelos.Contenido;
import modelos.Usuario;

/**
 *
 * @author Administrador
 */
public interface ServicioCuenta {

    Boolean guardar(Usuario usuario);

    Boolean modificar(Usuario usuario);

    Boolean borrar(Usuario usuario);

    Usuario identificacion(Usuario buscar);

    List<Usuario> usuariosRegistrados();
    
    public List<Usuario> amigosPotenciales(Usuario encontrado);
    
    public List<Contenido> contenidos(Long id);

    public Usuario publicar(Long id, Contenido contenido);

    List<Usuario> invitados(Usuario existente);
        
    Usuario invitar(Usuario invita, Usuario invitado);

    Usuario invitar(Long invitaId, Long invitadoId);
}
