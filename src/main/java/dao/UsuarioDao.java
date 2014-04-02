/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelos.Contenido;
import modelos.Usuario;

/**
 *
 * @author Administrador
 */
public interface UsuarioDao {

    Usuario guardar(Usuario usuario);

    Usuario modificar(Usuario usuario);

    Usuario borrar(Usuario usuario);

    Usuario identificacion(Usuario usuario);

    List<Usuario> todos();

    public List<Contenido> encontrarContenidosDe(Long id);

    public Usuario actualizarContenido(Long id, Contenido contenido);

    List<Usuario> invitados(Long id);
    
    Usuario invitar(Usuario invita, Usuario invitado);
    
    Usuario invitar(Long invitaId, Long invitadoId);
}
