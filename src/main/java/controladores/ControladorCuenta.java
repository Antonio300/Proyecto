/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import javax.validation.Valid;
import modelos.Contenido;
import servicios.ServicioCuenta;
import modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrador
 */
@Controller
public class ControladorCuenta {

    @Autowired
    private ServicioCuenta servicioCuenta;

    @ModelAttribute("usuario")
    public Usuario getUsuario() {
        return new Usuario("Introduce nombre", "Introduce clave");
    }

    @ModelAttribute("contenido")
    public Contenido contenido() {
        return new Contenido(null, "Introduce un contenido");
    }

    @RequestMapping(value = "principal.html", method = RequestMethod.GET)
    public void mostrarPrincipal() {
    }

    @RequestMapping(value = "cuentanueva.html", method = RequestMethod.POST)
    public String procesarCuentaNueva(@ModelAttribute @Valid  Usuario usuario, Model model) {
        Boolean resultado = servicioCuenta.guardar(usuario);
        List<Contenido> contenidos = servicioCuenta.contenidos(usuario.getId());
        model.addAttribute("vacio", contenidos.isEmpty());
        model.addAttribute("contenidos", contenidos);

        List<Usuario> invitados = servicioCuenta.invitados(usuario);
        model.addAttribute("numeroInvitados", invitados.size());
        model.addAttribute("invitados", invitados);

        List<Usuario> amigoPotencial = servicioCuenta.amigosPotenciales(usuario);
        model.addAttribute("posibles", amigoPotencial);

        return "muro";
    }

    @RequestMapping(value = "identificacion.html", method = RequestMethod.GET)
    public String manejadorIdentGet() {
        return "identificacion";
    }

    @RequestMapping(value = "identificacion.html", method = RequestMethod.POST)
    public String procesarIdent(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario encontrado = servicioCuenta.identificacion(usuario);

        if (encontrado == null) {
            usuario.setId(0L);
            model.addAttribute("usuario", usuario);
            model.addAttribute("info", "Usuario inexistente");
            model.addAttribute("usuarios", servicioCuenta.usuariosRegistrados());
            return "resultado";
        } else {
            model.addAttribute("usuario", encontrado);
            List<Contenido> contenidos = servicioCuenta.contenidos(encontrado.getId());
            model.addAttribute("vacio", contenidos.isEmpty());
            model.addAttribute("contenidos", contenidos);

            List<Usuario> invitados = servicioCuenta.invitados(encontrado);
            model.addAttribute("numeroInvitados", invitados.size());
            model.addAttribute("invitados", invitados);

            List<Usuario> amigoPotencial = servicioCuenta.amigosPotenciales(encontrado);
            model.addAttribute("posibles", amigoPotencial);

            return "muro";
        }
    }

    @RequestMapping(value = "publicar.html", method = RequestMethod.POST)
    public String procesarPublicar(@RequestParam("ident") Long id, @Valid @ModelAttribute("contenido") Contenido contenido, Model model) {
        Usuario encontrado = servicioCuenta.publicar(id, contenido);
        model.addAttribute("usuario", encontrado);
        List<Contenido> contenidos = servicioCuenta.contenidos(encontrado.getId());
        model.addAttribute("vacio", contenidos.isEmpty());
        model.addAttribute("contenidos", contenidos);

        List<Usuario> invitados = servicioCuenta.invitados(encontrado);
        model.addAttribute("numeroInvitados", invitados.size());
        model.addAttribute("invitados", invitados);

        List<Usuario> amigoPotencial = servicioCuenta.amigosPotenciales(encontrado);
        model.addAttribute("posibles", amigoPotencial);

        return "muro";
    }

    @RequestMapping(value = "amigo.html", method = RequestMethod.GET)
    public String procesarAmigo(@RequestParam("ident1") Long id1, @RequestParam("ident2") Long id2,  Model model) {
        Usuario encontrado = servicioCuenta.invitar(id1, id2);
    
        model.addAttribute("usuario", encontrado);
        List<Contenido> contenidos = servicioCuenta.contenidos(encontrado.getId());
        model.addAttribute("vacio", contenidos.isEmpty());
        model.addAttribute("contenidos", contenidos);

        List<Usuario> invitados = servicioCuenta.invitados(encontrado);
        model.addAttribute("numeroInvitados", invitados.size());
        model.addAttribute("invitados", invitados);

        List<Usuario> amigoPotencial = servicioCuenta.amigosPotenciales(encontrado);
        model.addAttribute("posibles", amigoPotencial);
        
        return "muro";
    }

}
