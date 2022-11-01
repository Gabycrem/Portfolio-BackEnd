
package com.portfolio.nm.Controller;

import com.portfolio.nm.Entity.Persona;
import com.portfolio.nm.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
/*@CrossOrigin(origins = "http://localhost:4200/")*/
@CrossOrigin(origins = "https://frontendnmac.web.app/")
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
    
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "Persona creada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "Persona Eliminada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        Persona persona = iPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        iPersonaService.savePersona(persona);
        return persona;      
    } 
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }
}