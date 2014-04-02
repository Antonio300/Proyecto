/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validaciones;

import modelos.Usuario;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrador
 */
public class UsuarioValidator implements Validator{
 @Override
    public boolean supports(Class clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.vacio", "El nombre está vacío");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clave", "clave.vacio", "La clave está vacía");   
      
        
        if (usuario.getNombre().length() < 3) {
            errors.rejectValue("nombre", "nombre.corto", "El nombre es muy corto");
        }
        if (usuario.getClave().length() < 3) {
            errors.rejectValue("clave", "clave.corto", "La clave es muy corta");
        }
         
    }   
}
