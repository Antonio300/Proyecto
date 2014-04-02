package validaciones;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrador
 */
@ControllerAdvice
public class GestorErrores {

    @ExceptionHandler(Exception.class)
    public ModelAndView errorGeneral(Exception e) {
        
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("excepcion", e);
        return mav;
    }
}
