/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import javax.annotation.PostConstruct;
import modelos.Contenido;
import modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicios.ServicioCuenta;

@Component
public class CargarBd {

    @Autowired
    private ServicioCuenta servicioCuenta;

    @PostConstruct
    public void cargandoBd() {
        Usuario u1 = new Usuario("Juan", "Juan1");
        Contenido c1 = new Contenido(u1, "Contenido de Juan1 primero");
        Contenido c2 = new Contenido(u1, "Contenido de Juan1 segundo");
        u1.getContenidos().add(c1);
        u1.getContenidos().add(c2);
        servicioCuenta.guardar(u1);

        Usuario u2 = new Usuario("Sonia", "Sonia1");
        Contenido c3 = new Contenido(u2, "Contenido de Sonia1 primero");
        Contenido c4 = new Contenido(u2, "Contenido de Sonia1 segundo");
        u2.getContenidos().add(c3);
        u2.getContenidos().add(c4);
        servicioCuenta.guardar(u2);

        servicioCuenta.invitar(u1, u2);
    }
}
