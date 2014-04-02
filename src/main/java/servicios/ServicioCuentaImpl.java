/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import modelos.Usuario;
import dao.UsuarioDao;
import java.util.List;
import modelos.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioCuentaImpl implements ServicioCuenta {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Boolean guardar(Usuario usuario) {
        return usuarioDao.guardar(usuario) != null;
    }

    @Override
    public Boolean modificar(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        Usuario u = usuarioDao.modificar(usuario);
        if (u == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean borrar(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        Usuario u = usuarioDao.borrar(usuario);
        if (u == null) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> usuariosRegistrados() {
        return usuarioDao.todos();
    }
   
    @Override
    public List<Contenido> contenidos(Long id) {
        return usuarioDao.encontrarContenidosDe(id);
    }

    @Override
    public Usuario publicar(Long id, Contenido contenido) {
        return usuarioDao.actualizarContenido(id, contenido);
    }

    @Override
    public Usuario identificacion(Usuario buscar) {
        return usuarioDao.identificacion(buscar);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> invitados(Usuario existente) {
        return usuarioDao.invitados(existente.getId());
    }

    @Override
    public Usuario invitar(Usuario invita, Usuario invitado) {
        return usuarioDao.invitar(invita, invitado);
    }

    @Override
    public Usuario invitar(Long invitaId, Long invitadoId) {
        return usuarioDao.invitar(invitaId, invitadoId);
    }

    @Override
    public List<Usuario> amigosPotenciales(Usuario encontrado) {
        List<Usuario> todos = usuariosRegistrados();
        List<Usuario> invitados = invitados(encontrado);
        todos.remove(encontrado); 
        todos.removeAll(invitados);
        return todos;
    }
   
}
