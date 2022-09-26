package com.prueba.ControlClientesSpring.web;

import com.prueba.ControlClientesSpring.domain.Persona;
import com.prueba.ControlClientesSpring.servicio.PersonaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ControladorRun {
    
    @Autowired
    private PersonaService personaService;
    
    
    @GetMapping("/")
    public String inicio(Model model){
        
        List<Persona> personas = personaService.listarPersonas();
        
        //log.info("Ejecutando el controlador Spring MVC");
        
        model.addAttribute("personas", personas);
        return "index";
        
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        //redirect.addFlashAttribute("msgExito", "El contacto se ha guardado con exito");
        return "redirect:/";
    }
   
    @GetMapping("/editar/{idPersona}")
    public String editar (Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
