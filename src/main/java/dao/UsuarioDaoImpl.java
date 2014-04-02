/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelos.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelos.Contenido;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario guardar(Usuario usuario) {
        em.persist(usuario);
        return usuario.getId() == null ? null : usuario;
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        em.merge(usuario);
        return usuario;

    }

    @Override
    public Usuario borrar(Usuario usuario) {
        em.remove(usuario);
        return usuario;
    }

    @Override
    public Usuario identificacion(Usuario usuario) {
        TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByNombreAndClave", Usuario.class);
        q.setParameter("nombre", usuario.getNombre());
        q.setParameter("clave", usuario.getClave());
        try {
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuario> todos() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public List<Contenido> encontrarContenidosDe(Long id) {
        TypedQuery<Contenido> q = em.createNamedQuery("Contenido.findByUsuarioId", Contenido.class);
        q.setParameter("clave", id);
        return q.getResultList();
    }

    @Override
    public Usuario actualizarContenido(Long id, Contenido contenido) {
        Usuario usuar = em.find(Usuario.class, id);
        usuar.getContenidos().add(contenido);
        contenido.setUsuario(usuar);
        return usuar;
    }

    @Override
    public List<Usuario> invitados(Long id) {
        Query q = em.createNamedQuery("Usuario.findInvitadosById");
        q.setParameter("valor", id);
        return q.getResultList();
    }

    @Override
    public Usuario invitar(Usuario invita, Usuario invitado) {
        List<Usuario> invitados = invita.getInvitados();
        if (invitados.contains(invitado)) {
            return invita;
        } else {
            invita.getInvitados().add(invitado);
            return em.merge(invita);
        }
    }

    @Override
    public Usuario invitar(Long invitaId, Long invitadoId) {
        Usuario invita = em.find(Usuario.class, invitaId);
        Usuario invitado = em.find(Usuario.class, invitadoId);
        return invitar(invita, invitado);
    }

}
