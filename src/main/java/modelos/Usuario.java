/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@NamedQueries(
        {
            @NamedQuery(name = "Usuario.findByNombreAndClave", query = "select u from Usuario u where u.nombre = :nombre and u.clave = :clave"),
            @NamedQuery(name = "Usuario.findAll", query = "select u from Usuario u"),
            @NamedQuery(name = "Usuario.findInvitadosById", query = "select u.invitados from Usuario u where u.id = :valor")
        }
)
@Entity
public class Usuario extends UsuarioGenerico implements Serializable {

    @NotNull
    @Size(min = 3, max = 8)
    private String nombre;
    @NotNull
    @Size(min = 3, max = 8)
    private String clave;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Contenido> contenidos;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> invitados;

    public List<Contenido> getContenidos() {
        if (contenidos == null) {
            contenidos = new ArrayList<>();
        }
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public List<Usuario> getInvitados() {
        if (invitados == null) {
            invitados = new ArrayList<>();
        }
        return invitados;
    }

    public void setInvitados(List<Usuario> invitados) {
        this.invitados = invitados;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.clave);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", clave=" + clave + ", contenidos=" + contenidos + ", invitados=" + invitados + '}';
    }

}
